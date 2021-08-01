package com.andreas.service;

import com.andreas.dto.CourseLessonDTO;
import com.andreas.dto.CourseSectionDTO;
import com.andreas.vo.CourseSectionVO;
import com.andreas.vo.CourseVO;

import java.util.List;

/**
 * 描述：
 */
public interface CourseContentService {
    /**
     * @Author: andreaszhou
     * @Description: 根据课程id查找对应的课程的章节和课程的信息
     * @DateTime: 2021/7/21 14:47
     * @Params: courseId
     * @Return
     */
    List<CourseSectionVO> findSectionAndLesson(Integer courseId);

    /**
     * @Author: andreaszhou
     * @Description: 更新章节的状态
     * @DateTime: 2021/7/21 16:41
     * @Params:
     * @Return
     */
    void updateSectionStatus(CourseSectionDTO dto);

    /**
     * @Author: andreaszhou
     * @Description: 新建&修改章节信息
     * @DateTime: 2021/7/21 21:33
     * @Params: dto
     * @Return
     */
    void updateSection(CourseSectionDTO dto);

    /**
     * @Author: andreaszhou
     * @Description: 新建&修改章节信息
     * @DateTime: 2021/7/21 21:33
     * @Params: dto
     * @Return
     */
    void saveSection(CourseSectionDTO dto);

    /**
     * @Author: andreaszhou
     * @Description: TODO
     * @DateTime: 2021/7/21 21:29
     * @Params: 修改课时信息
     * @Return
     */
    void updateLesson(CourseLessonDTO dto);

    /**
     * @Author: andreaszhou
     * @Description: TODO
     * @DateTime: 2021/7/21 21:29
     * @Params: 新建课时信息
     * @Return
     */
    void saveLesson(CourseLessonDTO dto);

    /**
     * @Author: andreaszhou
     * @Description: 回显章节对应的课程信息
     * @DateTime: 2021/7/28 18:46
     * @Params: courseId
     * @Return CourseVO
     */
    CourseVO findCourseById(Integer courseId);
}
