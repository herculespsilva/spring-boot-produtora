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
@CrossOrigin //permite acessar de qualquer servidor

public class FilmeController {

    @Autowired
    private SegurancaService segurancaService;

    @GetMapping
    public List<Filme> buscarTodos(){
        return segurancaService.buscarTodosFilmes();        
    }
    
    @GetMapping(value="/{id}")
    
    public Filme buscarPorID(@PathVariable("id") Long id){ //public Filme buscarPorID(@RequestParam(value="id") Long id) <--- Outra forma de receber valores via GET mas chama na URL /id?id=valor
        return segurancaService.buscarFilmeId(id);
    }

    /*
    @PostMapping
    public Filme cadastrarFilme(@RequestBody Filme filme){
        Ator ator ;
        Duble duble;
        Diretor diretor;
        return segurancaService.criaFilme(filme.getNome(), filme.getAno(), filme.getDuracao(), filme.getDescricao(), filme.getPessoas(), ator.getNome(), duble.getNome());
    }*/

    
}