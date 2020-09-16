package br.gov.sp.fatec.springbootprodutora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springbootprodutora.entity.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{
    public Filme findByNome(String nome);

    @Query("select f from Filme f inner join f.diretor d where d.nome = ?1")
    public Filme buscarPorNome(String diretor);

    public Filme findByDiretorNome(String diretor);

    @Query("select f from Filme f inner join f.diretor d where d.nome = ?1 and d.cpf = ?2")
    public Filme buscarFilmePorDiretorECpf(String diretor, Long cpf);

    public Filme findByDiretorNomeAndCpf(String diretor, Long cpf);
}