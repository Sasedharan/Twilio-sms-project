package com.em.Projectsms.Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("twilio")
public class twilioConfiguration {
    private String account_sid;
    private String auth_token;
    private String trail_number;

    public twilioConfiguration() {
    }


    public String getAccount_sid() {
        return account_sid;
    }

    public void setAccount_sid(String account_sid) {
        this.account_sid = account_sid;
    }

    public String getAuth_token() {
        return auth_token;
    }

    public void setAuth_token(String auth_token) {
        this.auth_token = auth_token;
    }

    public String getTrail_number() {
        return trail_number;
    }

    public void setTrail_number(String trail_number) {
        this.trail_number = trail_number;
    }
}
