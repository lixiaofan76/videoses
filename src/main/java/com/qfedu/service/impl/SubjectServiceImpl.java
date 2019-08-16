package com.qfedu.service.impl;

import com.qfedu.dao.SubjectDao;
import com.qfedu.entity.Subject;
import com.qfedu.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectDao subjectDao;

    @Override
    public List<Subject> findAllSubject() {
        return subjectDao.findAllSubject();
    }
}
