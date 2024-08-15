package com.cursoadm.cursoadm.repositories;

import com.cursoadm.cursoadm.modules.professor.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor,Long> {
    Optional<Professor> findByCpf(String cpf);
}
