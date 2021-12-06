package com.skaczmarek.matchmakerappbackend.domain.user;

import com.skaczmarek.matchmakerappbackend.domain.social.UserSocialDTO;

public class UserDTO {
    private String username;
    private String password;
    private UserSocialDTO userSocial;

    UserDTO(){
    }

    UserDTO(String username, String password){
        this.username = username;
        this.password = password;
    }

    UserDTO(String username, String password, UserSocialDTO userSocialDTO){
        this.username = username;
        this.password = password;
        this.userSocial = userSocialDTO;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserSocialDTO getUserSocial() {
        return userSocial;
    }

    public void setUserSocial(UserSocialDTO userSocial) {
        this.userSocial = userSocial;
    }
}