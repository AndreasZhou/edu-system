package com.andreas.service;

import com.andreas.dto.CourseLessonDTO;
import com.andreas.dto.CourseSectionDTO;
import com.andreas.vo.CourseSectionVO;

import java.util.List;

/**
 * 描述：
 */
public interface CourseContentService {
    List<CourseSectionVO> findSectionAndLesson(Integer courseId);

    void updateSectionStatus(CourseSectionDTO dto);

    void updateSection(CourseSectionDTO dto);

    void saveSection(CourseSectionDTO dto);

    void updateLesson(CourseLessonDTO dto);

    void saveLesson(CourseLessonDTO dto);
}
