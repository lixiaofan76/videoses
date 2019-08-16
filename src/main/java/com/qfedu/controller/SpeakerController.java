package com.qfedu.controller;

import com.github.pagehelper.Page;
import com.qfedu.common.JsonResult;
import com.qfedu.entity.Speaker;
import com.qfedu.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/speaker")
public class SpeakerController {
    @Autowired
    private SpeakerService speakerService;

        @RequestMapping("/list.do")
        @ResponseBody
        public Map<String,Object> findAll(HttpSession session,Integer page,Integer limit,Integer id){

            List<Speaker> list = speakerService.findAllSpeaker(page,limit,id);
            long total =((Page)list).getTotal();

            Map<String,Object> map = new HashMap<>();
            map.put("code",0);
            map.put("msg","");
            map.put("count",total);
            map.put("data",list);

            return map;
    }

    @RequestMapping("/list2.do")
    @ResponseBody
    public JsonResult findAllSpeaker2(){
        List<Speaker> courses = speakerService.findAllSpeaker2();
        JsonResult result = new JsonResult(1,courses);
        return result;
    }

    @RequestMapping("/add.do")
    @ResponseBody
    public JsonResult addSpeaker(Speaker speaker){
        List<Speaker> speakers = speakerService.addSpeaker(speaker);
        JsonResult result = new JsonResult(1,speakers);
        return result;
    }

    @RequestMapping("/delete.do")
    @ResponseBody
    public JsonResult deleteSpeaker(Integer id){
        speakerService.deleteSpeaker(id);
        return new JsonResult(1,null);
    }

    @RequestMapping("/query.do")
    @ResponseBody
    public JsonResult findOne(Integer id){
        List<Speaker> speakers = speakerService.findOne(id);
        return new JsonResult(1,speakers);
    }

    @RequestMapping("/updateInfo.do")
    @ResponseBody
    public JsonResult updateInfo(Speaker speaker){
        speakerService.updateInfo(speaker);
        return new JsonResult(1,null);
    }
}
