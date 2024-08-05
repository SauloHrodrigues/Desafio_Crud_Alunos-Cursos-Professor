package com.cursoadm.cursoadm.controllers;

import com.cursoadm.cursoadm.dtos.aluno.AlunoResponseDto;
import com.cursoadm.cursoadm.dtos.curso.CursoRequestDTO;
import com.cursoadm.cursoadm.dtos.curso.CursoResponseDTO;
import com.cursoadm.cursoadm.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/curso")
public class CursoController {
    @Autowired
    CursoService service;

    // Criar Curso
    @PostMapping()
    public ResponseEntity<CursoResponseDTO> create (@RequestBody CursoRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }
    //Atualizar Curso
    @PutMapping("/{id}")
    public ResponseEntity<CursoResponseDTO> update(@RequestBody CursoRequestDTO dto, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizar(dto,id));
    }
    //Excluir Curso
    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    //Ver os Alunos do Curso
    @GetMapping("/{id}")
    public ResponseEntity<List<AlunoResponseDto>> alunos(@PathVariable Long id){
        List<AlunoResponseDto> alunosList = service.listaDeAlunos(id);
        return ResponseEntity.status(HttpStatus.OK).body(alunosList);
    }

    //Ver todos os cursos
    @GetMapping("/listar")
    public ResponseEntity<List<CursoResponseDTO>> lista(){
        List<CursoResponseDTO> lista = service.lista();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

}
