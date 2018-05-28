package com.tsaver.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name="TWEETS")// This tells Hibernate to make a table out of this class
@Component
public class Tweet {
    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID_TWEET", nullable = false)
    private Long tweetInternalId;

    @Column(name = "EXTERNAL_ID")
    private Long id;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "UNMODIFIED_TEXT")
    private String unmodifiedText;

    @Column(name = "SOURCE")
    private String source;

    @Column(name = "CREATE_AT")
    private String createdAt;

    @Column(name = "FROM_USER")
    private String fromUser;

    @Column(name = "PROFILE_IMAGE_URL")
    private String profileImageUrl;

    @Column(name = "TO_USER_ID")
    private String toUserId;//default(0)

    @Column(name = "FROM_USER_ID")
    private String fromUserId;

    @Column(name = "IN_REPLY_TO_STATUS_ID")
    private String inReplyToStatusId;//default(null)

    @Column(name = "LANGUAGE_CODE")
    private String languageCode;

    @Column(name = "RETWEETED_COUNT")
    private Long retweetCount;// default(0)

    @Column(name = "RETWEETED")
    private Boolean retweeted;//default(false)

    @Column(name = "RETWEETED_STATUS")
    private String retweetedStatus;//default(null)

    @Column(name = "RETWEET")
    private Boolean retweet;//default(false)

    @Column(name = "FAVORITED")
    private Boolean favorited;//default(false)

    @Column(name = "FAVORITE_COUNT")
    private Long favoriteCount;//default(0)

    @Column(name = "IN_REPLY_TO_USER_ID")
    private String inReplyToUserId;//default(null)

    @Column(name = "IN_REPLY_TO_SCREEN_NAME")
    private String inReplyToScreenName;//default(null)

    @ManyToOne
    @JoinColumn(name = "TWEETER_USER_ID")
    private TwitterUser user;
    /*
        @Column(name = "TWEETER_USER_ID")
        private Long user;//reference


    */
    public Long getTweetInternalId() {
        return tweetInternalId;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getUnmodifiedText() {
        return unmodifiedText;
    }

    public String getSource() {
        return source;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getFromUser() {
        return fromUser;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public String getToUserId() {
        return toUserId;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public String getInReplyToStatusId() {
        return inReplyToStatusId;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public Long getRetweetCount() {
        return retweetCount;
    }

    public Boolean getRetweeted() {
        return retweeted;
    }

    public String getRetweetedStatus() {
        return retweetedStatus;
    }

    public Boolean getRetweet() {
        return retweet;
    }

    public Boolean getFavorited() {
        return favorited;
    }

    public Long getFavoriteCount() {
        return favoriteCount;
    }

    public String getInReplyToUserId() {
        return inReplyToUserId;
    }

    public String getInReplyToScreenName() {
        return inReplyToScreenName;
    }

    public TwitterUser getUser() {
        return user;
    }

    public Tweet(Long tweetInternalId, Long id, String text, String unmodifiedText) {
        this.tweetInternalId = tweetInternalId;
        this.id = id;
        this.text = text;
        this.unmodifiedText = unmodifiedText;
    }

    public Tweet(Long tweetInternalId, Long id, String text, String unmodifiedText, String source, String createdAt, String fromUser, String profileImageUrl, String toUserId, String fromUserId, String inReplyToStatusId, String languageCode, Long retweetCount, Boolean retweeted, String retweetedStatus, Boolean retweet, Boolean favorited, Long favoriteCount, String inReplyToUserId, String inReplyToScreenName) {
        this.tweetInternalId = tweetInternalId;
        this.id = id;
        this.text = text;
        this.unmodifiedText = unmodifiedText;
        this.source = source;
        this.createdAt = createdAt;
        this.fromUser = fromUser;
        this.profileImageUrl = profileImageUrl;
        this.toUserId = toUserId;
        this.fromUserId = fromUserId;
        this.inReplyToStatusId = inReplyToStatusId;
        this.languageCode = languageCode;
        this.retweetCount = retweetCount;
        this.retweeted = retweeted;
        this.retweetedStatus = retweetedStatus;
        this.retweet = retweet;
        this.favorited = favorited;
        this.favoriteCount = favoriteCount;
        this.inReplyToUserId = inReplyToUserId;
        this.inReplyToScreenName = inReplyToScreenName;
    }

    public Tweet(Long tweetInternalId) {
        this.tweetInternalId = tweetInternalId;
    }

    public Tweet() {
    }
}
