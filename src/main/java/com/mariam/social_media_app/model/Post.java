package com.mariam.social_media_app.model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "post")
public class Post {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "postId")
    private int id;

    @NotNull
    @Column(name = "text")
    private String text;

    @CreationTimestamp
    @Column(name = "date")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Post() {
    }

    public Post(int id, String text, LocalDateTime date, User user) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.user = user;
    }

    public Post(String text, User user) {
        this.text = text;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
