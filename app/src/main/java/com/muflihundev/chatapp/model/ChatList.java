package com.muflihundev.chatapp.model;

public class ChatList {
    private String userId;
    private String userName;
    private String description;
    private String date;
    private String urlProfileImage;

    public ChatList(String userId, String userName, String description, String date, String urlProfileImage) {
        this.userId = userId;
        this.userName = userName;
        this.description = description;
        this.date = date;
        this.urlProfileImage = urlProfileImage;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrlProfileImage() {
        return urlProfileImage;
    }

    public void setUrlProfileImage(String urlProfileImage) {
        this.urlProfileImage = urlProfileImage;
    }
}
