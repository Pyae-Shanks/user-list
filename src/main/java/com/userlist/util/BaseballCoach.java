package com.userlist.util;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BaseballCoach implements Coach {

    public BaseballCoach() {
        System.out.println("In constructor:" + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Spent 30 minutes in batting practice.";
    }
}
