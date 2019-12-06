package com.dmspallas.webservices.restfulwebservices.filtering;

import com.dmspallas.webservices.restfulwebservices.user.UserDetails;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {
    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSpecificDetails() {
        UserDetails userDetails = new UserDetails("dmspallas", "qwerty1", "dmspallas@gmail.com");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("username");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("sensitiveData", filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userDetails);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }

    @GetMapping("/filteringList")
    public MappingJacksonValue retrieveListOfBeans() {
        List<UserDetails> detailsList = Arrays.asList(new UserDetails("dmspallas", "qwerty", "dmspallas@gmail.com"),
                new UserDetails("generalstache", "qwertyuiop1", "thegeneralstache@gmail.com"));
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("username");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("sensitiveData", filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(detailsList);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }

}
