package com.qfedu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.dao.VideoDao;
import com.qfedu.entity.Video;
import com.qfedu.service.VideoService;
import com.qfedu.vo.VideoVV;
import com.qfedu.vo.ViedoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideoServiceImpl implements VideoService {


    @Autowired
    private VideoDao videoDao;

    @Override
    public List<ViedoVO> findAll(Integer page, Integer limit,String title, Integer speaker_id, Integer course_id) {
        //设置页码和每一页显示的记录数，该语句后边紧跟数据库查询相关的语句
        PageHelper.startPage(page,limit);
        List<ViedoVO> list = videoDao.findAllVideo(title,speaker_id,course_id);
        //获取总记录数
        //((Page)list).getTotal();
        return list;
    }

    @Override
    public List<ViedoVO> findByMsg(String title, Integer speakerId, Integer courseId) {

        List<ViedoVO> list = videoDao.findByMsg(title,speakerId,courseId);
        return  list;
    }

    @Override
    public void delete(Integer id) {
        videoDao.deleteById(id);
    }

    @Override
    public void addVideo(Video video) {
        videoDao.addVideo(video);
    }

    @Override
    public List<VideoVV> findOneById(Integer id) {
        List<VideoVV> list = videoDao.findOneById(id);
        return list;
    }

    @Override
    public void updateInfo(Video video) {
        videoDao.updateInfo(video);
    }

    @Override
    public Video findOneById2(Integer id) {
        Video video = videoDao.findOneById2(id);
        return video;
    }

    @Override
    public Video findVideoAndSpeaker(Integer id) {
        return videoDao.findVideoAndSpeaker(id);
    }


}
