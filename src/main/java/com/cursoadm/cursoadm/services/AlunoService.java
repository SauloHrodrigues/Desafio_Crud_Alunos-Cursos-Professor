package com.cursoadm.cursoadm.services;

import com.cursoadm.cursoadm.dtos.aluno.AlunoAtualizarDto;
import com.cursoadm.cursoadm.dtos.aluno.AlunoRequestDto;
import com.cursoadm.cursoadm.dtos.aluno.AlunoResponseDto;
import com.cursoadm.cursoadm.dtos.aluno.MatricularAlunoDto;
import com.cursoadm.cursoadm.dtos.curso.CursoResponseDTO;
import com.cursoadm.cursoadm.mappers.AlunoMapper;
import com.cursoadm.cursoadm.model.Aluno;
import com.cursoadm.cursoadm.model.Curso;
import com.cursoadm.cursoadm.repositories.AlunoRepository;
import com.cursoadm.cursoadm.repositories.CursoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

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

    //     Cadastrar aluno no curso
    public void matricularAluno(MatricularAlunoDto dto){
        Curso curso = buscarCursoPorId(dto.idCurso());
        Aluno aluno = buscarAlunoPorId(dto.idAluno());
        if(curso.getAlunos()==null){
            curso.setAlunos(new HashSet<>());
        }
        curso.getAlunos().add(aluno);
        cursoRepositoy.save(curso);
    }

//    Sair do curso

//    ver se aluno esta cadastrado em um curso

//    excluir Aluno
    public void excluir(Long id){
        Aluno aluno = buscarAlunoPorId(id);
        alunoRepository.delete(aluno);
    }

//    Atualizar aluno
public AlunoResponseDto atualizar(AlunoAtualizarDto dto, Long id){
    Aluno alunoAtualizando = buscarAlunoPorId(id);
    alunoMapper.updateAlunoFromResponseDto(alunoAtualizando, dto);
    alunoRepository.save(alunoAtualizando);
    return alunoMapper.toResponseDto(alunoAtualizando);
}

// Metodos auxiliares
    private Aluno buscarAlunoPorId(Long id){
        return alunoRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Autor não encontrado para o id: "+id));
    }
    private Curso buscarCursoPorId(Long id){
        return cursoRepositoy.findById(id).orElseThrow(
                ()-> new RuntimeException("Não foi encontrado nenhum curso com o id: "+id));
    }
}
