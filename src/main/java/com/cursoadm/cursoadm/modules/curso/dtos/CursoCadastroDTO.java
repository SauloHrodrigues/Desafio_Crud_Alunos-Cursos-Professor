package com.cursoadm.cursoadm.modules.curso.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CursoCadastroDTO(
        @NotBlank(message = "O campo curso deve ser preenchido")
        String curso,
        @NotNull(message = "É obrigatório o id do professor")
        Long id_professor
) {
}
