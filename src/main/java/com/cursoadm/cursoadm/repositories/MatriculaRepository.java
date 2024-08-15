package com.cursoadm.cursoadm.repositories;

import com.cursoadm.cursoadm.modules.matriculas.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
