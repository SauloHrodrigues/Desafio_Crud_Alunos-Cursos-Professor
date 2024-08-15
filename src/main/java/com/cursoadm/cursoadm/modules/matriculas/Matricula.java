package com.cursoadm.cursoadm.modules.matriculas;

import com.cursoadm.cursoadm.modules.curso.Curso;
import com.cursoadm.cursoadm.modules.alunos.Aluno;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "matriculas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;
}