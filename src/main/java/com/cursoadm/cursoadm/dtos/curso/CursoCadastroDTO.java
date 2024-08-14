package com.cursoadm.cursoadm.dtos.curso;
import com.cursoadm.cursoadm.dtos.professor.ProfessorRequestDto;
import com.cursoadm.cursoadm.model.Professor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CursoCadastroDTO(
        @NotBlank(message = "O campo curso deve ser preenchido")
        String curso,
        @NotNull(message = "É obrigatório o id do professor")
        Long id_professor
) {
}
