package com.cursoadm.cursoadm.controllers;

import com.cursoadm.cursoadm.dtos.aluno.AlunoAtualizarDto;
import com.cursoadm.cursoadm.dtos.aluno.AlunoRequestDto;
import com.cursoadm.cursoadm.dtos.aluno.AlunoResponseDto;
import com.cursoadm.cursoadm.dtos.aluno.MatricularAlunoDto;
import com.cursoadm.cursoadm.dtos.curso.CursoRequestDTO;
import com.cursoadm.cursoadm.dtos.curso.CursoResponseDTO;
import com.cursoadm.cursoadm.model.Aluno;
import com.cursoadm.cursoadm.model.Curso;
import com.cursoadm.cursoadm.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @PostMapping()
    public ResponseEntity<AlunoResponseDto> criar(@RequestBody AlunoRequestDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.criarAluno(dto));
    }
//    Cadastrar aluno no curso
    @PostMapping("/matricula")
    public ResponseEntity matricular(@RequestBody MatricularAlunoDto dto){
        alunoService.matricularAluno(dto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
//    Sair do curso

//    ver se aluno esta cadastrado em um curso

//    excluir Aluno
    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        alunoService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
//    Atualizar aluno
    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponseDto> atualizar(@RequestBody AlunoAtualizarDto dto, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.atualizar(dto,id));
    }

}
