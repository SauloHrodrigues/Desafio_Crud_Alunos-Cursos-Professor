package com.cursoadm.cursoadm.dtos;

import com.cursoadm.cursoadm.model.Aluno;
import com.cursoadm.cursoadm.model.Professor;

import java.util.Set;

public record CursoResponseDTO(
        Long id,
        String curso,
        Professor prof,
        Set<Aluno> alunos
) {
}
