package com.in28minutes.rest.webservice.restfulwebservices.user;

import com.in28minutes.rest.webservice.restfulwebservices.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.methodOn;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping(path = "/users")
    public List<User> retriveAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping(path = "/user/{id}")
    public User retriveUser(@PathVariable int id) {
        User user = userDaoService.findOne(id);
        if (user == null)
            throw new UserNotFoundException("id = " + id);

        EntityModel<User> resource = EntityModel.of(user);
        //WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retriveAllUsers());
        resource.add(linkTo.withRel("all-users"));

        return user;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        User deletedUser = userDaoService.deleteById(id);
        if (deletedUser == null)
        throw new UserNotFoundException("id = " + id);
    }
}