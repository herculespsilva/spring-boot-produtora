package br.gov.sp.fatec.springbootprodutora.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springbootprodutora.entity.Ator;
import br.gov.sp.fatec.springbootprodutora.service.ProdutoraServiceProvider;

@RestController
@RequestMapping(value = "/ator")
@CrossOrigin
public class AtorController {
    
    @Autowired
    private ProdutoraServiceProvider produtoraService;

    @JsonView(View.Ator.class)
    @GetMapping
    public List<Ator> buscarTodos()
    {
        return produtoraService.buscarTodosAtores();
    }

    @JsonView(View.Ator.class)
    @GetMapping (value="/id/{id}")
    public Ator buscarPorId(@PathVariable("id") Long id)
    {
        return produtoraService.buscarAtorPorId(id);
    }

    @JsonView(View.Ator.class)
    @GetMapping (value = "/nome/{nome}")
    public Ator buscarPorNome(@PathVariable("nome")  String nome)
    {
        return produtoraService.buscarAtorPorNome(nome);
    }

    @JsonView(View.Ator.class)
    @GetMapping (value = "/letra/{nome}")
    public List<Ator> buscaAtorPorLetra(@PathVariable("nome")  String nome)
    {
        return produtoraService.buscarAtorPorLetra(nome);
    }
}