package com.cursoadm.cursoadm.modules.curso.dtos;

import com.cursoadm.cursoadm.modules.professor.dtos.ProfessorResponseDto;
import com.cursoadm.cursoadm.modules.alunos.Aluno;

import java.util.Set;

public record CursoResponseDTO(
        Long id,
        String curso,
        ProfessorResponseDto professor,
        Set<Aluno> alunos
) {
}
