package com.cursoadm.cursoadm.services;

import com.cursoadm.cursoadm.dtos.aluno.*;
import com.cursoadm.cursoadm.mappers.AlunoMapper;
import com.cursoadm.cursoadm.model.Aluno;
import com.cursoadm.cursoadm.model.Curso;
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

//    buscar Aluno

    // public AlunoResponseDto buscarAluno(Long id){
    //     Aluno aluno = buscarAlunoPorId(id);
    //     Set<Curso>  cursoDoAluno = aluno.getCursos();
    //     AlunoResponseDto resposta = new AlunoResponseDto(
    //             aluno.getId(), aluno.getNome(),aluno.getCpf(),cursoDoAluno);

    //     return alunoMapper.toResponseDto(aluno);
    // }

    //     Cadastrar aluno no curso
    // public void matricularAluno(Long idAluno, Id_CursoRequestDto dto){
    //     System.out.println("Entrou no matricular");
    //     Curso curso = buscarCursoPorId(dto.idCurso());
    //     Aluno aluno = buscarAlunoPorId(idAluno);
    //     if(curso.getAlunos()==null){
    //         curso.setAlunos(new HashSet<>());
    //     }
    //     curso.getAlunos().add(aluno);
    //     cursoRepositoy.save(curso);
    // }

//    Sair do curso
    // public void desmatricula(Long idAluno, Long idCurso){
    //     Curso curso = buscarCursoPorId(idCurso);
    //     Aluno aluno = buscarAlunoPorId(idAluno);

    //     if(curso.getAlunos().remove(aluno)){
    //         aluno.getCursos().remove(curso);
    //         alunoRepository.save(aluno);
    //         cursoRepositoy.save(curso);
    //         System.out.println("Aluno removido!!!");
    //     }else{
    //         throw new RuntimeException("Aluno não matriculado nesse curso!");
    //     }

    // }
//    ver se aluno esta cadastrado em um curso
    // public AlunoResponseDto alunoEstaCadastradoNoCurso(Long idAluno, Id_CursoRequestDto dto){
    //     Aluno aluno = buscarAlunoPorId(idAluno);
    //     Curso curso = buscarCursoPorId(dto.idCurso());
    //     if(aluno.getCursos().contains(curso)){
    //         return alunoMapper.toResponseDto(aluno);
    //     }else {
    //         return null;
    //     }
    // }
// 
    public AlunoResponseDto getAluno(Long id ) {
        Aluno aluno = alunoRepository.findById(id).
            orElseThrow(() -> new RuntimeException("Não foi localizado um aluno para o id " + id));

        return alunoMapper.toResponseDto(aluno);
    }

    // public List<AlunoResponseDto> getAlunos(Long cursoId){
    //     List<Aluno> alunos = new ArrayList<>();
    //     if(cursoId != null) {
    //         alunos = alunoRepository.findAllByCursoId(cursoId);
    //     } else {
    //         alunos = alunoRepository.findAll();
    //     }

    //     return alunoMapper.toResponseDto(alunos);
    // }

//    excluir Aluno
    // @Transactional
    // public void excluir(Long id){
    //     Aluno aluno = buscarAlunoPorId(id);
    //     for(Curso curso : aluno.getCursos()){
    //         curso.getAlunos().remove(aluno);
    //         cursoRepositoy.save(curso);
    //     }

    //     alunoRepository.delete(aluno);
    // }

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
