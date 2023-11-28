package com.janghyeon.lolchart.repository;

import com.janghyeon.lolchart.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
