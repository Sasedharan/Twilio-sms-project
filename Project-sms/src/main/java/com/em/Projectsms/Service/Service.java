package com.em.Projectsms.Service;

import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class Service {

    private twilioSmsSender twiliosmssender;

    public Service(@Qualifier("twilio") twilioSmsSender twiliosmssender) {
        this.twiliosmssender = twiliosmssender;
    }

    public void sendSms(SmsRequest smsRequest){
        twiliosmssender.sendsms(smsRequest);
    }
}
