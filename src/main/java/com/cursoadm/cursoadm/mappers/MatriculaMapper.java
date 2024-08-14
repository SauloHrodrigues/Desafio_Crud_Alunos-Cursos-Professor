package com.cursoadm.cursoadm.mappers;

import com.cursoadm.cursoadm.dtos.matricula.MatriculaResponseDto;
import com.cursoadm.cursoadm.dtos.professor.ProfessorAtualizadoDto;
import com.cursoadm.cursoadm.dtos.professor.ProfessorRequestDto;
import com.cursoadm.cursoadm.dtos.professor.ProfessorResponseDto;
import com.cursoadm.cursoadm.model.Aluno;
import com.cursoadm.cursoadm.model.Curso;
import com.cursoadm.cursoadm.model.Matricula;
import com.cursoadm.cursoadm.model.Professor;
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
