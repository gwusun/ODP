package cn.test.lib;

//将 xml 中的所有属性对应过来
//            <style:text-properties fo:font-variant="normal" fo:text-transform="none" fo:color="#000000"
//                                   style:text-line-through-type="none" style:text-line-through-style="none"
//                                   style:text-line-through-width="auto" style:text-line-through-color="font-color"
//                                   style:text-position="0% 100%" fo:font-family="等线" style:font-family-asian="等线"
//                                   style:font-pitch-asian="variable" fo:font-size="0.16667in"
//                                   style:font-size-asian="0.16667in" style:font-size-complex="0.16667in"
//                                   fo:letter-spacing="0in" fo:language="en" fo:country="US" fo:font-style="normal"
//                                   style:font-style-asian="normal" style:font-style-complex="normal"
//                                   style:text-underline-type="none" style:text-underline-style="none"
//                                   style:text-underline-width="auto" style:text-underline-color="font-color"
//                                   fo:font-weight="normal" style:font-weight-asian="normal"
//                                   style:font-weight-complex="normal" style:text-underline-mode="continuous"
//                                   style:letter-kerning="true"/>
public enum EnumStyleFont {
    COLOR("color"),
    COUNTRY("country"),
    FONT_FAMILY("font-family"),
    FONT_SIZE("font-size"),
    FONT_STYLE("font-style"),
    FONT_VARIANT("font-variant"),
    FONT_WEIGHT("font-weight"),
    LANGUAGE("language"),
    LETTER_SPACING("letter-spacing"),
    TEXT_TRANSFORM("text-transform"),
    FONT_FAMILY_ASIAN("font-family-asian"),
    FONT_PITCH_ASIAN("font-pitch-asian"),
    FONT_SIZE_ASIAN("font-size-asian"),
    FONT_SIZE_COMPLEX("font-size-complex"),
    FONT_STYLE_ASIAN("font-style-asian"),
    FONT_STYLE_COMPLEX("font-style-complex"),
    FONT_WEIGHT_ASIAN("font-weight-asian"),
    FONT_WEIGHT_COMPLEX("font-weight-complex"),
    LETTER_KERNING("letter-kerning"),
    TEXT_LINE_THROUGH_COLOR("text-line-through-color"),
    TEXT_LINE_THROUGH_STYLE("text-line-through-style"),
    TEXT_LINE_THROUGH_TYPE("text-line-through-type"),
    TEXT_LINE_THROUGH_WIDTH("text-line-through-width"),
    TEXT_POSITION("text-position"),
    TEXT_UNDERLINE_COLOR("text-underline-color"),
    TEXT_UNDERLINE_MODE("text-underline-mode"),
    TEXT_UNDERLINE_STYLE("text-underline-style"),
    TEXT_UNDERLINE_TYPE("text-underline-type"),
    TEXT_UNDERLINE_WIDTH("text-underline-width");

    private String text;
    EnumStyleFont(String text) {
        this.text=text;
    }
    public String getText(){
        return this.text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
