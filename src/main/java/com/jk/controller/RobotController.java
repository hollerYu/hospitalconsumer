package com.jk.controller;
import com.fasterxml.jackson.databind.JsonNode;
import com.jk.bean.User;
import com.jk.service.RobotService;
import com.jk.utils.HttpClientUtil;
import com.jk.utils.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@Controller
@RequestMapping("robot")
public class RobotController {

    @Resource
    private RobotService robotService;

    //去往专属客服页面
    @RequestMapping("torobot")
    public String torobot(){
        return "robot";
    }

    //查询专属客服
    @RequestMapping("queryRobot")
    @ResponseBody
    public String queryRobot(HttpSession session, ModelMap modelMap){
        User user = (User)session.getAttribute("user");
       // System.out.println(user);
        return "robot";
    }

    //专属客服机器人.智能机器人
    @RequestMapping("talkToRobot")
    @ResponseBody
    public HashMap<String, Object> talkToRobot(String text) throws IOException {
        HashMap<String, Object> resultmap = new HashMap<String, Object>();
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("msg",text);
        String string = HttpClientUtil.get("http://api.qingyunke.com/api.php?key=free&appid=0&", params);

        JsonNode jsonToJsonNode = JsonUtil.jsonToJsonNode(string);
        resultmap.put("content", jsonToJsonNode.get("content").toString());
        return resultmap;
    }


}
