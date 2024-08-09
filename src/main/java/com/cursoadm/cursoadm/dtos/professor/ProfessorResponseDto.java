package com.cursoadm.cursoadm.dtos.professor;

import com.cursoadm.cursoadm.model.Curso;

import java.util.Set;

public record ProfessorResponseDto(
        Long id,
        String nome,
        String cpf,
        Set<Curso> cursos

) {
}
