package com.qfedu.controller;

import com.qfedu.common.JsonResult;
import com.qfedu.entity.Admin;
import com.qfedu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.StrUtils;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login.do")
    @ResponseBody
    public JsonResult login(String username, String password, HttpSession session){
        Admin admin = adminService.login(username,password);

        if(admin != null){
            session.setAttribute(StrUtils.LOGIN_USER,admin);
            JsonResult result = new JsonResult(1,null);
            return result;
        }else {
            JsonResult result = new JsonResult(0,"账号密码错误");
            return result;
        }

    }
}
