package com.tsaver.controller;

import com.tsaver.model.Tweet;
import com.tsaver.repository.Tweets;
import com.tsaver.repository.TwitterUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping(path = "/tweet")
public class CtrlTweet {
    @Autowired
    private Tweets tweetRepository;
    @Autowired
    private TwitterUsers twitterUsersRepository;

    @GetMapping(path = "/lst") // Map ONLY GET Requests
    public @ResponseBody
    Iterable<Tweet> listTweets() {
        // This returns a JSON or XML with the users
        return tweetRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tweet> getTweet(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        Optional<Tweet> u = tweetRepository.findById(id);
        if (u.get() == null) {
            System.out.println("Tweet with id " + id + " not found");
            return new ResponseEntity<Tweet>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Tweet>(u.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> createTweet(@RequestBody Tweet tweet, UriComponentsBuilder ucBuilder) {
        System.out.println("Saving tweet " + tweet.getId());

        twitterUsersRepository.save(tweet.getUser());
        tweetRepository.save(tweet);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(tweet.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ResponseEntity<Tweet> deleteTweet(@PathVariable("id") long id) {
        System.out.println("Deleting tweet " + id);
        Optional<Tweet> u = tweetRepository.findById(id);

        if (u.get() == null) {
            System.out.println("Tweet with id " + id + " not found");
            return new ResponseEntity<Tweet>(HttpStatus.NOT_FOUND);
        }

        tweetRepository.delete(u.get());
        return new ResponseEntity<Tweet>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public ResponseEntity<Tweet> deleteAll() {
        System.out.println("Deleting all tweets ");

        tweetRepository.deleteAll();
        return new ResponseEntity<Tweet>(HttpStatus.NO_CONTENT);
    }
}
