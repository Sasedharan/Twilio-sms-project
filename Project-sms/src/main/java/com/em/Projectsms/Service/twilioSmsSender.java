package com.em.Projectsms.Service;


import com.em.Projectsms.Configuration.twilioConfiguration;
import com.em.Projectsms.Controller.SmsRepository;
import com.em.Projectsms.Controller.smsEntity;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
public class twilioSmsSender implements  smsSender{

    private static Logger LOGGER = LoggerFactory.getLogger(twilioSmsSender.class);
    @Autowired
    private twilioConfiguration twiliocong;
    @Autowired
    private SmsRepository smsRepository;
    @Override
    public void sendsms(SmsRequest smsRequest) {

        if(isPhoneNumberValid(smsRequest.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twiliocong.getTrail_number());
            String message = smsRequest.getMessage();
            MessageCreator messageCreator = Message.creator(to, from, message);
            try {
                smsEntity sentity = smsEntity.builder().message(message).phoneNumber(to.toString()).
                        sendNumber(from.toString()).build();
                smsRepository.save(sentity);
                messageCreator.create();
            } catch (Exception e) {
                e.printStackTrace();
            }
            LOGGER.info(" The SMS Send Successfully :" + smsRequest);
        }

        else{
            throw new IllegalArgumentException("The Phone number is invalid :" + smsRequest.getPhoneNumber());
        }
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        return true ;
    }
}
