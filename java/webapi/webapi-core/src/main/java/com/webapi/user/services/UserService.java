package com.webapi.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.webapi.common.data.enums.Status;
import com.webapi.keycloak.respositories.KeycloakRepository;
import com.webapi.user.dto.UserDto;
import com.webapi.user.entities.UserEntity;
import com.webapi.user.mappers.UserMapper;
import com.webapi.user.respositories.IUserRepository;

@Validated
@Lazy
@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    @Lazy
    private IUserRepository userRepository;

    @Autowired
    @Lazy
    private KeycloakRepository keycloakRepository;

    @Autowired
    @Lazy
    private UserMapper userMapper;

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> getAll() {
        List<UserEntity> userEntities = userRepository.getAll();
        return userMapper.toDtoList(userEntities);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto findById(Long userId) {
        UserEntity userEntity = userRepository.findById(userId);
        return userMapper.toDto(userEntity);
    }

    @Override
    public UserDto create(UserDto user) {
        /*
         * UserEntity userEntity = userMapper.toEntity(user);
         * UserEntity newUserEntity = userRepository.create(userEntity);
         * return userMapper.toDto(newUserEntity);
         */

        keycloakRepository.create(user);
        return UserDto.builder()
                .userName(user.getUserName())
                .build();
    }

    @Override
    public void update(Long userId, UserDto user) {
        UserEntity userEntity = userRepository.findById(userId);
        userMapper.updateEntity(user, userEntity);
        userRepository.update(userEntity);
    }

    @Override
    public void inactive(Long userId) {
        this.update(userId, UserDto.builder()
                .status(Status.INACTIVE.value)
                .build());
    }
}
