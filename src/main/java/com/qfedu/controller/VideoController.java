package com.qfedu.controller;

import com.github.pagehelper.Page;
import com.qfedu.common.JsonResult;
import com.qfedu.entity.Course;
import com.qfedu.entity.Video;
import com.qfedu.service.CourseService;
import com.qfedu.service.VideoService;
import com.qfedu.vo.VideoVV;
import com.qfedu.vo.ViedoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.StrUtils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/video")
public class VideoController {
    @Autowired
    public VideoService videoService;

    @Autowired
    public CourseService courseService;

    @RequestMapping("/findAll.do")
    @ResponseBody
    public Map<String,Object> findAll(HttpSession session ,Integer page, Integer limit,String title, Integer speaker_id, Integer course_id){
        List<ViedoVO> list = videoService.findAll(page, limit,title,speaker_id,course_id);

        long total = ((Page)list).getTotal();

        Map<String,Object> map = new HashMap<>();


        map.put("code",0);//结合layui的表格组件，0表示成功
        map.put("msg","");
        map.put("count",total);//表中总记录数
        map.put("data",list);
        return map;
    }

    @RequestMapping("/findByMsg.do")
    @ResponseBody
    public Map<String,Object> findByMsg(HttpSession session,String title, Integer speakerId, Integer courseId){
        List<ViedoVO> list = videoService.findByMsg(title,speakerId,courseId);

        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("data",list);
        return map;

    }

    @RequestMapping("/delete.do")
    @ResponseBody
    public JsonResult delete(Integer id){
        videoService.delete(id);
        return  new JsonResult(1,null);
    }

    @RequestMapping("/add.do")
    @ResponseBody
    public JsonResult add(Video video){

        videoService.addVideo(video);
        return new JsonResult(1,null);
    }

    @RequestMapping("/query.do")
    @ResponseBody
    public JsonResult findOneById(Integer id){
        List<VideoVV> list = videoService.findOneById(id);

        return new JsonResult(1,list);
    }
    @RequestMapping("/updateInfo.do")
    @ResponseBody
    public JsonResult update(Video video){
        videoService.updateInfo(video);
        return  new JsonResult(1,null);
    }

    @RequestMapping("/showVideo")
    public String showVideo(Model model,Integer videoId,String subjectName) {
        Video video = videoService.findVideoAndSpeaker(videoId);
        Course course = courseService.findCourseAndVideo(video.getCourseId());

        model.addAttribute("video",video);
        model.addAttribute("subjectName",subjectName);
        model.addAttribute("course",course);
        return "section";
    }

}
