package com.cursoadm.cursoadm.mappers;

import com.cursoadm.cursoadm.dtos.aluno.AlunoAtualizarDto;
import com.cursoadm.cursoadm.dtos.aluno.AlunoRequestDto;
import com.cursoadm.cursoadm.dtos.aluno.AlunoResponseDto;
import com.cursoadm.cursoadm.dtos.professor.ProfessorAtualizadoDto;
import com.cursoadm.cursoadm.dtos.professor.ProfessorRequestDto;
import com.cursoadm.cursoadm.dtos.professor.ProfessorResponseDto;
import com.cursoadm.cursoadm.model.Aluno;
import com.cursoadm.cursoadm.model.Professor;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProfessorMapper {
    ProfessorMapper INSTANCE = Mappers.getMapper(ProfessorMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cursos", ignore = true)
    Professor toEntity(ProfessorRequestDto dto);

    ProfessorResponseDto toResponseDto(Professor professor);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cursos", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProfessorFromResponseDto(@MappingTarget Professor professor, ProfessorAtualizadoDto dtoUpdade);


}
