package com.qfedu.service.impl;

import com.qfedu.dao.UserDao;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String email, String password) {
        return userDao.login(email,password);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public void updatePassword(User user, String oldPassword, String newPassword, String newPassword2) {
        if (!user.getPassword().equals(oldPassword)) {
            throw new RuntimeException("原密码错误！");
        }
        if (!newPassword.equals(newPassword2)) {
            throw new RuntimeException("两次密码不一致！");
        }
        userDao.updatePassword(user.getId(),newPassword);
    }

    @Override
    public void uploadHeadImg(Integer id, String imgUrl) {
        userDao.uploadHeadImg(id,imgUrl);
    }
}
