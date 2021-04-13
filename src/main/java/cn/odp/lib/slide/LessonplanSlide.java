/**
 * @auther gsunwu@163.com
 * @create 2021 04 12 21:56
 */

package cn.odp.lib.slide;

import cn.odp.ILessonplan;
import lombok.Data;

import java.io.IOException;

@Data
public class LessonplanSlide implements ILessonplan {
    private double width;
    private double height;

    @Override
    public String getResoult() throws IOException {
        return null;
    }
}
