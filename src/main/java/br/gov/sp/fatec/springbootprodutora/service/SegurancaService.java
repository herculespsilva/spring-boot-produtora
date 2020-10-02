package br.gov.sp.fatec.springbootprodutora.service;

import java.util.List;

import br.gov.sp.fatec.springbootprodutora.entity.Diretor;
import br.gov.sp.fatec.springbootprodutora.entity.Filme;
import br.gov.sp.fatec.springbootprodutora.entity.Usuario;

public interface SegurancaService {
    //Usuario
    public List<Usuario>buscarTodosUsuarios();

    public Usuario buscarUsuarioPorId(Long id);

    public Usuario buscarUsuarioPorNome(String nome);

    public Usuario criaUsuario(String nome, String senha, String autorizacao);

    public Object deleteUsuario(Long id);

    public Usuario updateUsuario(Long id, String nome, String senha, String autorizacao);
    
    //Filme
    public List<Filme> buscarTodosFilmes();

    public Filme buscarFilmePorId(Long id);

    public Filme buscarFilmePorNome(String nome);

    public Filme criaFilme(String nome, Long ano, Float duracao, String descricao, String diretor, String ator, String duble);


    //Diretor

    public List<Diretor> buscarTodosDiretores(); 

    public Diretor buscarDiretorPorId(Long id);

    public Diretor buscarDiretorPorNome(String nome);



    
}