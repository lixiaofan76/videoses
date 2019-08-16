package com.qfedu.service;

import com.qfedu.entity.Subject;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SubjectService {
    public List<Subject> findAllSubject();
}
