package com.cursoadm.cursoadm.modules.alunos.dto;

import jakarta.validation.constraints.NotBlank;

public record AlunoRequestDto(
        @NotBlank(message = "O nome do aluno é campo obrigatório.")
        String nome,
        @NotBlank(message = "O CPF do aluno é campo obrigatório.")
        String cpf
) {
}
