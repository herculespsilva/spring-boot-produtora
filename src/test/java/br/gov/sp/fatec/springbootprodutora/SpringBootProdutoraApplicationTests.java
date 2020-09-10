package br.gov.sp.fatec.springbootprodutora;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootprodutora.entity.Autorizacao;
import br.gov.sp.fatec.springbootprodutora.entity.Filme;
import br.gov.sp.fatec.springbootprodutora.entity.Usuario;
import br.gov.sp.fatec.springbootprodutora.repository.AutorizacaoRepository;
import br.gov.sp.fatec.springbootprodutora.repository.UsuarioRepository;
import br.gov.sp.fatec.springbootprodutora.service.SegurancaService;


@SpringBootTest
@Transactional
@Rollback
class SpringBootProdutoraApplicationTests {

    @Autowired
    private UsuarioRepository usuarioRepo;
    
    @Autowired
    private AutorizacaoRepository autRepo;

    @Autowired
    private SegurancaService segService;

	@Test
	void contextLoads() {
    }
    
    @Test
    void testaInsercao() {
        Usuario usuario = new Usuario();
        usuario.setNome("Lucas"); 
        usuario.setSenha("pass123");
        usuario.setAutorizacoes(new HashSet<Autorizacao>());
        Autorizacao aut = new Autorizacao();
        aut.setNome("ROLE_USUARIO");
        autRepo.save(aut);
        usuario.getAutorizacoes().add(aut);
        usuarioRepo.save(usuario);

        assertNotNull(usuario.getAutorizacoes().iterator().next().getId());
    }

    @Test
    void testaAutorizacao() {
        Usuario usuario = usuarioRepo.findById(1L).get();
        assertEquals("ROLE_ADMIN", usuario.getAutorizacoes().iterator().next().getNome());
    }
    
    @Test
    void testaUsuario() {
        Autorizacao aut = autRepo.findById(1L).get();
        assertEquals("admin", aut.getUsuarios().iterator().next().getNome());
    }
    
    @Test
    void testBuscaUsuarioNomeContains() {
        List<Usuario> usuarios = usuarioRepo.findByNomeContainsIgnoreCase("a");
        assertFalse(usuarios.isEmpty());
    }

    @Test
    void testBuscaUsuarioNome() {
        Usuario usuario = usuarioRepo.findByNome("admin");
        assertNotNull(usuario);
    }

    @Test
    void testBuscaUsuarioNomeQuery() {
        Usuario usuario = usuarioRepo.buscaUsuarioPorNome("admin");
        assertNotNull(usuario);
    }

    @Test
    void testBuscaUsuarioNomeSenha() {
        Usuario usuario = usuarioRepo.findByNomeAndSenha("admin","123");
        assertNotNull(usuario);
    }

    @Test
    void testBuscaUsuarioNomeSenhaQuery() {
        Usuario usuario = usuarioRepo.buscaUsuarioPorNomeESenha("admin","123");
        assertNotNull(usuario);
    }

    @Test
    void testBuscaUsuarioNomeAutorizacao() {
        List<Usuario> usuarios = usuarioRepo.findByAutorizacoesNome("ROLE_ADMIN");
        assertFalse(usuarios.isEmpty());
    }

    @Test
    void testBuscaUsuarioNomeAutorizacaoQuery() {
        List<Usuario> usuarios = usuarioRepo.buscaPorNomeAutorizacao("ROLE_ADMIN");
        assertFalse(usuarios.isEmpty());
    }

    @Test
    void testaServicoCriaUsuario() {
         Usuario usuario = segService.criaUsuario("mineda", "SenhaF0rte", "ROLE_USUARIO");
         assertNotNull(usuario);
    }

    // ------------------------------------------------------------------------------------------------------------------
    @Test
    void testaServicoCriaFilme() {
         Filme filme = segService.criaFilme("Tropa de Elite", 2020l, 3.3f, "Filme do Brasil", "Luke Winters", "Cairo Head", "Clark Knox");
         assertNotNull(filme);
    }
}
