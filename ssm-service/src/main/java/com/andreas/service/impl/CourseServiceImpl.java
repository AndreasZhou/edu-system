package com.andreas.service.impl;

import com.andreas.dao.CourseMapper;
import com.andreas.domain.Course;
import com.andreas.domain.Teacher;
import com.andreas.dto.CourseDTO;
import com.andreas.service.CourseService;
import com.andreas.vo.CourseVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * 描述：CourseServiceImpl 实现类
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findCourseByCondition(CourseDTO dto) {
        List<Course> courseList = courseMapper.findCourseByCondition(dto);
        return courseList;
    }

    @Override
    public void saveCourseOrTeacher(CourseDTO dto) {
        Course course = new Course();
        BeanUtils.copyProperties(course,dto);
        Date date = new Date();
        course.setCreateTime(date);
        course.setUpdateTime(date);
        courseMapper.saveCourse(course);
        Teacher teacher = new Teacher();
        // 获取新插入数据的id值
        teacher.setCourseId(course.getId());
        BeanUtils.copyProperties(teacher,dto);
        teacher.setUpdateTime(date);
        teacher.setCreateTime(date);
        teacher.setIsDel(0); // 因为数据库设置了默认值，所以我们可以不用插入，默认为0就好
        courseMapper.saveTeacher(teacher);
    }

    @Override
    public void updateCourseOrTeacher(CourseDTO dto) {
        Date date = new Date();
        Course course = new Course();
        BeanUtils.copyProperties(dto,course);
        course.setUpdateTime(date);
        courseMapper.updateCourse(course);
        Teacher teacher = new Teacher();
        teacher.setUpdateTime(date);
        teacher.setCourseId(course.getId());
        BeanUtils.copyProperties(dto,teacher);
        courseMapper.updateTeacher(teacher);
    }

    @Override
    public void updateCourseStatus(CourseDTO dto) {
        courseMapper.updateCourseStatus(dto);
    }

    @Override
    public CourseVO findCourseById(Integer id) {
        CourseVO vo = courseMapper.findCourseById(id);
        return vo;
    }
}
