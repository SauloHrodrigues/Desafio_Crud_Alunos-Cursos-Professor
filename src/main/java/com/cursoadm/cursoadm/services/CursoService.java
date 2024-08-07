package com.cursoadm.cursoadm.services;

import com.cursoadm.cursoadm.dtos.aluno.AlunoResponseDto;
import com.cursoadm.cursoadm.dtos.curso.CursoRequestDTO;
import com.cursoadm.cursoadm.dtos.curso.CursoResponseDTO;
import com.cursoadm.cursoadm.mappers.AlunoMapper;
import com.cursoadm.cursoadm.mappers.CursoMapper;
import com.cursoadm.cursoadm.model.Aluno;
import com.cursoadm.cursoadm.model.Curso;
import com.cursoadm.cursoadm.model.Professor;
import com.cursoadm.cursoadm.repositories.AlunoRepository;
import com.cursoadm.cursoadm.repositories.CursoRepositoy;
import com.cursoadm.cursoadm.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepositoy cursoRepositoy;
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private ProfessorRepository professorRepository;

    private final CursoMapper cursoMapper = CursoMapper.INSTANCE;
    private final AlunoMapper alunoMapper = AlunoMapper.INSTANCE;


    public CursoResponseDTO criar(CursoRequestDTO dto){
        Optional<Curso> curso = cursoRepositoy.findByCurso(dto.curso());
        Optional<Professor> professor = professorRepository.findByCpf(dto.professor().getCpf());
        Professor novoProfessor;
        Curso novoCurso;
        if(curso.isPresent()){
            throw new RuntimeException("Curso já cadastrado");
        } else{
            if (!professor.isPresent()){
                novoProfessor = new Professor();
                novoProfessor.setNome(dto.professor().getNome());
                novoProfessor.setCpf(dto.professor().getCpf());

            }else{
                novoProfessor = professor.get();
            }
            novoCurso= new Curso();
            novoCurso.setCurso(dto.curso());
            novoCurso.setProf(novoProfessor);
            novoProfessor.getCursos().add(novoCurso);
            professorRepository.save(novoProfessor);
            cursoRepositoy.save(novoCurso);

        }

        return cursoMapper.toResponseDto(novoCurso);
    }

    public CursoResponseDTO atualizar(CursoRequestDTO dto, Long id){
        Curso cursoProcurado = cursoRepositoy.findById(id).orElseThrow(()-> new RuntimeException("O curso co id "+id+" não foi encontrado!"));
        cursoMapper.updateAuthorFromResponseDto(cursoProcurado,dto);
        cursoRepositoy.save(cursoProcurado);
        return cursoMapper.toResponseDto(cursoProcurado);
    }

    public void excluir(Long id){
        Curso curso= buscarCursoPorId(id);
        for(Aluno aluno : curso.getAlunos()){
            aluno.getCursos().remove(curso);
            alunoRepository.save(aluno);
        }

        cursoRepositoy.delete(curso);
    }

    public List<CursoResponseDTO> lista(){
        List<Curso> listaAll = cursoRepositoy.findAll();
        List<CursoResponseDTO>resposta = new ArrayList<>();
        for(Curso curso: listaAll){
            resposta.add(cursoMapper.toResponseDto(curso));
        }
        return resposta;
    }

    public List<AlunoResponseDto> listaDeAlunos(Long id ){
        Curso curso = buscarCursoPorId(id);
        List<AlunoResponseDto> alunos = new ArrayList<>();
        for(Aluno aluno : curso.getAlunos()){
            alunos.add(alunoMapper.toResponseDto(aluno));
        }
        return alunos;
    }

    private Curso buscarCursoPorId(Long id){
        return cursoRepositoy.findById(id).orElseThrow(()-> new RuntimeException("O curso com id "+id+" " +
                "não foi encontrado!"));
    }

}
