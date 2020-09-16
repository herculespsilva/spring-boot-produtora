package br.gov.sp.fatec.springbootprodutora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springbootprodutora.entity.Novela;

public interface NovelaRepository extends JpaRepository<Novela, Long>{

    public Novela findByNome(String nome); 

    @Query("select n from Novela n where n.descricaoCap like = %?1%")
    public List<Novela> buscarNovelaPorDescricao(String descricao);    
}