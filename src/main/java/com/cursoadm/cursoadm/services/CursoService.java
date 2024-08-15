package com.cursoadm.cursoadm.services;

import com.cursoadm.cursoadm.modules.curso.dtos.CursoAtualizarDTO;
import com.cursoadm.cursoadm.modules.curso.dtos.CursoCadastroDTO;
import com.cursoadm.cursoadm.modules.curso.dtos.CursoResponseDTO;
import com.cursoadm.cursoadm.exception.ObjetoNaoEncontradoException;
import com.cursoadm.cursoadm.modules.curso.mappers.CursoMapper;
import com.cursoadm.cursoadm.modules.professor.mappers.ProfessorMapper;
import com.cursoadm.cursoadm.modules.curso.Curso;
import com.cursoadm.cursoadm.modules.matriculas.Matricula;
import com.cursoadm.cursoadm.modules.professor.Professor;
import com.cursoadm.cursoadm.repositories.CursoRepositoy;
import com.cursoadm.cursoadm.repositories.MatriculaRepository;
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
    private ProfessorRepository professorRepository;

    @Autowired
    private MatriculaRepository matriculaRepository;

    private final CursoMapper cursoMapper = CursoMapper.INSTANCE;
    private final ProfessorMapper professorMapper = ProfessorMapper.INSTANCE;

    public CursoResponseDTO criar(CursoCadastroDTO dto){
        Optional<Curso> curso = cursoRepositoy.findByCurso(dto.curso());
        Curso novoCurso;
        Professor professor;

        if(curso.isPresent()){
            throw new ObjetoNaoEncontradoException("Curso já cadastrado");
        }

        novoCurso = cursoMapper.toEntity(dto);
        professor = professorRepository.findById(dto.id_professor()).orElseThrow(
                ()-> new ObjetoNaoEncontradoException("O professor de id "+dto.id_professor()+" não foi encontrado!")
        );
        novoCurso.setProfessor(professor);
        cursoRepositoy.save(novoCurso);
        return cursoMapper.toResponseDto(novoCurso);
    }

    public CursoResponseDTO atualizar(CursoAtualizarDTO dto, Long id){
        Curso cursoProcurado = buscarCursoPorId(id);

        if(dto.id_professor()!=null) { //tem professor
            Professor professor = professorRepository.findById(dto.id_professor()).orElseThrow(
                    ()-> new ObjetoNaoEncontradoException("O professor de id "+dto.id_professor()+" não foi encontrado!")
            );
            cursoProcurado.setProfessor(professor);
            professor.getCursos().add(cursoProcurado);
            professorRepository.save(professor);
            cursoProcurado.setProfessor(professor);
        }
        if (dto.curso()!= null){
            cursoProcurado.setCurso(dto.curso());
        }

        cursoRepositoy.save(cursoProcurado);
        return cursoMapper.toResponseDto(cursoProcurado);
    }

     public void excluir(Long id){
         Curso curso= buscarCursoPorId(id);
         for(Matricula matricula : curso.getMatriculas()){
             matriculaRepository.delete(matricula);
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

    public CursoResponseDTO getCursoById(Long id) {
        Curso curso = buscarCursoPorId(id);
        return cursoMapper.toResponseDto(curso);
    }

    public Curso buscarCursoPorId(Long id){
        return cursoRepositoy.findById(id).orElseThrow(()-> new ObjetoNaoEncontradoException("O curso com id "+id+" " +
                "não foi encontrado!"));
    }
}