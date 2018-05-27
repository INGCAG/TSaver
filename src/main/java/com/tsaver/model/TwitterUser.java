package com.tsaver.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name = "TWITTER_USERS")// This tells Hibernate to make a table out of this class
@Component
public class TwitterUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_TWITTER_USER", nullable = false)
    private Long userTwitterId;

    @Column(name = "EXTERNAL_ID")
    private String id;

    @Column(name = "SCREEN_NAME")
    private String screenName;

    @Column(name = "NAME")
    private String name;

    @Column(name = "URL")
    private String url;

    @Column(name = "PROFILE_IMAGE_URL")
    private String profileImageUrl;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "LANGUAGE")
    private String language;

    @Column(name = "TIME_ZONE")
    private String timeZone;

    public TwitterUser() { }

    public Long getUserTwitterId() {
        return userTwitterId;
    }

    public String getId() {
        return id;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getLanguage() {
        return language;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public TwitterUser(long userTwitterId, String id, String screenName, String name, String url, String profileImageUrl, String description, String location, String language, String timeZone) {
        this.userTwitterId = userTwitterId;
        this.id = id;
        this.screenName = screenName;
        this.name = name;
        this.url = url;
        this.profileImageUrl = profileImageUrl;
        this.description = description;
        this.location = location;
        this.language = language;
        this.timeZone = timeZone;
    }
}
