package com.twentyeight.springbootjpademo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> getAll() {
        return userDaoService.getUsers();
    }

    @PostMapping("/user")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User user1 = userDaoService.createUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user1.getUserId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/users/{id}")
    public User findUserById(@PathVariable int id) {
        return userDaoService.findUser(id);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable int id) {
        return userDaoService.deleteUser(id);
    }
}
