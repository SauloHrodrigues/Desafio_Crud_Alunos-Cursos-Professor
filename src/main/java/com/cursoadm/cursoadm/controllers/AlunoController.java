package com.cursoadm.cursoadm.controllers;

import com.cursoadm.cursoadm.dtos.aluno.*;
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

    // Criar Aluno - OK
    @PostMapping()
    public ResponseEntity<AlunoResponseDto> criar(@RequestBody AlunoRequestDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.criarAluno(dto));
    }
//    Cadastrar aluno no curso - OK
    @PostMapping("/{id}")
    public ResponseEntity matricular(@PathVariable Long id, @RequestBody Id_CursoRequestDto idCurso){
        alunoService.matricularAluno(id,idCurso);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

//    Sair do curso
    @PatchMapping("/matricula/{idAluno}")
    public ResponseEntity sairDoCurso(@PathVariable Long idAluno, @RequestBody Id_CursoRequestDto dto){
        alunoService.desmatricula(idAluno,dto.idCurso());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

//    ver se aluno esta cadastrado em um curso - ok
    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDto> consultarAlunoNoCurso(@PathVariable Long id, @RequestBody  Id_CursoRequestDto dto){
                AlunoResponseDto resposta = alunoService.alunoEstaCadastradoNoCurso(id, dto);
                if(resposta == null){
                    return ResponseEntity.status(404).build();
                }else{
                    return ResponseEntity.status(HttpStatus.FOUND).body(alunoService.alunoEstaCadastradoNoCurso(id, dto));
                }
    }
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