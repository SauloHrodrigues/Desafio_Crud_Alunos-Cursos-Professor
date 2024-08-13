package com.cursoadm.cursoadm.dtos.matricula;

import com.cursoadm.cursoadm.model.Aluno;
import com.cursoadm.cursoadm.model.Curso;
import jakarta.validation.constraints.NotNull;

public record MatriculaResponseDto(
        Long id,
        Aluno aluno,
        Curso curso

) {
}
