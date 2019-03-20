package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jk.utils.HttpClient;
import com.jk.utils.Base64Test;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: yjm
 * @Date: 2019/3/18 21:27
 * @Description:
 */
@Controller
@RequestMapping("code")
public class QrCodeController {
    @Resource
    private HttpClient httpClient;

    @RequestMapping("toQrCode")
    public String toQrCode(){
        return "QrCode";
    }

    //获取二维码
    @RequestMapping("getCode")
    @ResponseBody
    public String getCode(String data) {
        Map<String, Object> params = new HashMap<>();
        params.put("key", "10c79b70f8888db21108ac3fff5c5b28");
        params.put("text",data);
        String allresult = HttpClient.sendGet("http://apis.juhe.cn/qrcode/api", params);
        JSONObject jsonObject = JSONObject.parseObject(allresult);
        JSONObject result = jsonObject.getJSONObject("result");
        String base64_image = result.getString("base64_image");
        return base64_image;
    }


}
