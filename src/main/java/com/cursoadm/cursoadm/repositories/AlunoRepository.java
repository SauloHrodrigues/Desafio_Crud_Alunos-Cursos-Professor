package com.cursoadm.cursoadm.repositories;

import com.cursoadm.cursoadm.modules.alunos.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	// @Query("SELECT a FROM Aluno a JOIN a.cursos c WHERE c.id = :cursoId")
	// List<Aluno> findAllByCursoId(@Param("cursoId") Long cursoId);
}
