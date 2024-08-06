package com.cursoadm.cursoadm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    @OneToMany(mappedBy = "prof", fetch = FetchType.EAGER)
    @JsonIgnore
    List<Curso> cursos = new ArrayList<>();

    @PreRemove
    public void atualizarCursosAntesDeDeletarProfessor(){
        System.out.println("atualizarCursosAntesDeDeletarProfessor");
        for(Curso curso: this.cursos){
            curso.setProf(null);
        }
    }
}
