package com.qfedu.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dao.CourseDao;
import com.qfedu.entity.Course;
import com.qfedu.entity.Subject;
import com.qfedu.entity.Video;
import com.qfedu.service.CourseService;
import com.qfedu.vo.CourseVO;
import com.qfedu.vo.VideoVV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> findAllCourse() {

        return courseDao.findAllCourse();
    }

    @Override
    public List<CourseVO> findAll2(Integer page,Integer limit,Integer id) {
        PageHelper.startPage(page,limit);
        List<CourseVO> list = courseDao.findAll2(id) ;
        return list;
    }

    @Override
    public void deleteCourse(Integer id) {
        courseDao.deleteCourse(id);
    }

    @Override
    public void addCourse(Course course) {
        courseDao.addCourse(course);
    }

    @Override
    public List<Course> findOne(Integer id) {
        List<Course> courses = courseDao.findOne(id);
        return courses;
    }

    @Override
    public void updateCourse(Course course) {
        courseDao.updateCourse(course);
    }

    @Override
    public Subject queryOneBySubject(Integer subjectId) {
        Subject subject = courseDao.queryOneBySubject(subjectId);
        return subject;
    }

    @Override
    public Course findCourseAndVideo(Integer id) {
        Course course = courseDao.findCourseAndVideo(id);
        return course;
    }


}
