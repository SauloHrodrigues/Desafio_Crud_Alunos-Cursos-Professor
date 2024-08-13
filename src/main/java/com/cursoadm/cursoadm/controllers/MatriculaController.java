package com.cursoadm.cursoadm.controllers;

import com.cursoadm.cursoadm.dtos.curso.CursoAtualizarDTO;
import com.cursoadm.cursoadm.dtos.curso.CursoCadastroDTO;
import com.cursoadm.cursoadm.dtos.curso.CursoResponseDTO;
import com.cursoadm.cursoadm.dtos.matricula.MatriculaRequestDto;
import com.cursoadm.cursoadm.dtos.matricula.MatriculaResponseDto;
import com.cursoadm.cursoadm.services.CursoService;
import com.cursoadm.cursoadm.services.MatriculaService;
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
    public ResponseEntity<MatriculaResponseDto> create (@RequestBody MatriculaRequestDto dto){
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