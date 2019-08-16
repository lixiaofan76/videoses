package com.qfedu.service.impl;

import com.qfedu.dao.BefordfindDao;
import com.qfedu.entity.Course;
import com.qfedu.service.BefordFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeforeFindServiceImpl implements BefordFindService {

    @Autowired
    private BefordfindDao befordfindDao;


    @Override
    public List<Course> BefordFind(Integer subjectId) {
        List<Course> courses = befordfindDao.BefordFind(subjectId);
        return courses;
    }
}
