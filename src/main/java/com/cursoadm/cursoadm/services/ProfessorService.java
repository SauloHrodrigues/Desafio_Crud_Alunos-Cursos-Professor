package com.cursoadm.cursoadm.services;

import com.cursoadm.cursoadm.dtos.professor.ProfessorAtualizadoDto;
import com.cursoadm.cursoadm.dtos.professor.ProfessorRequestDto;
import com.cursoadm.cursoadm.dtos.professor.ProfessorResponseDto;
import com.cursoadm.cursoadm.mappers.ProfessorMapper;
import com.cursoadm.cursoadm.model.Curso;
import com.cursoadm.cursoadm.model.Professor;
import com.cursoadm.cursoadm.repositories.CursoRepositoy;
import com.cursoadm.cursoadm.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private CursoRepositoy cursoRepositoy;

    private final ProfessorMapper professorMapper = ProfessorMapper.INSTANCE;

    //    cadastrar
    public ProfessorResponseDto cadastrar(ProfessorRequestDto dto) {
        Professor professor = professorMapper.toEntity(dto);
        professorRepository.save(professor);
        return professorMapper.toResponseDto(professor);
    }

    //    ler
    public List<ProfessorResponseDto> listar() {
        List<Professor> professores = professorRepository.findAll();
        List<ProfessorResponseDto> professorResponseDtoList = new ArrayList<>();
        for(Professor prof: professores){
            professorResponseDtoList.add(professorMapper.toResponseDto(prof));
        }
        return professorResponseDtoList;
    }

    //    atualizar
    public ProfessorResponseDto atualizar(Long id, ProfessorAtualizadoDto dto) {
        Professor professorAtualizado = buscarProfessoPorId(id);
        professorMapper.updateProfessorFromResponseDto(professorAtualizado,dto);
        professorRepository.save(professorAtualizado);
        return professorMapper.toResponseDto(professorAtualizado);
    }

    //    deletar
    public void apagar(Long id) {
        Professor professor = buscarProfessoPorId(id);
        professorRepository.delete(professor);
    }

    private Professor buscarProfessoPorId(Long id){
        return professorRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Não foi encontrado nenhum professor com o id: "+id));
    }

}