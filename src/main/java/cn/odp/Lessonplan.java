/**
 * @auther gsunwu@163.com
 * @create 2021 04 12 20:55
 */

package cn.odp;

import cn.odp.lib.Utils;
import lombok.extern.slf4j.Slf4j;
import org.odftoolkit.odfdom.dom.attribute.svg.SvgHeightAttribute;
import org.odftoolkit.odfdom.dom.attribute.svg.SvgWidthAttribute;
import org.odftoolkit.odfdom.dom.attribute.svg.SvgXAttribute;
import org.odftoolkit.odfdom.dom.attribute.svg.SvgYAttribute;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

@Slf4j
abstract public class Lessonplan implements ILessonplan {

    protected Double left;
    protected Double top;
    protected Double height;
    protected Double width;

    protected void parseElementPosition(Node node) {
        NamedNodeMap attributes = node.getAttributes();
        for (int i = 0; attributes != null && i < attributes.getLength(); i++) {
            Node item = attributes.item(i);
            this.parsePosition(item);
        }
    }

    private void parsePosition(Node item) {
        if (item instanceof SvgXAttribute) {
            this.left = Utils.in2double(((SvgXAttribute) item).getValue());
        } else if (item instanceof SvgYAttribute) {
            this.top = Utils.in2double(((SvgYAttribute) item).getValue());
        } else if (item instanceof SvgHeightAttribute) {
            this.height = Utils.in2double(((SvgHeightAttribute) item).getValue());
        } else if (item instanceof SvgWidthAttribute) {
            this.width = Utils.in2double(((SvgWidthAttribute) item).getValue());
        } else {
            log.warn("unsupported attr {}", item);
        }

    }


    protected String generateCssPosition() {
        if (left == null || width == null) {
            log.warn("generateCssPosition is null");
            return null;
        }
        return "left:" + left + "in;" +
                "top:" + top + "in;" +
                "height:" + height + "in;" +
                "width:" + width + "in;";
    }
}
