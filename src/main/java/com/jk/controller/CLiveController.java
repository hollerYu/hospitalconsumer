package com.jk.controller;

import com.jk.bean.CLive;
import com.jk.service.CLiveService;
import com.jk.utils.ResultPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("clive")
public class CLiveController {

    @Resource
    private CLiveService liveService;

    @RequestMapping("getLive")
    @ResponseBody
    private List<CLive> getLive(Integer page,Integer rows){
        List<CLive> live = liveService.getLive(page, rows);
        return live;
    }

    @ResponseBody
    @RequestMapping("/getLiveAll")
    public List<CLive> getLiveAll(){
        return liveService.getLiveAll();
    }


    @ResponseBody
    @RequestMapping("/getLiveById")
    public CLive getLiveById(Integer id){
        return liveService.getLiveById(id);
    }

}
