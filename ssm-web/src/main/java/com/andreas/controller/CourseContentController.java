package com.andreas.controller;

import com.andreas.dto.CourseLessonDTO;
import com.andreas.dto.CourseSectionDTO;
import com.andreas.service.CourseContentService;
import com.andreas.vo.CourseLessonVO;
import com.andreas.vo.CourseSectionVO;
import com.andreas.vo.CourseVO;
import com.andreas.vo.ResponseResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
     * @Description: 根据课程id查找对应的课程的章节和课时的信息
     * @DateTime: 2021/7/21 14:47
     * @Params: courseId
     * @Return
     */
    @RequestMapping("/findSectionAndLesson/{courseId}")
    public ResponseResultVO findSectionAndLesson(@PathVariable Integer courseId) {
        if (courseId == null) {
            return new ResponseResultVO(false, 300, "参数传递有误", null);
        }
        List<CourseSectionVO> courseSectionVOS = courseContentService.findSectionAndLesson(courseId);
        return new ResponseResultVO(true, 200, "响应成功", courseSectionVOS);
    }

    /**
     * @Author: andreaszhou
     * @Description: 更新章节的状态
     * @DateTime: 2021/7/21 16:41
     * @Params:
     * @Return
     */
    @RequestMapping("/updateSectionStatus")
    public ResponseResultVO updateSectionStatus(@RequestBody CourseSectionDTO dto) {
        if (dto.getId() == null) {
            return new ResponseResultVO(false, 300, "参数传递有误", null);
        }
        courseContentService.updateSectionStatus(dto);
        return new ResponseResultVO(true, 200, "修改成功", null);
    }

    /**
     * @Author: andreaszhou
     * @Description: 根据课程id查找对应的课程信息 获取对应的id和name
     * @DateTime: 2021/7/28 18:46
     * @Params: courseId
     * @Return responseResult
     */
    @RequestMapping("/findCourseByCourseId/{courseId}")
    public ResponseResultVO findCourseById(@PathVariable Integer courseId) {
        CourseVO courseVO = courseContentService.findCourseById(courseId);
        return new ResponseResultVO(true, 200, "响应成功", courseVO);
    }

    /**
     * @Author: andreaszhou
     * @Description: 编辑章节信息回显  根据课程章节id查找对应的课程章节信息
     * @DateTime: 2021/8/7 17:52
     * @Params: dto
     * @Return
     */
    @RequestMapping("showCourseSection/{courseSectionId}")
    public ResponseResultVO showCourseSection(@PathVariable Integer courseSectionId) {
        CourseSectionVO courseSectionVO = courseContentService.showCourseSection(courseSectionId);
        return new ResponseResultVO(true, 200, "响应成功", courseSectionVO);
    }

    /**
     * @Author: andreaszhou
     * @Description: 编辑课时信息回显  根据课程课时id查找对应的课程课时信息
     * @DateTime: 2021/8/7 17:32
     * @Params: courseLessonId
     * @Return
     */
    @RequestMapping("/showCourseLesson/{courseLessonId}")
    public ResponseResultVO showCourseLesson(@PathVariable Integer courseLessonId) {
        CourseLessonVO courseLessonVO = courseContentService.showCourseLesson(courseLessonId);
        return new ResponseResultVO(true, 200, "响应成功", courseLessonVO);
    }

    /**
     * @Author: andreaszhou
     * @Description: 新建&修改章节信息
     * @DateTime: 2021/7/21 21:33
     * @Params: dto
     * @Return ResponseResultVO
     */
    @RequestMapping("/saveOrUpdateSection")
    public ResponseResultVO saveOrUpdateSection(@RequestBody CourseSectionDTO dto) {
        if (dto.getId() != null) {
            courseContentService.updateSection(dto);
            return new ResponseResultVO(true, 200, "修改成功", null);
        } else {
            courseContentService.saveSection(dto);
            return new ResponseResultVO(true, 200, "保存成功", null);
        }
    }

    /**
     * @Author: andreaszhou
     * @Description: 新建/修改课时信息
     * @DateTime: 2021/7/21 21:29
     * @Params: dto
     * @Return
     */
    @RequestMapping("/saveOrUpdateLesson")
    public ResponseResultVO saveOrUpdateLesson(@RequestBody CourseLessonDTO dto) {
        if (dto.getId() != null) {
            courseContentService.updateLesson(dto);
            return new ResponseResultVO(true, 200, "修改成功", null);
        } else {
            courseContentService.saveLesson(dto);
            return new ResponseResultVO(true, 200, "保存成功", null);
        }
    }

    /**
     * @Author: andreaszhou
     * @Description: 更新课时状态
     * @DateTime: 2021/8/7 17:19
     * @Params: dto
     * @Return
     */
    @RequestMapping("/updateLessonStatus")
    public ResponseResultVO updateLessonStatus(@RequestBody CourseLessonDTO dto) {
        courseContentService.updateLessonStatus(dto);
        return new ResponseResultVO(true, 200, "修改成功", null);
    }

    /**
     * @Author: andreaszhou
     * @Description: 上传视频
     * @DateTime: 2021/8/7 18:23
     * @Params:
     * @Return
     */
    @RequestMapping("/uploadVideo")
    public ResponseResultVO uploadVideo() {
        return new ResponseResultVO(true, 200, "响应成功", null);
    }
}
