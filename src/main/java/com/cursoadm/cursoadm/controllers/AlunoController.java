package com.cursoadm.cursoadm.controllers;

import com.cursoadm.cursoadm.dtos.aluno.*;
import com.cursoadm.cursoadm.services.AlunoService;

import java.util.List;

import jakarta.validation.Valid;
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
    public ResponseEntity<AlunoResponseDto> criar(@Valid @RequestBody AlunoRequestDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.criarAluno(dto));
    }

    @GetMapping()
    public ResponseEntity<List<AlunoResponseDto>> listar(){
        List<AlunoResponseDto> lista = alunoService.listarAlunos();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDto> buscarAluno(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.buscarAlunoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponseDto> atualizar(@RequestBody AlunoAtualizarDto dto, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.atualizar(dto,id));
    }

     @DeleteMapping("/{id}")
     public ResponseEntity<Void> excluir(@PathVariable Long id){
         alunoService.deletar(id);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
     }
}