package com.andreas.service.impl;

import com.andreas.bo.CourseBO;
import com.andreas.dao.CourseMapper;
import com.andreas.domain.Course;
import com.andreas.domain.Teacher;
import com.andreas.dto.CourseDTO;
import com.andreas.dto.CoursePageQueryDTO;
import com.andreas.service.CourseService;
import com.andreas.vo.CourseVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 描述：CourseServiceImpl 实现类
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    /**
     * @Author: andreaszhou
     * @Description: 根据搜索条件查询课程信息
     * @DateTime: 2021/7/21 8:41
     * @Params: dto
     * @Return: ResponseResultVO
     */
    @Override
    public PageInfo<Course> findCourseByCondition(CoursePageQueryDTO dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        CourseBO courseBO = new CourseBO();
        BeanUtils.copyProperties(dto, courseBO);
        List<Course> courseList = courseMapper.findCourseByCondition(courseBO);
        return new PageInfo<>(courseList);
    }

    /**
     * @Author: andreaszhou
     * @Description: 新建课程
     * @DateTime: 2021/7/21 14:02
     * @Params: dto
     * @Return: ResponseResultVO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveCourseOrTeacher(CourseDTO dto) {
        // 在保存的时候，需要使用的是Course和Teacher两个实体类
        Course course = new Course();
        BeanUtils.copyProperties(dto, course);
        Date date = new Date();
        course.setCreateTime(date);
        course.setUpdateTime(date);
        courseMapper.saveCourse(course);
        Teacher teacher = new Teacher();
        // 获取新插入数据的id值
        teacher.setCourseId(course.getId());
        BeanUtils.copyProperties(dto, teacher);
        teacher.setUpdateTime(date);
        teacher.setCreateTime(date);
        teacher.setIsDel(0); // 因为数据库设置了默认值，所以我们可以不用插入，默认为0就好
        courseMapper.saveTeacher(teacher);
    }

    /**
     * @Author: andreaszhou
     * @Description: 编辑课程
     * @DateTime: 2021/7/21 14:02
     * @Params: dto
     * @Return: ResponseResultVO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCourseOrTeacher(CourseDTO dto) {
        Date date = new Date();
        Course course = new Course();
        BeanUtils.copyProperties(dto, course);
        course.setUpdateTime(date);
        courseMapper.updateCourse(course);
        Teacher teacher = new Teacher();
        teacher.setUpdateTime(date);
        teacher.setCourseId(course.getId());
        BeanUtils.copyProperties(dto, teacher);
        courseMapper.updateTeacher(teacher);
    }

    /**
     * @Author: andreaszhou
     * @Description: 修改课程转态
     * @DateTime: 2021/7/21 14:06
     * @Params: dto
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCourseStatus(CourseDTO dto) {
        Course course = new Course();
        BeanUtils.copyProperties(dto, course);
        Date date = new Date();
        course.setUpdateTime(date);
        courseMapper.updateCourseStatus(course);
    }

    /**
     * @Author: andreaszhou
     * @Description: 通过id查询课程信息，回显
     * @DateTime: 2021/7/21 14:18
     * @Params: id
     * @Return CourseVO
     */
    @Override
    @Transactional(readOnly = true)
    public CourseVO findCourseById(Integer id) {
        CourseBO courseBO = courseMapper.findCourseById(id);
        CourseVO vo = new CourseVO();
        BeanUtils.copyProperties(courseBO, vo);
        return vo;
    }
}
