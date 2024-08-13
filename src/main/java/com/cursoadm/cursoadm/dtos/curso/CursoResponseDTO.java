package com.cursoadm.cursoadm.dtos.curso;

import com.cursoadm.cursoadm.dtos.professor.ProfessorResponseDto;
import com.cursoadm.cursoadm.model.Aluno;
import com.cursoadm.cursoadm.model.Professor;

import java.util.Set;

public record CursoResponseDTO(
        Long id,
        String curso,
        ProfessorResponseDto professor,
        Set<Aluno> alunos
) {
}
