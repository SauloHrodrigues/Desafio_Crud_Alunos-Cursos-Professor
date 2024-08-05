package com.cursoadm.cursoadm.services;

import com.cursoadm.cursoadm.dtos.aluno.AlunoRequestDto;
import com.cursoadm.cursoadm.mappers.AlunoMapper;
import com.cursoadm.cursoadm.model.Aluno;
import com.cursoadm.cursoadm.model.Curso;
import com.cursoadm.cursoadm.repositories.AlunoRepository;
import com.cursoadm.cursoadm.repositories.CursoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    CursoRepositoy cursoRepositoy;

    private final AlunoMapper alunoMapper = AlunoMapper.INSTANCE;

//     Cadastrar aluno no curso
    @Transactional
    public Aluno criarAluno(AlunoRequestDto requestDto){
        Curso curso = buscarCursoPorId(requestDto.idCurso());
        Aluno novoAluno = alunoMapper.toEntity(requestDto);

        novoAluno.getCursos().add(curso);
//        curso.getAlunos().add(novoAluno);

        alunoRepository.save(novoAluno);
        return novoAluno;
    }
//    Sair do curso

//    ver se aluno esta cadastrado em um curso

//    excluir Aluno

//    Atualizar aluno
    private Aluno buscarAlunoPorId(Long id){
        return alunoRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Autor não encontrado para o id: "+id));
    }
    private Curso buscarCursoPorId(Long id){
        return cursoRepositoy.findById(id).orElseThrow(
                ()-> new RuntimeException("Não foi encontrado nenhum curso com o id: "+id));
    }
}
