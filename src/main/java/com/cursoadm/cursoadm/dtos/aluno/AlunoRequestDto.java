package com.cursoadm.cursoadm.dtos.aluno;

import com.cursoadm.cursoadm.model.Curso;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public record AlunoRequestDto(
        @NotBlank(message = "O nome do aluno é campo obrigatório.")
        String nome,
        @NotBlank(message = "O CPF do aluno é campo obrigatório.")
        String cpf
) {
}
