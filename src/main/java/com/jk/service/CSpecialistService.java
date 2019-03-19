package com.jk.service;

import com.jk.bean.CComment;
import com.jk.bean.CSpecialist;
import com.jk.bean.User;

import java.util.List;

public interface CSpecialistService {
    List<CSpecialist> queryCSpecialist();

    CSpecialist getDetailById(Integer id);

    void addComment(CComment comment);

    void addStar(Integer star, Integer specialistId);

    List<CComment> getCommentById(Integer specialistId);

    List<CComment> getCommentByLiveId(Integer liveId);

    CComment getUserCommentByIdNotshowStar(Integer userId, Integer liveId);

    CComment getUserCommentById(Integer userId, Integer specialistId);

    void updateLookById(Integer id);

    User getUserVip(Integer id);

    void updateJiFen(int jifen,Integer userId);

    void saveRecord(String titleName, int jifen, Integer userId);

    void updateJiFen02(int jifen, Integer userId);

    void saveRecord02(String titleName, int jifen, Integer userId);

    void updateUserVip(Integer id);
}
