package com.qfedu.service.impl;

import com.qfedu.dao.AdminDao;
import com.qfedu.entity.Admin;
import com.qfedu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired(required = false)
    private AdminDao adminDao;

    @Override
    public Admin login(String username, String password) {

        return adminDao.login(username,password);
    }
}
