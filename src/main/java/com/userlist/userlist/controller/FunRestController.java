package com.userlist.userlist.controller;

import com.userlist.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //
    // Private fields for the dependencies.
    //
    private Coach myCoach;
    private Coach anotherCoach;

    //
    // Define the constructor for dependency injection.
    // If you have only one constructor. The @Autowired is optional. :-)
    //
    /* @Autowired
    public FunRestController(Coach theCoach) {
        this.theCoach = theCoach;
    } */

    //
    // Define the setter injection.
    //
    /* @Autowired
    public void setTheCoach(Coach theCoach) {
        this.theCoach = theCoach;
    }*/

    //
    // Define custom injection.
    // @Qualifier bean name should be same with the class. First character is lower case.
    // Alternate solution will be @Primary annotation. But if two encounter, @Qualifier has higher prior.
    //
    @Autowired
    public void doSomeStuff(@Qualifier("aquatic") Coach theCoach,
                            @Qualifier("cricketCoach") Coach theAnotherCoach) {
        System.out.println("In constructor:" + getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

    //
    // Getting the property values from the application.properties.
    //

    @Value("${coach.name}") private String coachName;
    @Value("${team.name}") private String teamName;

    @GetMapping("/team-info")
    public String getTeamInfo() {
        return "Coach name: " + coachName + " Team name: " + teamName;
    }

    @GetMapping("/daily-workout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }
}
