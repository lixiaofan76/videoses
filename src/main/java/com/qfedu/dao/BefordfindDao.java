package com.qfedu.dao;

import com.qfedu.entity.Course;

import java.util.List;

public interface BefordfindDao {
    public List<Course> BefordFind(Integer subjectId);
}
