package com.cursoadm.cursoadm.modules.curso;

import com.cursoadm.cursoadm.modules.professor.Professor;
import com.cursoadm.cursoadm.modules.matriculas.Matricula;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @JoinColumn(name = "professor_id")//
    @JsonIgnore
    private Professor professor;

    @OneToMany(mappedBy = "curso")
    @JsonIgnore
    private Set<Matricula> matriculas;

    public void addMatricula(Matricula matricula){
        matriculas.add(matricula);
    }
    public void removerMatritcula(Matricula matricula){
        matriculas.remove(matricula);
    }
}
