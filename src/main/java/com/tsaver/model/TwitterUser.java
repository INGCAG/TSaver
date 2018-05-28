package com.tsaver.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name = "TWITTER_USERS")// This tells Hibernate to make a table out of this class
@Component
public class TwitterUser {

//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "ID_TWITTER_USER", nullable = false)
//    private Long userTwitterId;

    //extradata
    @Id
    @Column(name = "EXTERNAL_ID")
    private Long id;

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

    @Column(name = "CREATE_DATE")
    private Long createdDate;

    @Column(name = "LANGUAGE")
    private String language;

    @Column(name = "STATUSES_COUNT")
    private Long statusesCount;

    @Column(name = "FRIENDS_COUNT")
    private Long friendsCount;

    @Column(name = "FLLOWERS_COUNT")
    private Long followersCount;

    @Column(name = "FAVORITES_COUNT")
    private Long favoritesCount;

    @Column(name = "LISTED_COUNT")
    private Long listedCount;

    @Column(name = "FOLLOWING")
    private Boolean following; //default(false)

    @Column(name = "FOLLOW_REQUEST_SENT")
    private Boolean followRequestSent; //default(false)

    @Column(name = "NOTIFICATIONS_ENABLED")
    private Boolean notificationsEnabled; //default(false)

    @Column(name = "VERIFIED")
    private Boolean verified; //default(false)

    @Column(name = "GEO_ENABLED")
    private Boolean geoEnabled; //default(false)

    @Column(name = "CONTRIBUTORS_ENABLED")
    private Boolean contributorsEnabled; //default(false)

    @Column(name = "TRASNALTOR")
    private Boolean translator; //default(false)

    @Column(name = "TIME_ZONE")
    private String timeZone;

    @Column(name = "UTC_OFF_SET")
    private Long utcOffset;

    @Column(name = "SIDEBAR_BORDER_COLOR")
    private String sidebarBorderColor;

    @Column(name = "SIDEBAR_FILL_COLOR")
    private String sidebarFillColor;

    @Column(name = "BACKGROUND_COLOR")
    private String backgroundColor;

    @Column(name = "BACKGROUND_IMAGE_URL")
    private String backgroundImageUrl;

    @Column(name = "BACKGROUND_IMAGE_TILED")
    private Boolean backgroundImageTiled;

    @Column(name = "TEXT_COLOR")
    private String textColor;

    @Column(name = "LINK_COLOR")
    private String linkColor;

    @Column(name = "PROFILE_BANNER_URL")
    private String profileBannerUrl;

    @Column(name = "PROTECTD")
    private Boolean protectd;

    @Column(name = "PROFILE_URL")
    private String profileUrl;

//    public Long getUserTwitterId() {
//        return userTwitterId;
//    }

    public Long getId() {
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

    public Long getCreatedDate() {
        return createdDate;
    }

    public String getLanguage() {
        return language;
    }

    public Long getStatusesCount() { return statusesCount; }

    public Long getFriendsCount() { return friendsCount;}

    public Long getFollowersCount() { return followersCount;}

    public Long getFavoritesCount() { return favoritesCount; }

    public Long getListedCount() { return listedCount; }

    public Boolean getFollowing() { return following; }

    public Boolean getFollowRequestSent() { return followRequestSent; }

    public Boolean getNotificationsEnabled() { return notificationsEnabled; }

    public Boolean getVerified() { return verified; }

    public Boolean getGeoEnabled() { return geoEnabled; }

    public Boolean getContributorsEnabled() { return contributorsEnabled; }

    public Boolean getTranslator() { return translator; }

    public String getTimeZone() { return timeZone; }

    public Long getUtcOffset() { return utcOffset; }

    public String getSidebarBorderColor() { return sidebarBorderColor; }

    public String getSidebarFillColor() { return sidebarFillColor; }

    public String getBackgroundColor() { return backgroundColor; }

    public String getBackgroundImageUrl() { return backgroundImageUrl; }

    public Boolean getBackgroundImageTiled() { return backgroundImageTiled; }

    public String getTextColor() { return textColor; }

    public String getLinkColor() { return linkColor; }

    public String getProfileBannerUrl() { return profileBannerUrl; }

    public Boolean getProtectd() { return protectd; }

    public String getProfileUrl() { return profileUrl; }

    public TwitterUser() {
    }

    public TwitterUser(Long id, String screenName, String name, String url, String profileImageUrl
            , String description, String location, Long createdDate, String language, String timeZone) {
        this.id = id;
        this.screenName = screenName;
        this.name = name;
        this.url = url;
        this.profileImageUrl = profileImageUrl;
        this.description = description;
        this.location = location;
        this.createdDate = createdDate;
        this.language = language;
        this.timeZone = timeZone;
    }

    public TwitterUser(Long id, String screenName, String name, String url, String profileImageUrl
            , String description, String location, Long createdDate, String language, String timeZone
            , Long statusesCount, Long friendsCount, Long followersCount, Long favoritesCount, Long listedCount
            , Boolean following, Boolean followRequestSent, Boolean notificationsEnabled, Boolean verified, Boolean geoEnabled
            , Boolean contributorsEnabled, Boolean translator
            , Long utcOffset, String sidebarBorderColor, String sidebarFillColor, String backgroundColor
            , String backgroundImageUrl, Boolean backgroundImageTiled, String textColor, String linkColor
            , String profileBannerUrl, Boolean protectd, String profileUrl ) {
        this.id = id;
        this.screenName = screenName;
        this.name = name;
        this.url = url;
        this.profileImageUrl = profileImageUrl;
        this.description = description;
        this.location = location;
        this.createdDate = createdDate;
        this.language = language;
        this.timeZone = timeZone;

        this.statusesCount = statusesCount;
        this.friendsCount = friendsCount;
        this.followersCount = followersCount;
        this.favoritesCount = favoritesCount;
        this.listedCount = listedCount;
        this.following = following;
        this.followRequestSent = followRequestSent;
        this.notificationsEnabled = notificationsEnabled;
        this.verified = verified;
        this.geoEnabled = geoEnabled;
        this.contributorsEnabled = contributorsEnabled;
        this.translator = translator;

        this.utcOffset = utcOffset;
        this.sidebarBorderColor = sidebarBorderColor;
        this.sidebarFillColor = sidebarFillColor;
        this.backgroundColor = backgroundColor;
        this.backgroundImageUrl = backgroundImageUrl;
        this.backgroundImageTiled = backgroundImageTiled;
        this.textColor = textColor;
        this.linkColor = linkColor;
        this.profileBannerUrl = profileBannerUrl;
        this.protectd = protectd;
        this.profileUrl = profileUrl;
    }
}
