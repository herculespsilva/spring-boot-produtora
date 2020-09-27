package br.gov.sp.fatec.springbootprodutora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootprodutora.entity.Duble;

public interface DubleRepository extends JpaRepository<Duble, Long>{
    public Duble findByNome(String dubleNome);
}


