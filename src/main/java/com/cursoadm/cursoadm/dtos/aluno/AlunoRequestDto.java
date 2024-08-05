package com.cursoadm.cursoadm.dtos.aluno;

import com.cursoadm.cursoadm.model.Curso;
import jakarta.persistence.ManyToMany;

import java.util.Set;

public record AlunoRequestDto(
        String nome,
        String cpf,
        Long idCurso
) {
}
