package com.cursoadm.cursoadm.modules.professor.dtos;

public record ProfessorResponseDto(
        Long id,
        String nome,
        String cpf
//        Set<Curso> cursos

) {
}
