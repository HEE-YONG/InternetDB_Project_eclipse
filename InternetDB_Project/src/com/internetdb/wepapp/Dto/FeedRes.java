package com.internetdb.wepapp.Dto;

public class FeedRes {
    private int post_idx;
    private int user_idx;
    private String user_nickname;
    private String post_title;
    private String post_picture;
    private String post_location;
    private String animal;
    private String post_content;

    public FeedRes(int post_idx, int user_idx, String user_nickname, String post_title, String post_picture, String post_location, String animal, String post_content) {
        this.post_idx = post_idx;
        this.user_idx = user_idx;
        this.user_nickname = user_nickname;
        this.post_title = post_title;
        this.post_picture = post_picture;
        this.post_location = post_location;
        this.animal = animal;
        this.post_content = post_content;
    }

    public int getPost_idx() {
        return post_idx;
    }

    public void setPost_idx(int post_idx) {
        this.post_idx = post_idx;
    }

    public int getUser_idx() {
        return user_idx;
    }

    public void setUser_idx(int user_idx) {
        this.user_idx = user_idx;
    }



    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_picture() {
        return post_picture;
    }

    public void setPost_picture(String post_picture) {
        this.post_picture = post_picture;
    }

    public String getPost_location() {
        return post_location;
    }

    public void setPost_location(String post_location) {
        this.post_location = post_location;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }
}
