package br.gov.sp.fatec.springbootprodutora;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootprodutora.entity.Ator;
import br.gov.sp.fatec.springbootprodutora.entity.Diretor;
import br.gov.sp.fatec.springbootprodutora.entity.Duble;
import br.gov.sp.fatec.springbootprodutora.entity.Filme;
import br.gov.sp.fatec.springbootprodutora.entity.Pessoa;
import br.gov.sp.fatec.springbootprodutora.repository.AtorRepository;
import br.gov.sp.fatec.springbootprodutora.repository.DiretorRepository;
import br.gov.sp.fatec.springbootprodutora.repository.DubleRepository;
import br.gov.sp.fatec.springbootprodutora.repository.FilmeRepository;

@SpringBootTest
@Transactional
@Rollback
public class FilmeRepositoryIntegrationTest {
    
    @Autowired
    private DiretorRepository diretorRepo;

    @Autowired
    private AtorRepository atorRepo;

    @Autowired
    private DubleRepository dubleRepo;

    @Autowired
    private FilmeRepository filmeRepo;

    @Test
	void contextLoads() {
    }
    
    @Test
    void testaInsercao() {
        Diretor diretor = diretorRepo.findByNome("Hop Bowman");
        Ator ator = atorRepo.findByNome("Owen Simpson");
        Duble duble = dubleRepo.findByNome("Tyler Briggs");


        Filme filme = new Filme();
        filme.setNome("O atirador");
        filme.setAno(2002l);
        filme.setDuracao(2.45f);
        filme.setDescricao("Um filme de guerra!");
        filme.setDiretor(diretor);
        filme.setPessoas(new HashSet<Pessoa>());
        filme.getPessoas().add(ator);
        filme.getPessoas().add(duble);
        filmeRepo.save(filme);

        assertNotNull(filme.getId());
    }

    @Test
    void testBuscaFilmePorNome() {
        Filme filme = filmeRepo.findByNome("Casa Sombria");
        assertNotNull(filme);
    }

    @Test
    void testBuscaFilmePorDiretorQuery() {
        Filme filme = filmeRepo.buscarPorNomeDiretor("Hop Bowman");
        assertNotNull(filme);
    }

    @Test
    void testBuscaFilmePorDiretorECpfQuery() {
        Filme filme = filmeRepo.buscarFilmePorDiretorECpf("Hop Bowman", 29949872899l);
        assertNotNull(filme);
    }
}