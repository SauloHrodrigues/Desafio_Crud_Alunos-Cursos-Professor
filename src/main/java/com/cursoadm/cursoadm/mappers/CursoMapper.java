package com.cursoadm.cursoadm.mappers;

import com.cursoadm.cursoadm.dtos.curso.CursoAtualizarDTO;
import com.cursoadm.cursoadm.dtos.curso.CursoCadastroDTO;
import com.cursoadm.cursoadm.dtos.curso.CursoResponseDTO;
import com.cursoadm.cursoadm.model.Curso;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CursoMapper {

    CursoMapper INSTANCE = Mappers.getMapper(CursoMapper.class);

    CursoResponseDTO toResponseDto(Curso curso);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "professor", ignore = true)
    Curso toEntity (CursoCadastroDTO dto);//id_professor

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAuthorFromResponseDto(@MappingTarget Curso curso, CursoAtualizarDTO dtoUpdade);
}
