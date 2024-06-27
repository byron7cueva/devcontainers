package com.webapi.person.controllers;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapi.person.vo.PersonVo;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("people")
@Lazy
public class PersonController {
    @GetMapping()
    public ResponseEntity<List<PersonVo>> getAll() {
        return new ResponseEntity<List<PersonVo>>(
                List.of(
                        PersonVo.builder()
                                .personId(1L)
                                .firstName("Luis")
                                .build(),
                        PersonVo.builder()
                                .personId(2L)
                                .firstName("Carlos")
                                .build()),
                HttpStatus.OK);
    }

}
