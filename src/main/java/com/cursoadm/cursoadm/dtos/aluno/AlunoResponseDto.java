package com.cursoadm.cursoadm.dtos.aluno;

import com.cursoadm.cursoadm.model.Curso;
import jakarta.persistence.ManyToMany;

import java.util.Set;

public record AlunoResponseDto(
        Long id,
        String nome,
        String cpf,
        Set<Curso> cursos
) {
}
