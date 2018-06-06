package com.tsaver.controller;

import com.tsaver.model.User;
import com.tsaver.repository.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class CtrlUser {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private Users userRepository;

    @GetMapping(path="/lst") // Map ONLY GET Requests
    public @ResponseBody
    Iterable<User> listUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        Optional<User> u = userRepository.findById(id);
        if (u.get() == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(u.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user,    UriComponentsBuilder ucBuilder) {
        System.out.println("Saving User " + user.getUsername());

        userRepository.save(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/get/{id}").buildAndExpand(user.getUserId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        System.out.println("Updating User " + id);
        Optional<User> u = userRepository.findById(id);

        if (u.get()==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        User updatedUser = new User(u.get().getUserId(),user.getUsername(),user.getPassword(),user.getEmail(), user.getRoleId());

        userRepository. save(updatedUser);
        return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
        System.out.println("Deleting User " + id);
        Optional<User> u = userRepository.findById(id);

        if (u.get()==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        userRepository. delete(u.get());
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public ResponseEntity<User> deleteAll() {
        System.out.println("Deleting All Users ");

        userRepository. deleteAll();
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
}
