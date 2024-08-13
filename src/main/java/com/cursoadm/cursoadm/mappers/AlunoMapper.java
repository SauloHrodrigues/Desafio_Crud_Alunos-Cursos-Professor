package com.cursoadm.cursoadm.mappers;

import com.cursoadm.cursoadm.dtos.aluno.AlunoAtualizarDto;
import com.cursoadm.cursoadm.dtos.aluno.AlunoRequestDto;
import com.cursoadm.cursoadm.dtos.aluno.AlunoResponseDto;
import com.cursoadm.cursoadm.model.Aluno;

import java.util.List;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AlunoMapper {
    AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);

    AlunoResponseDto toResponseDto(Aluno aluno);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "matriculas", ignore = true)
    Aluno toEntity(AlunoRequestDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "matriculas", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAlunoFromResponseDto(@MappingTarget Aluno aluno, AlunoAtualizarDto dtoUpdade);

    List<AlunoResponseDto> toListResponseDto(List<Aluno> alunos);
}
