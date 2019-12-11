package com.dmspallas.webservices.restfulwebservices.database;

import com.dmspallas.webservices.restfulwebservices.user.User;
import com.dmspallas.webservices.restfulwebservices.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserDatabaseResource {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/jpa/users")
    public List<User> retrieveUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        //Optional means if user object is null or not
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent())
            throw new UserNotFoundException("id-    " + id);
        //*Using HATEOAS to create links that point other resources that are related*//
        EntityModel<User> entityModel = new EntityModel<>(user.get());
        ControllerLinkBuilder linkTo =
                ControllerLinkBuilder.linkTo(ControllerLinkBuilder
                        .methodOn(this.getClass())
                        .retrieveUsers());
        entityModel.add(linkTo.withRel("all-users"));
        return entityModel;
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    //Created & Return the created URI
    @PostMapping("/jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUsers = userRepository.save(user);
        //Created
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUsers.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrieveAllUsers(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()) {
            throw new UserNotFoundException();
        }
        return user.get().getPosts();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post) {
        Optional<User> savedUsers = userRepository.findById(id);
        if (!savedUsers.isPresent()) {
            throw new UserNotFoundException("id-" + id);
        }
        User user = savedUsers.get();
        post.setUser(user);
        postRepository.save(post);
        //Created
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
