package com.webapi.user.mappers;

import java.util.List;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.webapi.user.dto.UserDto;
import com.webapi.user.entities.UserEntity;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    @Mappings({

            @Mapping(target = "createdByUser", ignore = true),

            @Mapping(target = "createdDate", ignore = true),

            @Mapping(target = "lastModifiedByUser", ignore = true),

            @Mapping(target = "lastModifiedDate", ignore = true),

            @Mapping(target = "createdFromIp", ignore = true),

            @Mapping(target = "updatedFromIp", ignore = true)
    })
    UserEntity toEntity(UserDto user);

    @InheritInverseConfiguration(name = "toEntity")
    UserDto toDto(UserEntity user);

    List<UserDto> toDtoList(List<UserEntity> users);

    @InheritConfiguration(name = "toEntity")
    void updateEntity(UserDto dto, @MappingTarget UserEntity entity);
}
