package com.webapi.person.mappers;

import java.util.List;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.webapi.person.dto.PersonDto;
import com.webapi.person.entities.PersonEntity;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PersonMapper {

    @Mappings({

            @Mapping(target = "createdByUser", ignore = true),

            @Mapping(target = "createdDate", ignore = true),

            @Mapping(target = "lastModifiedByUser", ignore = true),

            @Mapping(target = "lastModifiedDate", ignore = true),

            @Mapping(target = "createdFromIp", ignore = true),

            @Mapping(target = "updatedFromIp", ignore = true)
    })
    PersonEntity toEntity(PersonDto personDto);

    @InheritInverseConfiguration(name = "toEntity")
    PersonDto toDto(PersonEntity person);

    List<PersonDto> toDtoList(List<PersonEntity> people);

    @InheritConfiguration(name = "toEntity")
    void updateEntity(PersonDto dto, @MappingTarget PersonEntity entity);
}
