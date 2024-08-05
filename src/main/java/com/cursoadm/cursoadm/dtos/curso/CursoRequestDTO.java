package com.cursoadm.cursoadm.dtos.curso;

import com.cursoadm.cursoadm.model.Professor;
import jakarta.validation.constraints.NotBlank;

public record CursoRequestDTO(
        @NotBlank(message = "O campo curso deve ser preenchido")
        String curso,
        Professor professor
) {

}
