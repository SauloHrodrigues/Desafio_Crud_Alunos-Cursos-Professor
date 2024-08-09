package com.cursoadm.cursoadm.controllers;

import com.cursoadm.cursoadm.dtos.professor.ProfessorAtualizadoDto;
import com.cursoadm.cursoadm.dtos.professor.ProfessorRequestDto;
import com.cursoadm.cursoadm.dtos.professor.ProfessorResponseDto;
import com.cursoadm.cursoadm.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService service;

    //    cadastrar  -  OK
    @PostMapping
    public ResponseEntity<ProfessorResponseDto> cadastrar(@RequestBody ProfessorRequestDto dto) {
        ProfessorResponseDto resposta = service.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }


    //    ler - OK
    @GetMapping
    public ResponseEntity<List<ProfessorResponseDto>> listar() {
        List<ProfessorResponseDto> resposta = service.listar();
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

    //    atualizar
    @PutMapping("/{id}")
    public ResponseEntity<ProfessorResponseDto> atualizar(@PathVariable Long id, @RequestBody ProfessorAtualizadoDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizar(id, dto));
    }

    //    deletar
    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        service.apagar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}