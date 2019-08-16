package com.qfedu.service;

import com.qfedu.entity.User;
import org.apache.ibatis.annotations.Insert;

public interface UserService {

    public User login(String email, String password);
    public void update(User user);
    public User findById(Integer id);
    public void updatePassword(User user , String oldPassword,String newPassword,String newPassword2);
    public void uploadHeadImg( Integer id, String imgUrl);

}
