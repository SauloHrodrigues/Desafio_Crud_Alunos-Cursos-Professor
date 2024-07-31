package com.cursoadm.cursoadm.repositories;

import com.cursoadm.cursoadm.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor,Long> {
}
