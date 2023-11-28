package com.janghyeon.lolchart.dto;

import com.janghyeon.lolchart.entity.UserEntity;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserDTO {
    private Long id;
    private String username;
    private String phoneNumber;
    private String email;
    private String password;
    private boolean loggedIn;

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
    public static UserDTO toUserDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(userEntity.getUsername());
        userDTO.setPassword(userEntity.getPassword());

        return userDTO;
    }
}
