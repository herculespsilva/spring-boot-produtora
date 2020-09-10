package br.gov.sp.fatec.springbootprodutora.service;

import br.gov.sp.fatec.springbootprodutora.entity.Usuario;

public interface SegurancaService {
    public Usuario criaUsuario(String nome, String senha, String autorizacao);
}