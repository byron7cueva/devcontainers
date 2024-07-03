package com.webapi.person.repositories;

import java.util.List;

import com.webapi.common.data.repositories.IQueryDslRepository;
import com.webapi.person.entities.PersonEntity;

public interface IPersonRepository extends IQueryDslRepository<PersonEntity> {

    /**
     * Get all people
     * 
     * @return
     */
    List<PersonEntity> getAll();

    /**
     * Find a person by id.
     * 
     * @param personId
     * @return
     */
    PersonEntity findById(Long personId);

    /**
     * Create a new person
     * 
     * @param personEntity
     * @return
     */
    PersonEntity create(PersonEntity person);
}
