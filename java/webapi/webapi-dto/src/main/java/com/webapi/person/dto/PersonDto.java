package com.webapi.person.dto;

import java.util.Date;

import com.webapi.common.dto.AuditableDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class PersonDto extends AuditableDto {
    private Long personId;
    private String identityNumber;
    private String firstName;
    private String secondName;
    private String surname;
    private String secondSurname;
    private Date birthDate;
}
