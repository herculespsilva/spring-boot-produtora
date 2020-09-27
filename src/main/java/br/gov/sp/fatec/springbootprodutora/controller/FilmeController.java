package br.gov.sp.fatec.springbootprodutora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springbootprodutora.entity.Filme;
import br.gov.sp.fatec.springbootprodutora.service.SegurancaService;

@RestController
@RequestMapping(value = "/filme")
@CrossOrigin

public class FilmeController {

    @Autowired
    private SegurancaService segurancaService;

    @GetMapping
    public List<Filme> buscarTodos(){
        return segurancaService.buscarTodosFilmes();        
    }
    
    @GetMapping(value="/{id}")
    public Filme buscarPorID(@PathVariable("id") Long id){
        return segurancaService.buscarFilmeId(id);
    }

    
}