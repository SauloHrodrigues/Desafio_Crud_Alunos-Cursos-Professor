package com.cursoadm.cursoadm.services;

import com.cursoadm.cursoadm.dtos.aluno.*;
import com.cursoadm.cursoadm.exception.ObjetoNaoEncontradoException;
import com.cursoadm.cursoadm.mappers.AlunoMapper;
import com.cursoadm.cursoadm.model.Aluno;
import com.cursoadm.cursoadm.model.Curso;
import com.cursoadm.cursoadm.model.Matricula;
import com.cursoadm.cursoadm.repositories.AlunoRepository;
import com.cursoadm.cursoadm.repositories.CursoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    CursoRepositoy cursoRepositoy;

    private final AlunoMapper alunoMapper = AlunoMapper.INSTANCE;

//   Criar aluno
    public AlunoResponseDto criarAluno(AlunoRequestDto requestDto){
        Aluno novoAluno = alunoMapper.toEntity(requestDto);
        alunoRepository.save(novoAluno);
        return alunoMapper.toResponseDto(novoAluno);
    }

//    Lista de alunos cadastrados

    public List<AlunoResponseDto> listarAlunos(){
        List<AlunoResponseDto>resposta = new ArrayList<>();
        List<Aluno> alunos = alunoRepository.findAll();
        resposta = alunoMapper.toListResponseDto(alunos);
        return resposta;
    }

    public AlunoResponseDto buscarAlunoPorId(Long id){
        return alunoMapper.toResponseDto(buscarAluno(id));
    }

    public AlunoResponseDto atualizar(AlunoAtualizarDto dto, Long id){
        Aluno alunoAtualizando = buscarAluno(id);
        alunoMapper.updateAlunoFromResponseDto(alunoAtualizando, dto);
        alunoRepository.save(alunoAtualizando);
        return alunoMapper.toResponseDto(alunoAtualizando);
    }

    public void deletar(Long id){
        Aluno aluno = buscarAluno(id);
        alunoRepository.delete(aluno);
    }

    public Aluno buscarAluno(Long id){
        return alunoRepository.findById(id).orElseThrow(
                ()-> new ObjetoNaoEncontradoException("O aluno com ID "+id+" não foi encontrado!"));
    }
}