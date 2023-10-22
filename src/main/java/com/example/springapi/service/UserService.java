package com.example.springapi.service;

import com.example.springapi.api.dto.UserDTO;
import com.example.springapi.persistence.entity.UserEntity;
import com.example.springapi.persistence.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserDTO> getUser(Integer id) {
        Optional<UserEntity> userFromDB = userRepository.getUserEntityById(id);

        return userFromDB.map(this::userEntityMapper);
    }

    private UserDTO userEntityMapper(UserEntity userEntity){
        return UserDTO.builder()
                .name(userEntity.getName())
                .age(userEntity.getAge())
                .email(userEntity.getEmail())
                .build();
    }
}
