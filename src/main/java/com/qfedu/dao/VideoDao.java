package com.qfedu.dao;


import com.github.pagehelper.PageHelper;
import com.qfedu.entity.Video;
import com.qfedu.vo.VideoVV;
import com.qfedu.vo.ViedoVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoDao {

    public List<ViedoVO> findAllVideo(@Param("title") String title,
                                      @Param(("speakerId")) Integer speakerId,
                                      @Param(("courseId")) Integer courseId);

    public List<ViedoVO> findByMsg(@Param("title") String title,
                                   @Param(("speakerId")) Integer speakerId,
                                   @Param("courseId")Integer courseId);

    public void deleteById(Integer id);

    public void addVideo(Video video);

    public  List<VideoVV> findOneById(Integer id);

    public  Video findOneById2(Integer id);

    public void updateInfo(Video video);



    public Video findVideoAndSpeaker(Integer id);
}
