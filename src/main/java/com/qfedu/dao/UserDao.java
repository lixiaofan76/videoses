package com.qfedu.dao;

import com.qfedu.entity.User;

import org.apache.ibatis.annotations.Param;

public interface UserDao {
    public User login(@Param("email")String email,@Param("password") String password);

    public void update(User user);

    public User findById(Integer id);

    public void updatePassword(@Param("id") Integer id,@Param("password")String password);

    public void uploadHeadImg(@Param("id") Integer id,@Param("imgUrl") String imgUrl);
}
