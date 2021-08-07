package com.andreas.bo;

import com.andreas.domain.CourseLesson;
import com.andreas.domain.CourseSection;
import lombok.Data;

import java.util.List;

/**
 * 章节类CourseSectionBO
 */
@Data
public class CourseSectionBO extends CourseSection {

    // 课时集合
    private List<CourseLesson> lessonList;

}
