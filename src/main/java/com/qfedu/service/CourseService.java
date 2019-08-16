package com.qfedu.service;

import com.qfedu.entity.Course;
import com.qfedu.entity.Subject;
import com.qfedu.entity.Video;
import com.qfedu.vo.CourseVO;
import com.qfedu.vo.VideoVV;


import java.util.List;

public interface CourseService {
    public List<Course> findAllCourse();

    public List<CourseVO> findAll2(Integer page,Integer limit,Integer id);

    public void deleteCourse(Integer id);

    public void addCourse(Course course);

    public List<Course> findOne(Integer id);

    public void updateCourse(Course course);

    public Subject queryOneBySubject(Integer subjectId);

    public Course findCourseAndVideo(Integer id);
}
