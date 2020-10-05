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
import br.gov.sp.fatec.springbootprodutora.entity.Novela;
import br.gov.sp.fatec.springbootprodutora.entity.Pessoa;
import br.gov.sp.fatec.springbootprodutora.repository.AtorRepository;
import br.gov.sp.fatec.springbootprodutora.repository.DiretorRepository;
import br.gov.sp.fatec.springbootprodutora.repository.DubleRepository;
import br.gov.sp.fatec.springbootprodutora.repository.NovelaRepository;

@SpringBootTest
@Transactional
@Rollback
public class NovelaRepositoryIntegrationTests {

    @Autowired
    private NovelaRepository novelaRepo;

    @Autowired
    private DiretorRepository diretorRepo;

    @Autowired
    private AtorRepository atorRepo;

    @Autowired
    private DubleRepository dubleRepo;

    @Test
    void testaInsercaoNovela() {
        Diretor diretor = diretorRepo.findByNome("Luke Winters");
        Ator ator = atorRepo.findByNome("Cairo Head");
        Duble duble = dubleRepo.findByNome("Clark Knox");

        Novela novela = new Novela();
        novela.setNome("A carminha");
        novela.setAno(2002l);
        novela.setDuracao(2.45f);
        novela.setDiretor(diretor);
        novela.setCapitulo(30l);
        novela.setDescricaoCap("Uma empregada rica");
        novela.setPessoas(new HashSet<Pessoa>());
        novela.getPessoas().add(ator);
        novela.getPessoas().add(duble);
        novelaRepo.save(novela);

        assertNotNull(novela.getId());
    }

    @Test
    void testBuscaNovelaPorAnoEQuantidadeCapitulo() {
        Novela novela = novelaRepo.findByAnoAndCapitulo(1998l, 11l);
        assertNotNull(novela);
    }  
}