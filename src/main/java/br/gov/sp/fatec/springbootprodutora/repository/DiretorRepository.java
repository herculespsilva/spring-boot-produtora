package br.gov.sp.fatec.springbootprodutora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springbootprodutora.entity.Diretor;

public interface DiretorRepository extends JpaRepository<Diretor, Long>{
    public Diretor findByNome(String nomeDiretor);

    @Query("select d from Diretor d inner join d.filmagensDirigidas f where f.nome =?1")
    public Diretor buscaPorFilmagem(String filmagem);

    @Query("select d from Diretor d inner join d.filmagensDirigidas f where d.nome = ?1 and f.nome =?2")
    public Diretor buscarPorNomeEFilmagem(String diretor, String filmagem);
}