package com.cursoadm.cursoadm.modules.alunos.mappers;

import com.cursoadm.cursoadm.modules.alunos.dto.AlunoAtualizarDto;
import com.cursoadm.cursoadm.modules.alunos.dto.AlunoRequestDto;
import com.cursoadm.cursoadm.modules.alunos.dto.AlunoResponseDto;
import com.cursoadm.cursoadm.modules.alunos.Aluno;

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
