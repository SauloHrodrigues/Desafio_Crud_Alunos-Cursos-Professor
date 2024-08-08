package com.cursoadm.cursoadm.controllers;

import com.cursoadm.cursoadm.dtos.aluno.*;
import com.cursoadm.cursoadm.services.AlunoService;

import java.util.List;

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
    // @PostMapping("/{id}")
    // public ResponseEntity<Void> matricular(@PathVariable Long id, @RequestBody Id_CursoRequestDto idCurso){
    //     alunoService.matricularAluno(id,idCurso);
    //     return ResponseEntity.status(HttpStatus.OK).build();
    // }

    // @PatchMapping("/matricula/{idAluno}")
    // public ResponseEntity<Void> sairDoCurso(@PathVariable Long idAluno, @RequestBody Id_CursoRequestDto dto){
    //     alunoService.desmatricula(idAluno,dto.idCurso());
    //     return ResponseEntity.status(HttpStatus.OK).build();
    // }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDto> getAluno(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.getAluno(id));
        
    }

    // @GetMapping()
    // public ResponseEntity<List<AlunoResponseDto>> getAlunos(
    //         @RequestParam(name = "cursoId", required = false) Long cursoId 
    //     ) {
    //     return ResponseEntity.status(HttpStatus.OK).body(alunoService.getAlunos(cursoId));
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> excluir(@PathVariable Long id){
    //     alunoService.excluir(id);
    //     return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    // }
    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponseDto> atualizar(@RequestBody AlunoAtualizarDto dto, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.atualizar(dto,id));
    }
}