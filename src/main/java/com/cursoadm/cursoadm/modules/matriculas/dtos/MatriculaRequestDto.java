package com.cursoadm.cursoadm.modules.matriculas.dtos;

import jakarta.validation.constraints.NotNull;

public record MatriculaRequestDto(
        @NotNull(message = "É obrigatório informar o ID do curso")
        Long idCurso,
        @NotNull(message = "É obrigatório informar o ID do aluno")
        Long idAluno
) {
}