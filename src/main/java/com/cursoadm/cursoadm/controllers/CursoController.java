package com.cursoadm.cursoadm.controllers;

import com.cursoadm.cursoadm.dtos.curso.CursoAtualizarDTO;
import com.cursoadm.cursoadm.dtos.curso.CursoCadastroDTO;
import com.cursoadm.cursoadm.dtos.curso.CursoResponseDTO;
import com.cursoadm.cursoadm.services.CursoService;
import jakarta.validation.Valid;
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

    // Criar Curso - ok
    @PostMapping()
    public ResponseEntity<CursoResponseDTO> create (@Valid @RequestBody CursoCadastroDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    //Ver todos os cursos
    //Nao utilizar verbos na rota. Um get sem nenhum argumento na rota já é suficiente pra entender que retornará todos os objetos.
    @GetMapping()
    public ResponseEntity<List<CursoResponseDTO>> lista(){
        List<CursoResponseDTO> lista = service.lista();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CursoResponseDTO> getCurso(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getCursoById(id));
    }

    //Atualizar Curso ok
    @PutMapping("/{id}")
    public ResponseEntity<CursoResponseDTO> update(@RequestBody CursoAtualizarDTO dto, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizar(dto,id));
    }
//    Excluir Curso - ok
     @DeleteMapping("/{id}")
     public ResponseEntity excluir(@PathVariable Long id){
         service.excluir(id);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
     }
}