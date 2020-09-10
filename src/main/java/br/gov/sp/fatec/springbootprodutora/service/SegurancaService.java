package br.gov.sp.fatec.springbootprodutora.service;

import br.gov.sp.fatec.springbootprodutora.entity.Filme;
import br.gov.sp.fatec.springbootprodutora.entity.Usuario;

public interface SegurancaService {
    public Usuario criaUsuario(String nome, String senha, String autorizacao);

    public Filme criaFilme(String nome, Long ano, Float duracao, String descricao, String diretor, String ator, String duble);
}