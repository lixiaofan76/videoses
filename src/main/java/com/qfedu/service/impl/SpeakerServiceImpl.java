package com.qfedu.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dao.SpeakerDao;
import com.qfedu.entity.Speaker;
import com.qfedu.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SpeakerServiceImpl implements SpeakerService {
    @Autowired(required = false)
    private SpeakerDao speakerDao;

    @Override
    public List<Speaker> findAllSpeaker(Integer page,Integer limit,Integer id) {

        PageHelper.startPage(page,limit);
        List<Speaker> list = speakerDao.findAllSpeaker(id);
        return list;
    }

    @Override
    public List<Speaker> findAllSpeaker2() {

        return speakerDao.findAllSpeaker2();
    }

    @Override
    public List<Speaker> addSpeaker(Speaker speaker) {
        speakerDao.addSpeaker(speaker);
        return null;
    }

    @Override
    public void deleteSpeaker(Integer id) {
        speakerDao.deleteSpeaker(id);
    }

    @Override
    public List<Speaker> findOne(Integer id) {
        List<Speaker> speakers = speakerDao.findOne(id);
        return speakers;
    }

    @Override
    public void updateInfo(Speaker speaker) {
        speakerDao.updateInfo(speaker);
    }


}
