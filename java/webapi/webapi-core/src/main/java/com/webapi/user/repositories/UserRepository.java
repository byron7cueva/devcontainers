package com.webapi.user.repositories;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import static com.webapi.user.entities.QUserEntity.userEntity;

import com.querydsl.core.BooleanBuilder;
import com.webapi.common.data.enums.Status;
import com.webapi.common.data.repositories.JPAQueryDslRepository;
import com.webapi.user.entities.UserEntity;
import com.webapi.user.respositories.IUserRepository;

@Lazy
@Repository
public class UserRepository extends JPAQueryDslRepository<UserEntity> implements IUserRepository {

    public UserRepository() {
        super(UserEntity.class);
    }

    @Override
    public List<UserEntity> getAll() {
        return from(userEntity)
                .where(this.attachWere())
                .fetch();
    }

    @Override
    public UserEntity findById(Long userId) {
        return from(userEntity)
                .where(this.attachWere().and(userEntity.userId.eq(userId)))
                .fetchFirst();
    }

    @Override
    public UserEntity create(UserEntity user) {
        this.save(user);
        return user;
    }

    private BooleanBuilder attachWere() {
        BooleanBuilder where = new BooleanBuilder();

        // Status
        where.and(userEntity.status.eq(Status.ACTIVE.value));

        return where;
    }

}
