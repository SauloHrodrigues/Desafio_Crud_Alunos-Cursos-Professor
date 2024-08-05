package com.cursoadm.cursoadm.mappers;

import com.cursoadm.cursoadm.dtos.curso.CursoRequestDTO;
import com.cursoadm.cursoadm.dtos.curso.CursoResponseDTO;
import com.cursoadm.cursoadm.model.Curso;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CursoMapper {

    CursoMapper INSTANCE = Mappers.getMapper(CursoMapper.class);

    CursoResponseDTO toResponseDto(Curso curso);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAuthorFromResponseDto(@MappingTarget Curso curso, CursoRequestDTO dtoUpdade);
}
