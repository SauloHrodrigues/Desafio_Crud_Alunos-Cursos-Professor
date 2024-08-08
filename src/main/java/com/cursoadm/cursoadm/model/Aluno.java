package com.cursoadm.cursoadm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;

    // @ManyToMany(mappedBy = "alunos" , fetch = FetchType.LAZY)
    // @JsonIgnore
    // private Set<Curso> cursos= new HashSet<>();

    @OneToMany(mappedBy = "aluno")
    @JsonIgnore
    private Set<Matricula> matriculas;

}
