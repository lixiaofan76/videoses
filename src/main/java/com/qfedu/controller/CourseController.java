package com.qfedu.controller;

import com.github.pagehelper.Page;
import com.qfedu.common.JsonResult;
import com.qfedu.entity.Course;
import com.qfedu.entity.Subject;
import com.qfedu.entity.User;
import com.qfedu.service.CourseService;
import com.qfedu.service.SubjectService;
import com.qfedu.service.UserService;
import com.qfedu.vo.CourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.StrUtils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;
    @RequestMapping("/list.do")
    @ResponseBody
    public JsonResult findAll(){
        List<Course> courses = courseService.findAllCourse();
        JsonResult result = new JsonResult(1,courses);
        return result;
    }

    @RequestMapping("/findAll2.do")
    @ResponseBody
    public Map<String,Object> findAll2(Integer page,Integer limit,Integer id){
        List<CourseVO> list = courseService.findAll2(page,limit,id);
        long total =((Page)list).getTotal();

        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",list);

        return map;
    }
    @RequestMapping("/delete.do")
    @ResponseBody
    public JsonResult deleteCourse(Integer id){
        courseService.deleteCourse(id);
        JsonResult result = new JsonResult(1,null);
        return result;
    }

    @RequestMapping("/add.do")
    @ResponseBody
    public JsonResult addCourse(Course course){
        courseService.addCourse(course);
        JsonResult result = new JsonResult(1,course);
        return result;
    }

    @RequestMapping("/query.do")
    @ResponseBody
    public JsonResult findOne(Integer id){
        List<Course> courses = courseService.findOne(id);
        JsonResult result = new JsonResult(1,courses);
        return result;
    }

    @RequestMapping("/updateInfo.do")
    @ResponseBody
    public JsonResult updateCourse(Course course){
        courseService.updateCourse(course);
        JsonResult result =new JsonResult(1,null);
        return result;
    }

    @RequestMapping("list2")
    public String queryOneBySubject(HttpSession session,Integer subjectId){
        Subject subject =  courseService.queryOneBySubject(subjectId);
        session.setAttribute("subject",subject);
        return  "course";
    }


    @RequestMapping("/user/login.do")
    @ResponseBody
    public JsonResult login (String email, String password, HttpSession session){
        User user = userService.login(email,password);
        if(user != null){
            session.setAttribute(StrUtils.LOGIN_USER,user);
            JsonResult result = new JsonResult(1,null);
            return result;

        }else {
            JsonResult result = new JsonResult(0,"账号密码错误");
            return  result;
        }
    }

}
