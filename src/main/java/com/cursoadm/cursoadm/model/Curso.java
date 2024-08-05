package com.cursoadm.cursoadm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String curso;

    @ManyToOne
    @JoinColumn(name = "p_id", nullable = false)
    private Professor prof;
    @ManyToMany
    @JoinTable(name = "Tabela_de_Juncao",
                joinColumns = @JoinColumn(name = "curso_id"),
                inverseJoinColumns = @JoinColumn(name = "aluno_id"))
    private Set<Aluno> alunos;

}
