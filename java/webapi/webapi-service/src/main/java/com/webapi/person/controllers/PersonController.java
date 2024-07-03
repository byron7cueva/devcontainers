package com.webapi.person.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapi.person.dto.PersonDto;
import com.webapi.person.services.IPersonService;

import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("people")
@Lazy
public class PersonController {

        @Autowired
        @Lazy
        private IPersonService personService;

        @GetMapping
        public ResponseEntity<List<PersonDto>> getAll() {
                List<PersonDto> personList = this.personService.getAll();
                return new ResponseEntity<List<PersonDto>>(personList, HttpStatus.OK);
        }

        @GetMapping("{personId}")
        public ResponseEntity<PersonDto> findById(@NotNull @PathVariable Long personId) {
                PersonDto personDto = this.personService.findById(personId);
                return new ResponseEntity<PersonDto>(personDto, HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<PersonDto> create(@RequestBody PersonDto person) {
                PersonDto newPerson = this.personService.create(person);
                return new ResponseEntity<PersonDto>(newPerson, HttpStatus.CREATED);
        }

        @PatchMapping("{personId}")
        public ResponseEntity<Void> update(@NotNull @PathVariable Long personId, @RequestBody PersonDto person) {
                this.personService.update(personId, person);
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }

        @DeleteMapping("{personId}")
        public ResponseEntity<Void> delete(@NotNull @PathVariable Long personId) {
                this.personService.inactive(personId);
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
}
