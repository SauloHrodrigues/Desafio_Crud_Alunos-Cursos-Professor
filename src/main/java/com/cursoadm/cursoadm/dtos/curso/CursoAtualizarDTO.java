package com.cursoadm.cursoadm.dtos.curso;

import com.cursoadm.cursoadm.dtos.professor.ProfessorAtualizadoDto;
import com.cursoadm.cursoadm.dtos.professor.ProfessorRequestDto;
import com.cursoadm.cursoadm.model.Professor;
import jakarta.validation.constraints.NotBlank;

public record CursoAtualizarDTO(
        @NotBlank(message = "O campo curso deve ser preenchido")
        String curso,
        Professor professor,
        Long id_professor
) {

}
