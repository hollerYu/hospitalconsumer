package com.jk.service.impl;

import com.jk.bean.CComment;
import com.jk.bean.CSpecialist;
import com.jk.mapper.CCommentMapper;
import com.jk.mapper.CSpecialistMapper;
import com.jk.service.CSpecialistService;
import com.sun.mail.imap.protocol.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CSpecialistServiceImpl implements CSpecialistService {

    @Resource
    private CSpecialistMapper cSpecialistMapper;

    @Autowired
    private CCommentMapper commentMapper;

    @Override
    public List<CSpecialist> queryCSpecialist() {
        return cSpecialistMapper.queryCSpecialist();
    }

    @Override
    public CSpecialist getDetailById(Integer id) {

        return cSpecialistMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateLookById(Integer id) {
        cSpecialistMapper.updateLookById(id);
    }

    @Override
    public void addComment(CComment comment) {
        commentMapper.insertSelective(comment);
    }

    @Override
    public void addStar(Integer star, Integer specialistId) {
        commentMapper.addStar(star,specialistId);
    }

    @Override
    public List<CComment> getCommentById(Integer specialistId) {
        return commentMapper.getCommentById(specialistId);
    }

    @Override
    public List<CComment> getCommentByLiveId(Integer liveId) {
        return commentMapper.getCommentByLiveId(liveId);
    }

    @Override
    public CComment getUserCommentByIdNotshowStar(Integer userId, Integer liveId) {
        return commentMapper.getUserCommentByIdNotshowStar(userId,liveId);
    }

    @Override
    public CComment getUserCommentById(Integer userId, Integer specialistId) {
        return commentMapper.getUserCommentById(userId,specialistId);
    }


}
