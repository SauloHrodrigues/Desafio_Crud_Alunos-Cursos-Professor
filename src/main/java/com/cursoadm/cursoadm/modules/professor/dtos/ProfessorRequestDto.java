package com.cursoadm.cursoadm.modules.professor.dtos;
import jakarta.validation.constraints.NotBlank;

public record ProfessorRequestDto(
        @NotBlank(message = "O nome do professor é obrigatório")
        String nome,
        @NotBlank(message = "O CPF do professor é obrigatório")
        String cpf
) {
}