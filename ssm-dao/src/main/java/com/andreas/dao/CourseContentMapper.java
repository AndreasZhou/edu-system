package com.andreas.dao;

import com.andreas.domain.Course;
import com.andreas.domain.CourseLesson;
import com.andreas.domain.CourseSection;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：CourseContentMapper接口
 */
public interface CourseContentMapper {
    /**
     * @Author: andreaszhou
     * @Description: 查询课程的章节和对应的课程信息
     * @DateTime: 2021/7/21 21:18
     * @Params: courseId
     * @Return
     */
    List<CourseSection> findSectionAndLesson(@Param("courseId") Integer courseId);

    /**
     * @Author: andreaszhou
     * @Description: 更新章节的状态
     * @DateTime: 2021/7/21 16:41
     * @Params: dto
     * @Return
     */
    void updateSectionStatus(@Param("courseSection") CourseSection courseSection);

    /**
     * @Author: andreaszhou
     * @Description: 修改章节信息
     * @DateTime: 2021/7/21 21:33
     * @Params: dto
     * @Return
     */
    void updateSection(@Param("courseSection") CourseSection courseSection);

    /**
     * @Author: andreaszhou
     * @Description: 新建章节信息
     * @DateTime: 2021/7/21 21:33
     * @Params: dto
     * @Return
     */
    void saveSection(@Param("courseSection") CourseSection courseSection);

    /**
     * @Author: andreaszhou
     * @Description: 修改课时信息
     * @DateTime: 2021/7/22 10:51
     * @Params: dto
     * @Return
     */
    void updateLesson(@Param("courseLesson") CourseLesson courseLesson);

    /**
     * @Author: andreaszhou
     * @Description: 保存课时信息
     * @DateTime: 2021/7/22 10:51
     * @Params: dto
     * @Return
     */
    void saveLesson(@Param("courseLesson") CourseLesson courseLesson);

    /**
     * @Author: andreaszhou
     * @Description: 回显章节对应的课程信息
     * @DateTime: 2021/7/28 18:46
     * @Params: courseId
     * @Return Course
     */
    Course findCourseById(@Param("courseId") Integer courseId);
}
