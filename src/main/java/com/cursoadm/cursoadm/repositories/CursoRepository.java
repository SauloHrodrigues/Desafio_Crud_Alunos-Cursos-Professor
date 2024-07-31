package com.cursoadm.cursoadm.repositories;

import com.cursoadm.cursoadm.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Long> {
}
