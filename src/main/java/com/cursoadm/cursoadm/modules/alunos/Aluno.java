package com.cursoadm.cursoadm.modules.alunos;

import com.cursoadm.cursoadm.modules.matriculas.Matricula;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
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
    @Column(unique = true)
    private String cpf;


    @OneToMany(mappedBy = "aluno")
    @JsonIgnore
    private Set<Matricula> matriculas = new HashSet<>();

    public void addMatricula(Matricula matricula){
        matriculas.add(matricula);
    }
    public void removerMatritcula(Matricula matricula){
        matriculas.remove(matricula);
    }

}
