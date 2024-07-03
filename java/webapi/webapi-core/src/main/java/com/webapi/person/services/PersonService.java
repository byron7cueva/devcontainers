package com.webapi.person.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.webapi.common.data.enums.Status;
import com.webapi.person.dto.PersonDto;
import com.webapi.person.entities.PersonEntity;
import com.webapi.person.mappers.PersonMapper;
import com.webapi.person.repositories.IPersonRepository;

@Validated
@Lazy
@Service
@Transactional
public class PersonService implements IPersonService {

    @Autowired
    @Lazy
    private IPersonRepository personRepository;

    @Autowired
    @Lazy
    private PersonMapper personMapper;

    @Override
    @Transactional(readOnly = true)
    public List<PersonDto> getAll() {
        List<PersonEntity> personEntities = personRepository.getAll();
        return personMapper.toDtoList(personEntities);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonDto findById(Long personId) {
        PersonEntity personEntity = personRepository.findById(personId);
        return personMapper.toDto(personEntity);
    }

    @Override
    public PersonDto create(PersonDto createPersonDto) {
        PersonEntity personEntity = personMapper.toEntity(createPersonDto);
        PersonEntity newPersonEntity = personRepository.create(personEntity);
        return personMapper.toDto(newPersonEntity);
    }

    @Override
    public void update(Long personId, PersonDto updatePerson) {
        PersonEntity personEntity = personRepository.findById(personId);
        personMapper.updateEntity(updatePerson, personEntity);
        personRepository.update(personEntity);
    }

    @Override
    public void inactive(Long personId) {
        this.update(personId, PersonDto.builder()
                .status(Status.INACTIVE.value)
                .build());
    }
}
