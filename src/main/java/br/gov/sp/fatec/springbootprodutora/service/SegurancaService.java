package br.gov.sp.fatec.springbootprodutora.service;

import java.util.List;

import br.gov.sp.fatec.springbootprodutora.entity.Filme;
import br.gov.sp.fatec.springbootprodutora.entity.Usuario;

public interface SegurancaService {
    public Usuario criaUsuario(String nome, String senha, String autorizacao);

    public Filme criaFilme(String nome, Long ano, Float duracao, String descricao, String diretor, String ator, String duble);

    public List<Filme> buscarTodosFilmes();

    public Filme buscarFilmeId(Long id);

    public Object deleteUsuario(Long id);

    public Usuario updateUsuario(Long id, String nome, String senha, String autorizacao);
}