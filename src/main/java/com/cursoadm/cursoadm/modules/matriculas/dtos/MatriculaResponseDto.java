package com.cursoadm.cursoadm.modules.matriculas.dtos;

import com.cursoadm.cursoadm.modules.alunos.Aluno;
import com.cursoadm.cursoadm.modules.curso.Curso;

public record MatriculaResponseDto(
        Long id,
        Aluno aluno,
        Curso curso

) {
}
