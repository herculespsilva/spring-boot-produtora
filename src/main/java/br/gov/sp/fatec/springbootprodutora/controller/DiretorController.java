package br.gov.sp.fatec.springbootprodutora.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springbootprodutora.entity.Diretor;
import br.gov.sp.fatec.springbootprodutora.service.SegurancaService;

@RestController
@RequestMapping(value = "/diretor")
@CrossOrigin

public class DiretorController {
    
    @Autowired
    private SegurancaService segurancaService;

    @JsonView(View.Diretor.class)
    @GetMapping
    public List<Diretor> buscarTodos()
    {
        return segurancaService.buscarTodosDiretores();
    }

}