package com.cursoadm.cursoadm.controllers;

import com.cursoadm.cursoadm.dtos.aluno.AlunoRequestDto;
import com.cursoadm.cursoadm.model.Aluno;
import com.cursoadm.cursoadm.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @PostMapping()
    public ResponseEntity<Aluno> criar(@RequestBody AlunoRequestDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.criarAluno(dto));
    }
//    Cadastrar aluno no curso

//    Sair do curso

//    ver se aluno esta cadastrado em um curso

//    excluir Aluno

//    Atualizar aluno
}
