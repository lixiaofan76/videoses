package com.qfedu.service;

import com.qfedu.entity.Speaker;

import java.util.List;

public interface SpeakerService {
    public List<Speaker> findAllSpeaker(Integer page,Integer limit,Integer id);
    public List<Speaker> findAllSpeaker2();

    public List<Speaker> addSpeaker(Speaker speaker);

    public void deleteSpeaker(Integer id);

    public List<Speaker> findOne(Integer id);

    public void updateInfo(Speaker speaker);
}
