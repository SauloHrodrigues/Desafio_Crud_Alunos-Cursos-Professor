package com.cursoadm.cursoadm.controllers;

import com.cursoadm.cursoadm.modules.matriculas.dtos.MatriculaRequestDto;
import com.cursoadm.cursoadm.modules.matriculas.dtos.MatriculaResponseDto;
import com.cursoadm.cursoadm.services.MatriculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/matricula")
public class MatriculaController {
    @Autowired
    MatriculaService service;

    // Criar Matricula -
    @PostMapping()
    public ResponseEntity<MatriculaResponseDto> create (@Valid @RequestBody MatriculaRequestDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @GetMapping
    public ResponseEntity<List<MatriculaResponseDto>> lista(){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.matriculas());
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}