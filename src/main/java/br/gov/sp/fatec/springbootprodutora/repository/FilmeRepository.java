package br.gov.sp.fatec.springbootprodutora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootprodutora.entity.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{
    public Filme findByNome(String nome);
}