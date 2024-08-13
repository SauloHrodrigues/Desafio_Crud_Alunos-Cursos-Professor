package com.cursoadm.cursoadm.dtos.matricula;

import jakarta.validation.constraints.NotNull;

public record MatriculaRequestDto(
        @NotNull Long idCurso,
        @NotNull Long idAluno

) {
}
