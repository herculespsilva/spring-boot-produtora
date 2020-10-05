package br.gov.sp.fatec.springbootprodutora.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springbootprodutora.entity.Duble;
import br.gov.sp.fatec.springbootprodutora.service.ProdutoraServiceProvider;

@RestController
@RequestMapping(value = "/duble")
@CrossOrigin
public class DubleController {
    
    @Autowired
    private ProdutoraServiceProvider produtoraService;

    @JsonView(View.Duble.class)
    @GetMapping
    public List<Duble> buscarTodos()
    {
        return produtoraService.buscarTodosDubles();
    }

    @JsonView(View.Duble.class)
    @GetMapping (value="/id/{id}")
    public Duble buscarPorId(@PathVariable("id") Long id)
    {
        return produtoraService.buscarDublePorId(id);
    }

    @JsonView(View.Duble.class)
    @GetMapping (value = "/nome/{nome}")
    public Duble buscarPorNome(@PathVariable("nome")  String nome)
    {
        return produtoraService.buscarDublePorNome(nome);
    }

    @JsonView(View.Duble.class)
    @GetMapping (value = "/letra/{nome}")
    public List<Duble> buscaDublePorLetra(@PathVariable("nome")  String nome)
    {
        return produtoraService.buscarDublePorLetra(nome);
    }
}