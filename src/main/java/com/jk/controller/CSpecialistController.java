package com.jk.controller;

import com.jk.bean.CSpecialist;
import com.jk.service.CSpecialistService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("cspecialist")
public class CSpecialistController {

    @Resource
    private CSpecialistService cSpecialistService;


    @ResponseBody
    @RequestMapping("/queryCSpecialist")
    public List<CSpecialist> queryCSpecialist(){

        return cSpecialistService.queryCSpecialist();
    }

    @RequestMapping("/cSpecialistDetails")
    public String cSpecialistDetails(){
        return "cSpecialistDetails";
    }

    @ResponseBody
    @RequestMapping("/getDetailById")
    public CSpecialist getDetailById(Integer id){
        CSpecialist detailById = cSpecialistService.getDetailById(id);
        return detailById;
    }

}
