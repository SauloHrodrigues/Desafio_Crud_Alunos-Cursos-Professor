package com.cursoadm.cursoadm.modules.alunos.dto;

import com.cursoadm.cursoadm.modules.curso.Curso;

import java.util.Set;

public record AlunoResponseDto(
        Long id,
        String nome,
        String cpf,
        Set<Curso> cursos
) {
}
