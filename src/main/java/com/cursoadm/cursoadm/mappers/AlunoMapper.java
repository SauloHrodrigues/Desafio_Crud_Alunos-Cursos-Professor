package com.cursoadm.cursoadm.mappers;

import com.cursoadm.cursoadm.dtos.aluno.AlunoRequestDto;
import com.cursoadm.cursoadm.dtos.aluno.AlunoResponseDto;
import com.cursoadm.cursoadm.model.Aluno;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AlunoMapper {
    AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);

    AlunoResponseDto toResponseDto(Aluno aluno);

    @Mapping(target = "id", ignore = true)
    Aluno toEntity(AlunoRequestDto dto);

}
