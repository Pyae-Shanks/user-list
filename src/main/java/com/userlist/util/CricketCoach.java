package com.userlist.util;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
// @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // Default scope is singleton
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor:" + getClass().getSimpleName());
    }

    //
    // This method will run as soon as the bean has been initialized.
    //
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("In doMyStartupStuff: " + getClass().getSimpleName());
    }

    //
    // This method will run as soon as the bean has been decomposed.
    //
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("In doMyCleanupStuff: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes.";
    }
}
