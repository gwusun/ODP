## 页面的宽高如何获得
通过 page（content.xml) 的属性 draw:master-page-name="Master1-Layout1-title-Title-Slide" 中的 Master1-Layout1-title-Title-Slide 定位到

(styles.xml) 中的  <style:master-page style:name="Master1-Layout1-title-Title-Slide" style:page-layout-name="pageLayout1"
draw:style-name="a61">，其中的 style:page-layout-name="pageLayout1" 中的 pageLayout1 中就包含 ppt 的宽高
```
    <office:automatic-styles>
        <style:page-layout style:name="pageLayout1">
            <style:page-layout-properties 
            fo:page-width="13.33333in"  // ppt 的宽
            fo:page-height="7.5in"      // ppt 的高
            style:print-orientation="landscape" 
            style:register-truth-ref-style-name=""/>
        </style:page-layout>

```


## 存文本与公式
``` 
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

```