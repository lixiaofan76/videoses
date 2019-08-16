package com.qfedu.dao;

import com.qfedu.entity.Course;
import com.qfedu.entity.Subject;
import com.qfedu.vo.CourseVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseDao {
    public List<Course> findAllCourse();

    public List<CourseVO> findAll2(@Param("id") Integer id);

    public void deleteCourse(Integer id);

    public void addCourse(Course course);

    public List<Course> findOne(Integer id);

    public void updateCourse(Course course);

    public Subject queryOneBySubject(Integer subjectId);

    public Course findCourseAndVideo(Integer id);
}
