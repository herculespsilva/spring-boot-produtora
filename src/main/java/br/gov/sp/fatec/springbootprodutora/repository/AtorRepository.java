package br.gov.sp.fatec.springbootprodutora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootprodutora.entity.Ator;

public interface AtorRepository extends JpaRepository<Ator, Long>{
    public Ator findByNome(String atorNome);
}