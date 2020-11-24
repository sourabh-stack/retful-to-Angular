package com.sourabh.rest.webservice.restfulwebservice.jwt.resources;

import java.io.Serializable;

public class  JwtTokenRequest implements Serializable {
  
  private static final long serialVersionUID = -5616176897013108345L;

  private String username;
    private String password;
    
    
    {
    //	"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpbjI4bWludXRlcyIsImV4cCI6MTYwNjEzMDk3NywiaWF0IjoxNjA1NTI2MTc3fQ.UPRb-Pbkk1hsJLzxruv5Llz9WY-keNyKHymlpCvKgeCfSycaTdCBg7M1vCv-pGOYpnA2BAquQA9-lP1frkH4vg"
    	}

    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

