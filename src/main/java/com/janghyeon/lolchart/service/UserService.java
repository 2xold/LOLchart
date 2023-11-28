package com.janghyeon.lolchart.service;

import com.janghyeon.lolchart.dto.UserDTO;
import com.janghyeon.lolchart.entity.UserEntity;
import com.janghyeon.lolchart.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Literal;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void save(UserDTO userDTO) {
        UserEntity userEntity = UserEntity.toUserEntity(userDTO);
        userRepository.save(userEntity);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

}
