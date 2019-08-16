package com.qfedu.dao;

import com.qfedu.entity.Speaker;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface SpeakerDao {
    public List<Speaker> findAllSpeaker(@Param(("id"))Integer id);
    public List<Speaker> findAllSpeaker2();

    public void addSpeaker(Speaker speaker);

    public void deleteSpeaker(Integer id);

    public List<Speaker> findOne(Integer id);

    public void updateInfo(Speaker speaker);
}
