package com.cursoadm.cursoadm.services;

import com.cursoadm.cursoadm.modules.matriculas.dtos.MatriculaRequestDto;
import com.cursoadm.cursoadm.modules.matriculas.dtos.MatriculaResponseDto;
import com.cursoadm.cursoadm.exception.ObjetoNaoEncontradoException;
import com.cursoadm.cursoadm.modules.matriculas.mappers.MatriculaMapper;
import com.cursoadm.cursoadm.modules.alunos.Aluno;
import com.cursoadm.cursoadm.modules.curso.Curso;
import com.cursoadm.cursoadm.modules.matriculas.Matricula;
import com.cursoadm.cursoadm.repositories.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {
    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private CursoService cursoService;

    private final MatriculaMapper matriculaMapper = MatriculaMapper.INSTANCE;

    public MatriculaResponseDto criar(MatriculaRequestDto dto) {
        Aluno aluno = alunoService.buscarAluno(dto.idAluno());
        Curso curso = cursoService.buscarCursoPorId(dto.idCurso());
        Matricula matricula = matriculaMapper.toEntity(aluno,curso);
        matriculaRepository.save(matricula);
        return matriculaMapper.toResponseDto(matricula);
    }

    public List<MatriculaResponseDto> matriculas(){
        List<Matricula> matriculaList = matriculaRepository.findAll();
        List<MatriculaResponseDto>listaResposta = matriculaMapper.toListResponseDto(matriculaList);
        return listaResposta;
    }

    public void deletar(Long id) {
        Matricula matricula = matriculaRepository.findById(id).orElseThrow(
                () -> new ObjetoNaoEncontradoException("Não foi encontrado nenhuma matricula com o id: " + id)
        );
        matriculaRepository.delete(matricula);
    }
}