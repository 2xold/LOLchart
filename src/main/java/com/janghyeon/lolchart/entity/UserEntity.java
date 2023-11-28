package com.janghyeon.lolchart.entity;

import com.janghyeon.lolchart.dto.UserDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import org.apache.catalina.User;

import java.util.Objects;

@Entity
@Table(name = "users")
public class UserEntity {
    private @Id @GeneratedValue long id;
    private String username;
    private String phoneNumber;
    private String email;
    private String password;
    private boolean loggedIn;
    public UserEntity() {
    }
    public UserEntity(String username,
                      String password,
                      boolean loggedIn) {
        this.username = username;
        this.password = password;
        this.loggedIn = loggedIn;
    }
    public long getId() {
        return id;
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
    public boolean isLoggedIn() {
        return loggedIn;
    }
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    public static UserEntity toUserEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity(userDTO.getUsername(),
                userDTO.getPassword(), userDTO.isLoggedIn());

        return userEntity;
    }
}