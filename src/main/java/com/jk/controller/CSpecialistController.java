package com.jk.controller;

import com.jk.bean.CComment;
import com.jk.bean.CSpecialist;
import com.jk.bean.User;
import com.jk.service.CSpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("cspecialist")
public class CSpecialistController {

    @Resource
    private CSpecialistService cSpecialistService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 专家拙见查询
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryCSpecialist")
    public List<CSpecialist> queryCSpecialist() {

        return cSpecialistService.queryCSpecialist();
    }

    /**
     * 详情页面
     *
     * @return
     */
    @RequestMapping("/cSpecialistDetails")
    public String cSpecialistDetails() {
        return "cSpecialistDetails";
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/getDetailById")
    public CSpecialist getDetailById(Integer id, HttpSession session) {
        CSpecialist detailById = cSpecialistService.getDetailById(id);
        User user = (User) session.getAttribute("user");
        if (user != null) {
            if (!redisTemplate.hasKey("lookNumber" + user.getId())) {   //如果不存在   浏览次数就加 1
                //增加  观看次数
                cSpecialistService.updateLookById(id);
                redisTemplate.opsForValue().set("lookNumber" + user.getId(), 1, 30, TimeUnit.MINUTES);
            }
        }
        return detailById;
    }

    /**
     * 新增评论表
     *
     * @param comment
     * @return
     */
    @ResponseBody
    @RequestMapping("/addComment")
    public String addComment(CComment comment, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            CComment commentBean = cSpecialistService.getUserCommentById(user.getId(), comment.getSpecialistId());
            if (commentBean == null) {
                comment.setUserId(user.getId());
                cSpecialistService.addComment(comment);
                cSpecialistService.addStar(comment.getStar(), comment.getSpecialistId());
                return "1";//留言成功
            } else {
                return "0";//留言guole
            }

        } else {
            return "-1"; //未登录，不能评论
        }

    }

    /***
     *回显登录用户评论过的星
     * @return
     */
    @RequestMapping("/getUserCommentById")
    @ResponseBody
    public CComment getUserCommentById(Integer specialistId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        CComment commentBean = null;
        if(user != null){
            commentBean = cSpecialistService.getUserCommentById(user.getId(), specialistId);
        }

        return commentBean;
    }

    /**
     * 直播留言
     *
     * @param comment
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/addCommentNotshowStar")
    public String addCommentNotshowStar(CComment comment, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            CComment commentBean = cSpecialistService.getUserCommentByIdNotshowStar(user.getId(), comment.getLiveId());
            if (commentBean == null) {
                comment.setUserId(user.getId());
                cSpecialistService.addComment(comment);
                return "1";
            } else {
                return "0";
            }
        } else {
            return "-1";
        }
    }

    /**
     * 查询专家拙见的留言
     *
     * @param specialistId
     * @return
     */
    @RequestMapping("/getCommentById")
    @ResponseBody
    public List<CComment> getCommentById(Integer specialistId) {
        List<CComment> bean = cSpecialistService.getCommentById(specialistId);
        return bean;
    }

    /**
     * 查询直播留言
     *
     * @param liveId
     * @return
     */
    @RequestMapping("/getCommentByLiveId")
    @ResponseBody
    public List<CComment> getCommentByLiveId(Integer liveId) {
        List<CComment> bean = cSpecialistService.getCommentByLiveId(liveId);
        return bean;
    }

}
