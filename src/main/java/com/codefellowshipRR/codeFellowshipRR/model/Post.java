package com.codefellowshipRR.codeFellowshipRR.model;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;


@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String body;
    private Date timeStamp;

    @ManyToOne
    AppUser appUser;

    public Post() {
    }

    public Post(String body, Date timeStamp) {
        this.body = body;
        this.timeStamp = timeStamp;
    }

    public Post(String body, Date timeStamp, AppUser appUser) {
        this.body = body;
        this.timeStamp = timeStamp;
        this.appUser = appUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
