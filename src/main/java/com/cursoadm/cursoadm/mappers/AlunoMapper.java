package com.cursoadm.cursoadm.mappers;

import com.cursoadm.cursoadm.dtos.aluno.AlunoAtualizarDto;
import com.cursoadm.cursoadm.dtos.aluno.AlunoRequestDto;
import com.cursoadm.cursoadm.dtos.aluno.AlunoResponseDto;
import com.cursoadm.cursoadm.dtos.curso.CursoRequestDTO;
import com.cursoadm.cursoadm.model.Aluno;
import com.cursoadm.cursoadm.model.Curso;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AlunoMapper {
    AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);

    AlunoResponseDto toResponseDto(Aluno aluno);

    @Mapping(target = "id", ignore = true)
    Aluno toEntity(AlunoRequestDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAlunoFromResponseDto(@MappingTarget Aluno aluno, AlunoAtualizarDto dtoUpdade);

}
