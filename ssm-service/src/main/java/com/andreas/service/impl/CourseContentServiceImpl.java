package com.andreas.service.impl;

import com.andreas.bo.CourseSectionBO;
import com.andreas.dao.CourseContentMapper;
import com.andreas.domain.Course;
import com.andreas.domain.CourseLesson;
import com.andreas.domain.CourseSection;
import com.andreas.dto.CourseLessonDTO;
import com.andreas.dto.CourseSectionDTO;
import com.andreas.service.CourseContentService;
import com.andreas.vo.CourseLessonVO;
import com.andreas.vo.CourseSectionVO;
import com.andreas.vo.CourseVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 描述：CourseContentServiceImpl实现类
 */
@Service
public class CourseContentServiceImpl implements CourseContentService {
    @Autowired
    private CourseContentMapper courseContentMapper;

    /**
     * @Author: andreaszhou
     * @Description: 查询课程的章节和对应的课程信息
     * @DateTime: 2021/7/21 21:18
     * @Params: courseId
     * @Return
     */
    @Override
    public List<CourseSectionVO> findSectionAndLesson(Integer courseId) {
        List<CourseSectionBO> courseSectionBOS = courseContentMapper.findSectionAndLesson(courseId);
        List<CourseSectionVO> courseSectionVOS = new ArrayList<>();
        for (CourseSectionBO courseSectionBO : courseSectionBOS) {
            CourseSectionVO courseSectionVO = new CourseSectionVO();
            BeanUtils.copyProperties(courseSectionBO, courseSectionVO);
            List<CourseLessonVO> courseLessonVOS = new ArrayList<>();
            for (CourseLesson courseLesson : courseSectionBO.getLessonList()
            ) {
                CourseLessonVO courseLessonVO = new CourseLessonVO();
                BeanUtils.copyProperties(courseLesson, courseLessonVO);
                courseLessonVOS.add(courseLessonVO);
            }
            courseSectionVO.setLessonVOList(courseLessonVOS);
            courseSectionVOS.add(courseSectionVO);
        }
        return courseSectionVOS;
    }

    /**
     * @Author: andreaszhou
     * @Description: 递归代码模板
     * @DateTime: 2021/8/7 16:05
     * @Params:
     * @Return
     */
/*    public void  recursion(List<CourseSectionBO> sectionAndLesson,List<CourseSectionVO> courseSectionVOS){
        for (CourseSectionBO c: sectionAndLesson
             ) {
            CourseSectionVO courseSectionVO = new CourseSectionVO();
            BeanUtils.copyProperties(c,courseSectionVO);
            recursion();
        }
    }*/

    /**
     * @Author: andreaszhou
     * @Description: 更新章节的状态
     * @DateTime: 2021/7/21 16:41
     * @Params: dto
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSectionStatus(CourseSectionDTO dto) {
        CourseSection courseSection = new CourseSection();
        BeanUtils.copyProperties(dto, courseSection);
        Date date = new Date();
        courseSection.setUpdateTime(date);
        courseContentMapper.updateSectionStatus(courseSection);
    }

    /**
     * @Author: andreaszhou
     * @Description: 修改章节信息
     * @DateTime: 2021/7/21 21:33
     * @Params: dto
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSection(CourseSectionDTO dto) {
        CourseSection courseSection = new CourseSection();
        BeanUtils.copyProperties(dto, courseSection);
        Date date = new Date();
        courseSection.setUpdateTime(date);
        courseContentMapper.updateSection(courseSection);
    }

    /**
     * @Author: andreaszhou
     * @Description: 新建章节信息
     * @DateTime: 2021/7/21 21:33
     * @Params: dto
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveSection(CourseSectionDTO dto) {
        CourseSection courseSection = new CourseSection();
        BeanUtils.copyProperties(dto, courseSection);
        Date date = new Date();
        courseSection.setCreateTime(date);
        courseSection.setUpdateTime(date);
        courseContentMapper.saveSection(courseSection);
    }

    /**
     * @Author: andreaszhou
     * @Description: 修改课时信息
     * @DateTime: 2021/7/22 10:51
     * @Params: dto
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateLesson(CourseLessonDTO dto) {
        CourseLesson courseLesson = new CourseLesson();
        BeanUtils.copyProperties(dto, courseLesson);
        Date date = new Date();
        courseLesson.setUpdateTime(date);
        courseContentMapper.updateLesson(courseLesson);
    }

    /**
     * @Author: andreaszhou
     * @Description: 保存课时信息
     * @DateTime: 2021/7/22 10:51
     * @Params: dto
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveLesson(CourseLessonDTO dto) {
        CourseLesson courseLesson = new CourseLesson();
        BeanUtils.copyProperties(dto, courseLesson);
        Date date = new Date();
        courseLesson.setUpdateTime(date);
        courseLesson.setCreateTime(date);
        courseContentMapper.saveLesson(courseLesson);
    }

    /**
     * @Author: andreaszhou
     * @Description: 回显章节对应的课程信息
     * @DateTime: 2021/7/28 18:46
     * @Params: courseId
     * @Return CourseVO
     */
    @Override
    public CourseVO findCourseById(Integer courseId) {
        CourseVO courseVO = new CourseVO();
        Course course = courseContentMapper.findCourseById(courseId);
        BeanUtils.copyProperties(course, courseVO);
        return courseVO;
    }

    /**
     * @Author: andreaszhou
     * @Description: 更新课时状态
     * @DateTime: 2021/8/7 17:19
     * @Params: dto
     * @Return
     */
    @Override
    public void updateLessonStatus(CourseLessonDTO dto) {
        CourseLesson courseLesson = new CourseLesson();
        BeanUtils.copyProperties(dto, courseLesson);
        courseContentMapper.updateLessonStatus(courseLesson);
    }

    /**
     * @Author: andreaszhou
     * @Description: 编辑章节信息回显
     * @DateTime: 2021/8/7 17:32
     * @Params: courseLessonId
     * @Return
     */
    @Override
    public CourseLessonVO showCourseLesson(Integer courseLessonId) {
        CourseLesson courseLesson = courseContentMapper.showCourseLesson(courseLessonId);
        CourseLessonVO courseLessonVO = new CourseLessonVO();
        BeanUtils.copyProperties(courseLesson, courseLessonVO);
        return courseLessonVO;
    }

    /**
     * @Author: andreaszhou
     * @Description: 编辑章节信息回显
     * @DateTime: 2021/8/7 17:52
     * @Params: dto
     * @Return
     */
    @Override
    public CourseSectionVO showCourseSection(Integer courseSectionId) {
        CourseSection courseSection = courseContentMapper.showCourseSection(courseSectionId);
        CourseSectionVO courseSectionVO = new CourseSectionVO();
        BeanUtils.copyProperties(courseSection,courseSectionVO);
        return courseSectionVO;
    }
}
