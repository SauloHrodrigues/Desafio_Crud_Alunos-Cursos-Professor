package com.cursoadm.cursoadm.services;

import com.cursoadm.cursoadm.dtos.matricula.MatriculaRequestDto;
import com.cursoadm.cursoadm.dtos.matricula.MatriculaResponseDto;
import com.cursoadm.cursoadm.mappers.MatriculaMapper;
import com.cursoadm.cursoadm.model.Aluno;
import com.cursoadm.cursoadm.model.Curso;
import com.cursoadm.cursoadm.model.Matricula;
import com.cursoadm.cursoadm.repositories.AlunoRepository;
import com.cursoadm.cursoadm.repositories.CursoRepositoy;
import com.cursoadm.cursoadm.repositories.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {
    @Autowired
    MatriculaRepository matriculaRepository;
    MatriculaMapper matriculaMapper = MatriculaMapper.INSTANCE;

    public MatriculaResponseDto criar(MatriculaRequestDto dto) {
        Aluno aluno = buscarAluno(dto.idAluno());
        Curso curso = buscarCurso(dto.idCurso());
        Matricula matricula = new Matricula();
        matricula.setCurso(curso);
        matricula.setAluno(aluno);
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
                () -> new RuntimeException("Não foi encontrado nenhuma matricula com o id: " + id)
        );
        matriculaRepository.delete(matricula);
    }

    //    Metodos Auxiliares
    @Autowired
    CursoRepositoy cursoRepositoy;
    @Autowired
    AlunoRepository alunoRepository;
    private Curso buscarCurso(Long id){
        return cursoRepositoy.findById(id).orElseThrow(()-> new RuntimeException("O curso com id "+id+" " +
                "não foi encontrado!"));
    }

    private Aluno buscarAluno(Long id){
        return alunoRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("O aluno com ID "+id+" não foi encontrado!"));
    }
}