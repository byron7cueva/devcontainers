package com.webapi.person.respositories;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import static com.webapi.person.entities.QPersonEntity.personEntity;

import com.querydsl.core.BooleanBuilder;
import com.webapi.common.data.enums.Status;
import com.webapi.common.data.repositories.JPAQueryDslRepository;
import com.webapi.person.entities.PersonEntity;
import com.webapi.person.repositories.IPersonRepository;

@Lazy
@Repository
public class PersonRepository extends JPAQueryDslRepository<PersonEntity> implements IPersonRepository {

    public PersonRepository() {
        super(PersonEntity.class);
    }

    @Override
    public List<PersonEntity> getAll() {
        return from(personEntity)
                .where(this.attachWere())
                .fetch();
    }

    @Override
    public PersonEntity findById(Long personId) {
        return from(personEntity)
                .where(this.attachWere().and(personEntity.personId.eq(personId)))
                .fetchFirst();
    }

    @Override
    public PersonEntity create(PersonEntity person) {
        this.save(person);
        return person;
    }

    private BooleanBuilder attachWere() {
        BooleanBuilder where = new BooleanBuilder();

        // Status
        where.and(personEntity.status.eq(Status.ACTIVE.value));

        return where;
    }

}
