package com.cursoadm.cursoadm.modules.matriculas.mappers;

import com.cursoadm.cursoadm.modules.matriculas.dtos.MatriculaResponseDto;
import com.cursoadm.cursoadm.modules.alunos.Aluno;
import com.cursoadm.cursoadm.modules.curso.Curso;
import com.cursoadm.cursoadm.modules.matriculas.Matricula;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MatriculaMapper {
    MatriculaMapper INSTANCE = Mappers.getMapper(MatriculaMapper.class);

    @Mapping(target = "id", ignore = true)
    default Matricula toEntity(Aluno aluno, Curso curso){
        Matricula matricula = new Matricula();
        matricula.setCurso(curso);
        matricula.setAluno(aluno);
        return matricula;
    }
    MatriculaResponseDto toResponseDto(Matricula matricula);
    List<MatriculaResponseDto> toListResponseDto(List<Matricula>matriculas);

}
