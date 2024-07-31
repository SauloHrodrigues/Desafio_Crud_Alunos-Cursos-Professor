package com.cursoadm.cursoadm.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nomeDoCurso;

    @ManyToMany
    @JoinTable(name = "curso_aluno",
    joinColumns = @JoinColumn(name = "curso_fk"),
    inverseJoinColumns = @JoinColumn(name = "aluno_fk"))
    private List<Aluno> listaDeAlunos;

    //    @Column
    @ManyToOne
    @JoinColumn(name = "id_do_professor")
    private Professor professor; // => https://www.youtube.com/watch?v=13ENb1zFfUk
}