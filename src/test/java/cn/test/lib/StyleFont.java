/**
 * @auther gsunwu@163.com
 * @create 2021 04 11 16:20
 */

package cn.test.lib;

import lombok.Data;

// 默认单位 in
@Data
public class StyleFont
{


    private Double top;
    private Double right;
    private Double height;
    private Double left;
    private Double width;
    private Double verticalAlign;
    private Double fontSize;
    private Double letterSpacing;
    private Double lineHeight;
    private Double textIndent;
    private String fontWeight;
    private String color;
    private String display;
    private String fontFamily;
    private String fontStyle;
    private String fontVariantCaps;
    private String fontVariantEastAsian;
    private String fontVariantLigatures;
    private String fontVariantNumeric;
    private String textAlign;
    private String textTransform;


    public String getStyle() {
        return
                "vertical-align:" + verticalAlign +";"+
                "font-size:" + fontSize +"in;" +
                "letter-spacing:" + letterSpacing +"in;" +
                "line-height:" + lineHeight +"in;" +
                "text-indent:" + textIndent +"in;" +
                "font-weight:" + fontWeight + "in;" +
                "color:" + color + ";"+
                "display:" + display +";"+
                "font-family:" + fontFamily + ";"+
                "font-style:" + fontStyle + ";"+
                "font-variant-caps:" + fontVariantCaps +";"+
                "font-variant-east-asian:" + fontVariantEastAsian +";"+
                "font-variant-ligatures:" + fontVariantLigatures +";"+
                "font-variant-numeric:" + fontVariantNumeric + ";"+
                "text-align:" + textAlign +";"+
                "text-transform:" + textTransform + ";";
    }
}
