/**
 * @auther gsunwu@163.com
 * @create 2021 04 11 15:26
 */

package cn.odp.lib;

import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

@Slf4j
public class Utils {
    /**
     * 方法用来处理全局的单位，默认是 in
     * 当需要改单位时，改这个方法就全部改了
     *
     * @param str
     * @return
     */
    public static String getCssUnitValue(String str) {
        return str;
    }


    public static Double in2double(String in) {
        if (in.endsWith("in")) {
            return Double.parseDouble(in.substring(0, in.length() - 2));
        } else {
            log.error("cant parse to double for {}", in);
            return null;
        }

    }

    /**
     * 判断 draw:frame 是否是存文本
     * 如果 drame:frame 只有 :
     * draw:frame
     * --draw:text-box
     * ----text:p
     * ------text:span
     * 那么该frame 为存文本
     * <p>
     * 如果 drame:frame 有:
     * draw:frame
     * --draw:text-box
     * ----text:p
     * ------draw:frame
     * --------draw:object
     * 那么该 frame 为 公式
     *
     * @return
     */

    public static EnumElementType getEleType(Node slideEle) {
        Element ele = (Element) slideEle;
        if (ele == null) {
            return EnumElementType.TYPE_UNKNOWN;
        }

        //存文本
        if (ele.getElementsByTagName(EnumXMLTagName.TEXT_BOX).getLength() > 0 //有 TEXT_BOX
                && ele.getElementsByTagName(EnumXMLTagName.DRAW_FRAME).getLength() == 0 //没有 DRAW_FRAME
                && ele.getElementsByTagName(EnumXMLTagName.DRAW_OBJECT).getLength() == 0//meiyou draw:object
        ) {
            return EnumElementType.TYPE_SIMPLE_TEXT;
        } else {
            log.warn("unsupported element type");
            return EnumElementType.TYPE_UNKNOWN;
        }
    }
}
