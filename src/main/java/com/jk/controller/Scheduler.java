package com.jk.controller;

import com.jk.bean.User;
import com.jk.bean.Vip;
import com.jk.service.VipService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Component
public class Scheduler {

    @Resource
    private VipService vipService;

    @Resource
    private JavaMailSenderImpl mailSender;


    //每隔2秒执行一次
    //@Scheduled(fixedRate = 1000)
    public void testTasks() {
        //定时发送到期提醒
        List<Vip> AllVipUser  = vipService.getVip();

        for (Vip vip : AllVipUser) {
            if(vip.getSendEmail()==0){
                Date date = new Date(); //现在的时间
                long start = date.getTime();
                Date endtime = vip.getEndTime();//到期时间
                long end = endtime.getTime();
                double asd = end - start;
                double day =  asd / 1000 / 60 / 60 / 24 ;
                //System.out.println(day);
                if(day <= 2){
                    User user = vipService.getUserById(vip.getUserId());
                    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
                    // 设置收件人，寄件人
                    simpleMailMessage.setTo(new String[]{user.getEmail()});
                    simpleMailMessage.setFrom("2074225252@qq.com");
                    simpleMailMessage.setSubject("【到期提醒】");
                    simpleMailMessage.setText("尊敬的"+user.getYhMch()+"您好，您的VIP服务即将到期，为不影响您的正常使用提示充值。");
                    // 发送邮件
                    mailSender.send(simpleMailMessage);
                    System.out.println("邮件已发送");
                    vipService.updateSendEmail(vip.getId());
                }
            }
        }
    }
}
