package com.dmspallas.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

    @GetMapping("/info/items")
    public Items items() {
        return new Items(new Info("Samsung Galaxy Note 10+", "50", "150"));
    }

    @GetMapping("/info/item-details")
    public ItemDetails itemDetails() {
        return new ItemDetails("Samsung Galaxy Note 10+", "50", "150");
    }
}
