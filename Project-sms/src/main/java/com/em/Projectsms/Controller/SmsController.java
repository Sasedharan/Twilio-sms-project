package com.em.Projectsms.Controller;

import com.em.Projectsms.Service.Service;
import com.em.Projectsms.Service.SmsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/twilio/sms")
public class SmsController{

    private Service service;
    @Autowired
    public SmsController(Service service) {
        this.service = service;
    }
    @PostMapping
    public void smsSend(@Valid @RequestBody SmsRequest smsRequest){
        service.sendSms(smsRequest);   }
}
