package br.gov.sp.fatec.springbootprodutora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootprodutora.entity.Diretor;

public interface DiretorRepository extends JpaRepository<Diretor, Long>{
    
}