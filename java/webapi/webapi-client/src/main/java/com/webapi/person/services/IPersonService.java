package com.webapi.person.services;

import java.util.List;

import com.webapi.person.dto.PersonDto;

public interface IPersonService {
    List<PersonDto> getAll();

    PersonDto findById(Long personId);

    PersonDto create(PersonDto createPerson);

    void update(Long personId, PersonDto updatePerson);

    void inactive(Long personId);
}
