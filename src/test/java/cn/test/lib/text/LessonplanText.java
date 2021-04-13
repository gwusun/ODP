package cn.test.lib.text;

import cn.test.EnumFamily;
import cn.test.Lessonplan;
import cn.test.Utils;
import cn.test.lib.EnumStyleFont;
import cn.test.lib.StyleFont;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Element;
import org.odftoolkit.odfdom.dom.element.draw.DrawFrameElement;
import org.odftoolkit.odfdom.dom.element.text.TextSpanElement;
import org.odftoolkit.odfdom.incubator.doc.style.OdfStyle;
import org.odftoolkit.odfdom.incubator.doc.text.OdfTextSpan;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import java.io.IOException;

@Slf4j
/**
 * <draw:frame draw:id="id69" draw:style-name="a733" draw:name="文本框 7" svg:x="5.68182in" svg:y="2.13636in"
 *             svg:width="1.81828in" svg:height="0.70684in">
 *             ...
 * </draw:frame>
 * <presentation:notes draw:style-name="a742">
 *      ...
 * </presentation:notes>
 */
public class LessonplanText extends Lessonplan {


    protected Node slideEle;

    public LessonplanText(Node slideEle) {
        this.slideEle = slideEle;

    }

    @Override

    /**
     <draw:frame draw:id="id69" draw:style-name="a733" draw:name="文本框 7" svg:x="5.68182in" svg:y="2.13636in"
     svg:width="1.81828in" svg:height="0.70684in">
     ...
     </draw:frame>

     */
    public String getResoult() throws IOException {

        Element div = new Element("div");
        this.parseNode(this.slideEle, div);
        return div.outerHtml();

    }


    /**
     * 递归解析文本
     *
     * @param slideEle
     * @param context
     */
    private void parseNode(Node slideEle, Element context) {

//        位置参数 x,y,top,left
        this.parseElementPosition(slideEle);




        if (slideEle instanceof DrawFrameElement) {
            String style = "position:absolute;" + this.generateCssPosition();
            context.attr("style", style);
        } else if (slideEle instanceof TextSpanElement) {
            //文本 text:span
            StyleFont styleFont = new StyleFont();
            OdfStyle mStyleParent = ((TextSpanElement) slideEle).getAutomaticStyle();
            if (mStyleParent.getFamilyName().equals(EnumFamily.TEXT.getFamily())) {
                Node firstChild = mStyleParent.getFirstChild();
                NamedNodeMap attributes1 = firstChild.getAttributes();
                for (int i = 0; i < attributes1.getLength(); i++) {
                    Node item = attributes1.item(i);
                    String localName = item.getLocalName();
                    String value = item.getNodeValue();

                    if (EnumStyleFont.FONT_SIZE.getText().equals(localName)) {
                        styleFont.setFontSize(Utils.in2double(value));

                    } else if (EnumStyleFont.FONT_WEIGHT.getText().equals(localName)) {
                        styleFont.setFontWeight(value);

                    } else if (EnumStyleFont.FONT_FAMILY.getText().equals(localName)) {
                        styleFont.setFontFamily(value);

                    } else if (EnumStyleFont.COLOR.getText().equals(localName)) {
                        styleFont.setColor(value);

                    } else if (EnumStyleFont.LETTER_SPACING.getText().equals(localName)) {
                        styleFont.setLetterSpacing(Utils.in2double(value));
                    } else {
                        log.warn("unprocessed {}", localName);
                    }

                }
                context.attr("style", styleFont.getStyle());

            } else {
                log.warn("unprocessed style family:{}", mStyleParent.getFamily());
            }

        }


        if (slideEle instanceof OdfTextSpan) {
//            如果是文本元素，提出文本
            context.append(slideEle.getTextContent());
        }
        if (slideEle.hasChildNodes()) {
            for (int j = 0; j < slideEle.getChildNodes().getLength(); j++) {
                Element span = new Element("span");
                context.appendChild(span);
                this.parseNode(slideEle.getChildNodes().item(j), span);

            }
        }
    }


}
