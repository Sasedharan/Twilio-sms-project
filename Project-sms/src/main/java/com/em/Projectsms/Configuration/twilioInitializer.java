package com.em.Projectsms.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class twilioInitializer {

   private final static Logger LOGGER = LoggerFactory.getLogger(twilioInitializer.class);
    private final twilioConfiguration twilioconfiguration;
 @Autowired
    public twilioInitializer(twilioConfiguration twilioconfiguration) {
        this.twilioconfiguration = twilioconfiguration;
        LOGGER.info("Twilio Initialized with account sid : " + twilioconfiguration.getAccount_sid());
    }

}

