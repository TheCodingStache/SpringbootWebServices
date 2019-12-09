package com.dmspallas.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {
    //Uri Versioning
    @GetMapping("/info/items")
    public Items items() {
        return new Items(new Info("Samsung Galaxy Note 10+", "50", "1500"));
    }

    @GetMapping("/info/item-details")
    public ItemDetails itemDetails() {
        return new ItemDetails("Samsung Galaxy Note 10+", "50", "1500");
    }
    //Versioning using parameters
    @GetMapping(value = "/info/param", params = "version=1")
    public Items parameterV1() {
        return new Items(new Info("Rolex Watch Date-Time", "15", "50000"));
    }

    @GetMapping(value = "/info/param", params = "version=2")
    public ItemDetails parameterV2() {
        return new ItemDetails("Rolex Watch Date-Time", "15", "50000");

    }
    // Mime type or accept header versioning

    @GetMapping(value = "/info/header", headers = "X-API-VERSION=1")
    public Items header() {
        return new Items(new Info("OnePlus 7T Pro", "15", "750"));
    }

    @GetMapping(value = "/info/header", headers = "X-API-VERSION=2")
    public ItemDetails headerDetails() {
        return new ItemDetails("OnePlus 7T pro", "15", "750");

    }

    @GetMapping(value = "/info/header", produces = "application/com.dmspallas.webservices.restfulwebservices-v1+json")
    public Items producesInfoV1() {
        return new Items(new Info("Xiaomi Mi A2", "25", "230"));

    }

    @GetMapping(value = "/info/header", produces = "application/com.dmspallas.webservices.restfulwebservices-v2+json")
    public ItemDetails producesInfoV2() {
        return new ItemDetails("Xiaomi Mi A2", "25", "230");

    }
}
