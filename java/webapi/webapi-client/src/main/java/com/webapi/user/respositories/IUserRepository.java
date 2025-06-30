package com.webapi.user.respositories;

import java.util.List;

import com.webapi.common.data.repositories.IQueryDslRepository;
import com.webapi.user.entities.UserEntity;

public interface IUserRepository extends IQueryDslRepository<UserEntity> {

    /**
     * Get all users
     * 
     * @return
     */
    List<UserEntity> getAll();

    /**
     * Find user by id
     * 
     * @param userId
     * @return
     */
    UserEntity findById(Long userId);

    /**
     * Create user
     * 
     * @param user
     * @return
     */
    UserEntity create(UserEntity user);
}
