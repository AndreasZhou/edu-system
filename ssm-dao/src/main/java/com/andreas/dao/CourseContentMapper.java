package com.andreas.dao;

import com.andreas.dto.CourseLessonDTO;
import com.andreas.dto.CourseSectionDTO;
import com.andreas.vo.CourseSectionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：
 */
public interface CourseContentMapper {
    List<CourseSectionVO> findSectionAndLesson(@Param("courseId") Integer courseId);

    void updateSectionStatus(@Param("dto") CourseSectionDTO dto);

    void updateSection(@Param("dto") CourseSectionDTO dto);

    void saveSection(@Param("dto") CourseSectionDTO dto);

    void updateLesson(@Param("dto") CourseLessonDTO dto);

    void saveLesson(@Param("dto") CourseLessonDTO dto);
}
