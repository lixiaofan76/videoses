package com.qfedu.controller;

import com.qfedu.common.JsonResult;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import utils.StrUtils;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
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

    @RequestMapping("/showMyProfile")
    public String showMyProfile(Model model,HttpSession session){
        User user =(User) session.getAttribute(StrUtils.LOGIN_USER);
        model.addAttribute("user",user);
        return "my_profile";
    }

    // 为change_profile页面提供user对象
    @RequestMapping("/changeProfile")
    public String changeProfile(Model model, HttpSession session) {

        User user = (User) session.getAttribute(StrUtils.LOGIN_USER);
        model.addAttribute("user", user);

        return "change_profile";
    }

    @RequestMapping("/updateUser")
    public String changeProfile(User user,HttpSession session){
        userService.update(user);

        User user1 = userService.findById(user.getId());
        session.setAttribute(StrUtils.LOGIN_USER,user1);

        return "redirect:showMyProfile";

    }

    @RequestMapping("/passwordSafe")
    public String passwordSafe(Model model,HttpSession session){
        User user =(User) session.getAttribute(StrUtils.LOGIN_USER);
        model.addAttribute("user",user);
        return "password_safe";
    }

    @RequestMapping("/updatePassword")
    @ResponseBody
    public JsonResult updatePassword(HttpSession session,String oldPassword,String newPassword,String newPassword2){
        User user = (User) session.getAttribute(StrUtils.LOGIN_USER);
        userService.updatePassword(user,oldPassword,newPassword,newPassword2);
        User user1 = userService.findById(user.getId());
        session.setAttribute(StrUtils.LOGIN_USER,user1);
        return new JsonResult(1,null);
    }

    @RequestMapping("/validatePassword")
    @ResponseBody
    public JsonResult validatePassword(String password, HttpSession session) {

        try {
            User user = (User) session.getAttribute(StrUtils.LOGIN_USER);

            if (!password.equals(user.getPassword())) {
                throw new RuntimeException("原密码错误！");
            }

            return new JsonResult(1, null);

        } catch (Exception e) {
            return new JsonResult(0, e.getMessage());
        }
    }

    @RequestMapping("/changeAvatar")
    public String changeAvatar(Model model, HttpSession session) {

        User user = (User) session.getAttribute(StrUtils.LOGIN_USER);
        model.addAttribute("user", user);

        return "change_avatar";
    }
    @RequestMapping("/upLoadImage")
    public String upLoadImage(@RequestParam MultipartFile image_file ,HttpSession session) {
        User user = (User)session.getAttribute(StrUtils.LOGIN_USER);

        //上传文件的目录
        String dir = "D:/upload";

        File file = new File(dir);
        if (!file.exists()){
            file.mkdirs();
        }

        String filename = image_file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid + "_" +filename;

        //要保存的文件的File对象
        File newFile = new File(dir,filename);

        try {
            image_file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        userService.uploadHeadImg(user.getId(),"/upload/" + filename);

        User sessionUser = userService.findById(user.getId());
        session.setAttribute(StrUtils.LOGIN_USER,sessionUser);

        return "redirect:showMyProfile";

    }

}
