package com.dmspallas.webservices.restfulwebservices.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    private final UserService service;

    public UserResource(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = service.findUser(id);
        if (user == null) {
            throw new UserNotFoundException("id-    " + id);
        }
        return service.findUser(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = service.deleteUserById(id);
        if (user == null) {
            throw new UserNotFoundException("id-    " + id);
        }
    }

    //Created & Return the created URI
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUsers = service.saveUser(user);
        //Created
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUsers.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
