package com.qfedu.service;


import com.qfedu.entity.Video;
import com.qfedu.vo.VideoVV;
import com.qfedu.vo.ViedoVO;


import java.util.List;

public interface VideoService {
    public List<ViedoVO> findAll(Integer page, Integer limit,String title, Integer speaker_id, Integer course_id);

    public List<ViedoVO> findByMsg( String title, Integer speakerId, Integer courseId);

    public void delete(Integer id);

    public void addVideo(Video video);

    public List<VideoVV> findOneById(Integer id);

    public void updateInfo(Video video);
    public  Video findOneById2(Integer id);

    public Video findVideoAndSpeaker(Integer id);
}
