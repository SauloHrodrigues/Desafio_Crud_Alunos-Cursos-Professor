package com.cursoadm.cursoadm.modules.curso.mappers;

import com.cursoadm.cursoadm.modules.curso.dtos.CursoAtualizarDTO;
import com.cursoadm.cursoadm.modules.curso.dtos.CursoCadastroDTO;
import com.cursoadm.cursoadm.modules.curso.dtos.CursoResponseDTO;
import com.cursoadm.cursoadm.modules.curso.Curso;
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
