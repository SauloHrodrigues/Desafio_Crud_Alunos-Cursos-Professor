package com.cursoadm.cursoadm.modules.professor.mappers;

import com.cursoadm.cursoadm.modules.professor.dtos.ProfessorAtualizadoDto;
import com.cursoadm.cursoadm.modules.professor.dtos.ProfessorRequestDto;
import com.cursoadm.cursoadm.modules.professor.dtos.ProfessorResponseDto;
import com.cursoadm.cursoadm.modules.professor.Professor;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProfessorMapper {
    ProfessorMapper INSTANCE = Mappers.getMapper(ProfessorMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cursos", ignore = true)
    Professor toEntity(ProfessorRequestDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cursos", ignore = true)
    Professor toEntity(ProfessorAtualizadoDto dto);

    ProfessorResponseDto toResponseDto(Professor professor);

    List<ProfessorResponseDto> toResponseDto(List<Professor> professores);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cursos", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProfessorFromResponseDto(@MappingTarget Professor professor, ProfessorAtualizadoDto dtoUpdade);


}
