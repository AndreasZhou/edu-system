package com.andreas.dao;

import com.andreas.domain.Course;
import com.andreas.domain.CoursePageQuery;
import com.andreas.domain.Teacher;
import com.andreas.dto.CourseDTO;
import com.andreas.dto.CoursePageQueryDTO;
import com.andreas.vo.CourseVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：CourseMapper
 */
public interface CourseMapper {
    /**
     * @Author: andreaszhou
     * @Description: 通过条件查找课程信息
     * @DateTime: 2021/7/21 13:34
     * @Params: dto
     * @Return
     */
    List<Course> findCourseByCondition(@Param("coursePageQuery") CoursePageQuery coursePageQuery);

    /**
     * @Author: andreaszhou
     * @Description: 保存课程信息
     * @DateTime: 2021/7/21 13:34
     * @Params: course
     * @Return
     */
    void saveCourse(@Param("course") Course course);

    /**
     * @Author: andreaszhou
     * @Description: 保存教师信息
     * @DateTime: 2021/7/21 13:35
     * @Params: teacher
     * @Return
     */
    void saveTeacher(@Param("teacher") Teacher teacher);

    /**
     * @Author: andreaszhou
     * @Description: 更新课程信息
     * @DateTime: 2021/7/21 13:35
     * @Params: course
     * @Return
     */
    void updateCourse(@Param("course") Course course);

    /**
     * @Author: andreaszhou
     * @Description: 更新教师信息
     * @DateTime: 2021/7/21 13:36
     * @Params: teacher
     * @Return
     */
    void updateTeacher(@Param("teacher") Teacher teacher);

    /**
     * @Author: andreaszhou
     * @Description: 修改课程转态
     * @DateTime: 2021/7/21 14:07
     * @Params: dto
     * @Return
     */
    void updateCourseStatus(@Param("course") Course course);

    /**
     * @Author: andreaszhou
     * @Description: 通过id查询课程信息，回显
     * @DateTime: 2021/7/21 14:18
     * @Params: id
     * @Return CourseVO
     */
    Course findCourseById(@Param("id") Integer id);
}
