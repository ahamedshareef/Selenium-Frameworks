package org.taib.pom.objects;

import org.taib.pom.utils.JacksonUtils;

import java.io.IOException;

public class User {
    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String password;


    public User(){}

    public User(String username) throws IOException {
        JacksonUtils jacksonUtils = new JacksonUtils();
        User[] user = jacksonUtils.deserialize("Users.json", User[].class);
        for (User usr : user) {
            if (usr.getUsername().equals(username)) {
                this.username = usr.getUsername();
                this.password = usr.getPassword();
            }
        }
    }
}
