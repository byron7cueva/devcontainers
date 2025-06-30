package com.webapi.user.dto;

import com.webapi.common.dto.AuditableDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class UserDto extends AuditableDto {
    private Long userId;
    private String userName;
}
