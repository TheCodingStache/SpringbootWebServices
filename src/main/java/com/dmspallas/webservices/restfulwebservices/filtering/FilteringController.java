package com.dmspallas.webservices.restfulwebservices.filtering;

import com.dmspallas.webservices.restfulwebservices.user.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {
    @GetMapping("/filtering")
    public UserDetails retrieveSomeBean() {
        return new UserDetails("dmspallas", "qwerty1", "dmspallas@gmail.com");
    }

    @GetMapping("/filteringList")
    public List<UserDetails> retrieveListOfBeans() {
        return Arrays.asList(new UserDetails("dmspallas", "qwerty", "dmspallas@gmail.com"),
                new UserDetails("generalstache", "qwertyuiop1", "thegeneralstache@gmail.com"));
    }

}
