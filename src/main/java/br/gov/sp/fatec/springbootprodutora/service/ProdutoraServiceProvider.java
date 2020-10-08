package br.gov.sp.fatec.springbootprodutora.service;

import java.util.List;

import br.gov.sp.fatec.springbootprodutora.entity.Ator;
import br.gov.sp.fatec.springbootprodutora.entity.Diretor;
import br.gov.sp.fatec.springbootprodutora.entity.Duble;
import br.gov.sp.fatec.springbootprodutora.entity.Filme;
import br.gov.sp.fatec.springbootprodutora.entity.Novela;

public interface ProdutoraServiceProvider {

    //Filme

    public List<Filme> buscarTodosFilmes();

    public Filme buscarFilmePorId(Long id);

    public Filme buscarFilmePorNome(String nome);

    public Filme criaFilme(String nome, Long ano, Float duracao, String descricao, String diretor, String ator, String duble);

    //Novela

    public List<Novela> buscarTodasNovelas();

    public Novela buscarNovelaPorId(Long id);

    public Novela buscarNovelaPorNome(String nome);

    //Diretor

    public List<Diretor> buscarTodosDiretores(); 

    public Diretor buscarDiretorPorId(Long id);

    public Diretor buscarDiretorPorNome(String nome);

    public List<Diretor> buscarDiretorPorLetra(String nome);

    //Ator

    public List<Ator> buscarTodosAtores(); 

    public Ator buscarAtorPorId(Long id);

    public Ator buscarAtorPorNome(String nome);

    public List<Ator> buscarAtorPorLetra(String nome);

    //Duble
    public Duble criaDuble(String nome, Long cpf, String especialidade);

    public List<Duble> buscarTodosDubles(); 

    public Duble buscarDublePorId(Long id);

    public Duble buscarDublePorNome(String nome);

    public List<Duble> buscarDublePorLetra(String nome);
}