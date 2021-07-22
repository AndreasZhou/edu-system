package com.andreas.service.impl;

import com.andreas.dao.CourseContentMapper;
import com.andreas.domain.Course;
import com.andreas.dto.CourseLessonDTO;
import com.andreas.dto.CourseSectionDTO;
import com.andreas.service.CourseContentService;
import com.andreas.vo.CourseSectionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 描述：
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
        List<CourseSectionVO> courseSectionVOS= courseContentMapper.findSectionAndLesson(courseId);
        return courseSectionVOS;
    }

    @Override
    public void updateSectionStatus(CourseSectionDTO dto) {
        Date date = new Date();
        dto.setUpdateTime(date);
        courseContentMapper.updateSectionStatus(dto);
    }

    /**
     * @Author: andreaszhou
     * @Description: 修改章节信息
     * @DateTime: 2021/7/21 21:33
     * @Params: dto
     * @Return
     */
    @Override
    public void updateSection(CourseSectionDTO dto) {
        Date date = new Date();
        dto.setUpdateTime(date);
        courseContentMapper.updateSection(dto);
    }

    /**
     * @Author: andreaszhou
     * @Description: 新建章节信息
     * @DateTime: 2021/7/21 21:33
     * @Params: dto
     * @Return
     */
    @Override
    public void saveSection(CourseSectionDTO dto) {
        Date date = new Date();
        dto.setCreateTime(date);
        dto.setUpdateTime(date);
        courseContentMapper.saveSection(dto);
    }
    /**
     * @Author: andreaszhou
     * @Description: 修改课时信息
     * @DateTime: 2021/7/22 10:51
     * @Params: dto
     * @Return
     */
    @Override
    public void updateLesson(CourseLessonDTO dto) {
        Date date = new Date();
        dto.setUpdateTime(date);
        courseContentMapper.updateLesson(dto);
    }
    /**
     * @Author: andreaszhou
     * @Description: 保存课时信息
     * @DateTime: 2021/7/22 10:51
     * @Params: dto
     * @Return
     */
    @Override
    public void saveLesson(CourseLessonDTO dto) {
        Date date = new Date();
        dto.setUpdateTime(date);
        dto.setCreateTime(date);
        courseContentMapper.saveLesson(dto);
    }
}
