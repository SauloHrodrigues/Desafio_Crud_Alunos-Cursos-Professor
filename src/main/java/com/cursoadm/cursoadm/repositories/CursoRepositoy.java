package com.cursoadm.cursoadm.repositories;

import com.cursoadm.cursoadm.modules.curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursoRepositoy extends JpaRepository<Curso,Long> {
    Optional<Curso> findByCurso(String nome);
}
