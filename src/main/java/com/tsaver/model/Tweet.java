package com.tsaver.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name="TWEETS")// This tells Hibernate to make a table out of this class
@Component
public class Tweet {
    @Id
    @Column(name = "EXTERNAL_ID")
    private Long id;
//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    @Column(name = "ID_TWEET", nullable = false)
//    private Long tweetInternalId;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "SOURCE")
    private String source;

    @Column(name = "UNMODIFIED_TEXT")
    private String unmodifiedText;

    //entities

    //user

    @Column(name = "FAVORITED")
    private Boolean favorited;//default(false)

    @Column(name = "RETWEETED")
    private Boolean retweeted;//default(false)

    @Column(name = "FROM_USER_ID")
    private Long fromUserId;

    @Column(name = "RETWEET_COUNT")
    private Long retweetCount;// default(0)

    @Column(name = "LANGUAGE_CODE")
    private String languageCode;

    //extradata

    @Column(name = "FAVORITE_COUNT")
    private Long favoriteCount;// default(0)

    @Column(name = "RETWEET")
    private Boolean retweet;//default(false)

    @Column(name = "FROM_USER")
    private String fromUser;

    @Column(name = "CREATE_AT")
    private Long createdAt;

    @Column(name = "TO_USER_ID")
    private Long toUserId;//default(0)

    @Column(name = "IN_REPLY_TO_SCREEN_NAME")
    private String inReplyToScreenName;//default(null)

    @Column(name = "IN_REPLY_TO_STATUS_ID")
    private Long inReplyToStatusId;//default(null)

    @Column(name = "PROFILE_IMAGE_URL")
    private String profileImageUrl;

    @Column(name = "RETWEETED_STATUS")
    private String retweetedStatus;//default(null)

    @Column(name = "IN_REPLY_TO_USER_ID")
    private Long inReplyToUserId;//default(null)

    @ManyToOne
    @JoinColumn(name = "TWITTER_USER_ID")
    private TwitterUser user;

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

    public Long getCreatedAt() {
        return createdAt;
    }

    public String getFromUser() {
        return fromUser;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public Long getFromUserId() {
        return fromUserId;
    }

    public Long getInReplyToStatusId() {
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

    public Long getInReplyToUserId() {
        return inReplyToUserId;
    }

    public String getInReplyToScreenName() {
        return inReplyToScreenName;
    }

    public TwitterUser getUser() {
        return user;
    }

    public Tweet(Long id, String text, String unmodifiedText) {
        this.id = id;
        this.text = text;
        this.unmodifiedText = unmodifiedText;
    }

    public Tweet(Long id, String text, String unmodifiedText, String source, Long createdAt, String fromUser
            , String profileImageUrl, Long toUserId, Long fromUserId, Long inReplyToStatusId, String languageCode
            , Long retweetCount, Boolean retweeted, String retweetedStatus, Boolean retweet, Boolean favorited
            , Long favoriteCount, Long inReplyToUserId, String inReplyToScreenName) {
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

    public Tweet() {
    }
}
