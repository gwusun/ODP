package cn.test;

// Copyright 2020 Sebastian Kuerten
//
// This file is part of odftoolkit-samples.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.


import cn.test.lessonplan.LessonplanSlide;
import cn.test.lib.EnumXMLTag;
import cn.test.lib.text.EnumElementType;
import cn.test.lib.text.LessonplanText;
import lombok.extern.slf4j.Slf4j;
import org.odftoolkit.odfdom.doc.OdfPresentationDocument;
import org.odftoolkit.odfdom.doc.presentation.OdfSlide;
import org.odftoolkit.odfdom.dom.element.draw.DrawFrameElement;
import org.odftoolkit.odfdom.dom.element.draw.DrawPageElement;
import org.odftoolkit.odfdom.dom.element.presentation.PresentationNotesElement;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;

/*
 * Load a file from the resources directory and print its plain text content
 */
@Slf4j
public class PrintSamplePlainText {

    public static void main(String[] args) throws Exception {
        String file = "ppts/formula.odp";
        OdfPresentationDocument odfPresentationDocument = OdfPresentationDocument.loadDocument(new File(file));

        Iterator<OdfSlide> slides = odfPresentationDocument.getSlides();
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "     <title>haha</title>\n" +
                "</head><body>");
        while (slides.hasNext()) {


//           ppt中的每一页 slide
            OdfSlide slide = slides.next();
            LessonplanSlide lessonplanSlide = new LessonplanSlide();


            // todo 获取 slide  的宽高
            /**
             * ## 页面的宽高如何获得
             * 通过 page（content.xml) 的属性 draw:master-page-name="Master1-Layout1-title-Title-Slide" 中的 Master1-Layout1-title-Title-Slide 定位到
             *
             * (styles.xml) 中的  <style:master-page style:name="Master1-Layout1-title-Title-Slide" style:page-layout-name="pageLayout1"
             * draw:style-name="a61">，其中的 style:page-layout-name="pageLayout1" 中的 pageLayout1 中就包含 ppt 的宽高
             * ```
             *     <office:automatic-styles>
             *         <style:page-layout style:name="pageLayout1">
             *             <style:page-layout-properties
             *             fo:page-width="13.33333in"  // ppt 的宽
             *             fo:page-height="7.5in"      // ppt 的高
             *             style:print-orientation="landscape"
             *             style:register-truth-ref-style-name=""/>
             *         </style:page-layout>
             *
             * ```
             */
            lessonplanSlide.setHeight(13.33333D);
            lessonplanSlide.setWidth(7.5d);


//            解析 slide 的元素
            DrawPageElement odfElement = slide.getOdfElement();
            NodeList slideFrame = odfElement.getChildNodes();

            html.append("<div style='width:13.333in;height:7.5in;position:relative;border:1px solid red;'>");
            for (int i = 0; i < slideFrame.getLength(); i++) {

//                  draw:frame in one page
                /**
                 *           <draw:page
                 *                 ------ start -------
                 <draw:frame draw:id="id69" draw:style-name="a733" draw:name="文本框 7" svg:x="5.68182in" svg:y="2.13636in"
                 svg:width="1.81828in" svg:height="0.70684in">
                 ...
                 </draw:frame>
                 *                 <presentation:notes draw:style-name="a742">
                 *                      ...
                 *                 </presentation:notes>
                 *                 ----- end -------
                 *            </draw:page>
                 */
                Node slideEle = slideFrame.item(i);
                if (slideEle instanceof DrawFrameElement) { // <draw:page> 下的 <draw:frame>
                    /* 如果 drame:frame 只有 :
                        draw:frame
                          draw:text-box
                             text:p
                                text:span
                      那么该frame 为存文本

                      如果 drame:frame 有:
                     draw:frame
                        draw:text-box
                            text:p
                                draw:frame
                                    draw:object
                    那么该 frame 为 公式


                     */
                    EnumElementType eleType = Utils.getEleType(slideEle);

                    switch (eleType) {
                        case TYPE_SIMPLE_TEXT: {
                            LessonplanText lessonplanText = new LessonplanText(slideEle);
                            html.append(lessonplanText.getResoult());
                        }
                        break;
                        default:
                            log.warn("unprocessed draw frame {}", eleType);
                    }
//                    Node firstChild = slideEle.getFirstChild();
//                    Element ele = (Element) slideEle;
//                    NodeList childNode = ele.getElementsByTagName("draw:object");
//                    int length = childNode.getLength();
//                    NodeList childNodes = slideEle.getChildNodes();
////                    DrawFrame
//
//
//                    String type = slideEle.hasChildNodes() ? slideEle.getChildNodes().item(0).getNodeName() : null;
//                    if (type.equals(EnumXMLTag.TEXT_BOX)) {
//                        LessonplanText lessonplanText = new LessonplanText(slideEle);
//                        html.append(lessonplanText.getResoult());
//                    } else {
//
//                    }


                } else if (slideEle instanceof PresentationNotesElement) {
//                    注释
                } else {
                    log.error("unprocess type {}", slideEle.getNodeName());
                }
            }
            html.append("</div></body>\n" +
                    "</html>");

            NodeList curSlde = odfElement.getChildNodes();


        }

        FileWriter fileWriter = new FileWriter("out.html");
        fileWriter.write(html.toString());
        fileWriter.close();

    }

}