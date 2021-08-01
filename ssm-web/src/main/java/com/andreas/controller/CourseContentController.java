package com.andreas.controller;

import com.andreas.domain.ResponseResult;
import com.andreas.dto.CourseLessonDTO;
import com.andreas.dto.CourseSectionDTO;
import com.andreas.service.CourseContentService;
import com.andreas.vo.CourseSectionVO;
import com.andreas.vo.CourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述：CourseContentController
 */
@RestController
@RequestMapping("/courseContent")
public class CourseContentController {
    @Autowired
    private CourseContentService courseContentService;

    /**
     * @Author: andreaszhou
     * @Description: 根据课程id查找对应的课程的章节和课程的信息
     * @DateTime: 2021/7/21 14:47
     * @Params: courseId
     * @Return
     */
    @RequestMapping("/findSectionAndLesson")
    public ResponseResult findSectionAndLesson(@RequestParam("id") Integer courseId) {
        if (courseId == null) {
            return new ResponseResult(false, 300, "参数传递有误", null);
        }
        List<CourseSectionVO> courseSectionVOS = courseContentService.findSectionAndLesson(courseId);
        return new ResponseResult(true, 200, "响应成功", courseSectionVOS);
    }

    /**
     * @Author: andreaszhou
     * @Description: 更新章节的状态
     * @DateTime: 2021/7/21 16:41
     * @Params:
     * @Return
     */
    @RequestMapping("/updateSectionStatus")
    public ResponseResult updateSectionStatus(@RequestBody CourseSectionDTO dto) {
        if (dto.getId() == null) {
            return new ResponseResult(false, 300, "参数传递有误", null);
        }
        courseContentService.updateSectionStatus(dto);
        return new ResponseResult(true, 200, "修改成功", null);
    }

    /**
     * @Author: andreaszhou
     * @Description: 回显章节对应的课程信息，回显章节对应的课程信息
     * @DateTime: 2021/7/28 18:46
     * @Params: courseId
     * @Return responseResult
     */
    @RequestMapping("findCourseById")
    public ResponseResult findCourseById(@RequestParam("courseId") Integer courseId) {
        CourseVO courseVO = courseContentService.findCourseById(courseId);
        return new ResponseResult(true, 200, "响应成功", courseVO);
    }

    /**
     * @Author: andreaszhou
     * @Description: 新建&修改章节信息
     * @DateTime: 2021/7/21 21:33
     * @Params: dto
     * @Return ResponseResult
     */
    @RequestMapping("saveOrUpdateSection")
    public ResponseResult saveOrUpdateSection(@RequestBody CourseSectionDTO dto) {
        if (dto.getId() != null) {
            courseContentService.updateSection(dto);
            return new ResponseResult(true, 200, "修改成功", null);
        } else {
            courseContentService.saveSection(dto);
            return new ResponseResult(true, 200, "保存成功", null);
        }
    }

    /**
     * @Author: andreaszhou
     * @Description: TODO
     * @DateTime: 2021/7/21 21:29
     * @Params: 新建/修改课时信息
     * @Return
     */
    @RequestMapping("/saveOrUpdateLesson")
    public ResponseResult saveOrUpdateLesson(@RequestBody CourseLessonDTO dto) {
        if (dto.getId() != null) {
            courseContentService.updateLesson(dto);
            return new ResponseResult(true, 200, "修改成功", null);
        } else {
            courseContentService.saveLesson(dto);
            return new ResponseResult(true, 200, "保存成功", null);
        }
    }
}
