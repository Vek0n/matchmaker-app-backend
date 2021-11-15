package com.skaczmarek.matchmakerappbackend.domain.jwt;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private final long userId;


    public JwtResponse(String jwttoken, long userId) {
        this.jwttoken = jwttoken;
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }
    public String getToken() {
        return this.jwttoken;
    }


}