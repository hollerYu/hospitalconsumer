package com.jk.service.impl;

import com.jk.bean.CComment;
import com.jk.bean.CSpecialist;
import com.jk.bean.User;
import com.jk.mapper.CCommentMapper;
import com.jk.mapper.CSpecialistMapper;
import com.jk.mapper.SourcemallMapper;
import com.jk.service.CSpecialistService;
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

    @Resource
    private SourcemallMapper sourcemallMapper;

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
    public User getUserVip(Integer id) {

        return cSpecialistMapper.getUserVip(id);
    }

    @Override
    public void updateJiFen(int jifen,Integer userId) {
        cSpecialistMapper.updateJiFen(jifen,userId);
    }

    @Override
    public void saveRecord(String titleName, int jifen, Integer userId) {
        sourcemallMapper.saveRecord(titleName,jifen,userId);
    }

    @Override
    public void updateJiFen02(int jifen, Integer userId) {
        cSpecialistMapper.updateJiFen02(jifen,userId);
    }

    @Override
    public void saveRecord02(String titleName, int jifen, Integer userId) {
        sourcemallMapper.saveRecord02(titleName,jifen,userId);
    }

    @Override
    public void updateUserVip(Integer id) {
        cSpecialistMapper.updateUserVip(id);
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
