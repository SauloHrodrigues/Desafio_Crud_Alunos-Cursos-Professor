package com.cursoadm.cursoadm.repositories;

import com.cursoadm.cursoadm.model.Aluno;
import com.cursoadm.cursoadm.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	// @Query("SELECT a FROM Aluno a JOIN a.cursos c WHERE c.id = :cursoId")
	// List<Aluno> findAllByCursoId(@Param("cursoId") Long cursoId);
}
