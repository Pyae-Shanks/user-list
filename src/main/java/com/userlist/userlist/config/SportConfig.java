package com.userlist.userlist.config;

import com.userlist.util.Coach;
import com.userlist.util.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    //
    // We can give custom name to the @Bean.
    //
    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
