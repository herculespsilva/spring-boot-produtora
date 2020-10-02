package br.gov.sp.fatec.springbootprodutora.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootprodutora.entity.Ator;
import br.gov.sp.fatec.springbootprodutora.entity.Autorizacao;
import br.gov.sp.fatec.springbootprodutora.entity.Diretor;
import br.gov.sp.fatec.springbootprodutora.entity.Duble;
import br.gov.sp.fatec.springbootprodutora.entity.Filme;
import br.gov.sp.fatec.springbootprodutora.entity.Pessoa;
import br.gov.sp.fatec.springbootprodutora.entity.Usuario;
import br.gov.sp.fatec.springbootprodutora.exception.RegistroNaoEncontradoException;
import br.gov.sp.fatec.springbootprodutora.repository.AtorRepository;
import br.gov.sp.fatec.springbootprodutora.repository.AutorizacaoRepository;
import br.gov.sp.fatec.springbootprodutora.repository.DiretorRepository;
import br.gov.sp.fatec.springbootprodutora.repository.DubleRepository;
import br.gov.sp.fatec.springbootprodutora.repository.FilmeRepository;
import br.gov.sp.fatec.springbootprodutora.repository.UsuarioRepository;

@Service("SegurancaService")  //Component
public class SegurancaServiceImpl implements SegurancaService {
    
    @Autowired
    private AutorizacaoRepository autoRepo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private FilmeRepository filmeRepo;

    @Autowired
    private DiretorRepository diretorRepo;

    @Autowired
    private AtorRepository atorRepo;

    @Autowired
    private DubleRepository dubleRepo;

    @Override
    public List<Usuario>buscarTodosUsuarios()
    {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id)
    {
        Optional<Usuario> usuarioOp= usuarioRepo.findById(id);
        if(usuarioOp.isPresent())
        {
            return usuarioOp.get();
        }
         throw new RegistroNaoEncontradoException("usuario nao encontrado!");
    }

    @Override
    public Usuario buscarUsuarioPorNome(String nome)
    {
        Usuario usuario = usuarioRepo.findByNome(nome);
        if(usuario!=null)
        {
            return usuario;
        }
        throw new RegistroNaoEncontradoException("usuario nao encontrado!");
    }

    @Transactional
    public Usuario criaUsuario(String nome, String senha, String autorizacao) {
        Autorizacao aut = autoRepo.findByNome(autorizacao);
        if(aut == null) {
            aut = new Autorizacao();
            aut.setNome(autorizacao);
            autoRepo.save(aut);
        }
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSenha(senha);
        usuario.setAutorizacoes(new HashSet<Autorizacao>());
        usuario.getAutorizacoes().add(aut);
        usuarioRepo.save(usuario);

        return usuario;
    }

    @Transactional
    public Usuario updateUsuario(Long id, String nome, String senha, String autorizacao) {

        Autorizacao aut = autoRepo.findByNome(autorizacao);
        if(aut == null) {
            aut = new Autorizacao();
            aut.setNome(autorizacao);
            autoRepo.save(aut);
        }

        return usuarioRepo.findById(id)
           .map(user -> {
               user.setNome(nome);
               user.setSenha(senha);
               user.setAutorizacoes(new HashSet<Autorizacao>());
               Usuario updated = usuarioRepo.save(user);

               return updated;
        }).orElse(null);
    }

    public Optional<Usuario> deleteUsuario(Long id) {
        usuarioRepo.deleteById(id);
        if(usuarioRepo.findById(id)!=null){
            return usuarioRepo.findById(id);
        }else{
            return usuarioRepo.findById(id);
        }
    }

    //Filme ----------------------------------------------------------------------------------------------------
    @Override
    public List<Filme> buscarTodosFilmes(){
        return filmeRepo.findAll();
    }

    @Override
    public Filme buscarFilmePorId(Long id)
    {
        Optional<Filme> filmeOp= filmeRepo.findById(id);
        if(filmeOp.isPresent())
        {
            return filmeOp.get();
        }
         throw new RegistroNaoEncontradoException("filme nao encontrado!");
    }

    @Override
    public Filme buscarFilmePorNome(String nome)
    {
        Filme filme = filmeRepo.findByNome(nome);
        if(filme!=null)
        {
            return filme;
        }
        throw new RegistroNaoEncontradoException("filme nao encontrado!");
    }

    @Transactional
    public Filme criaFilme(String nome, Long ano, Float duracao, String descricao, String nomeDiretor, String atorNome, String dubleNome) {
            
            Diretor diretor = diretorRepo.findByNome(nomeDiretor);
            Ator ator = atorRepo.findByNome(atorNome);
            Duble duble = dubleRepo.findByNome(dubleNome);

            Filme filme = new Filme();
            filme.setNome(nome);
            filme.setAno(ano);
            filme.setDuracao(duracao);
            filme.setDescricao(descricao);
            filme.setDiretor(diretor);
            filme.setPessoas(new HashSet<Pessoa>());
            filme.getPessoas().add(ator);
            filme.getPessoas().add(duble);
            
            filmeRepo.save(filme);

            return filme;
    }



    //Diretor---------------------------------------------------------------------------------------------

    @Override
    public List<Diretor> buscarTodosDiretores(){
        return diretorRepo.findAll();
    }

    @Override
    public Diretor buscarDiretorPorId(Long id)
    {
        Optional<Diretor> diretorOp= diretorRepo.findById(id);
        if(diretorOp.isPresent())
        {
            return diretorOp.get();
        }
         throw new RegistroNaoEncontradoException("diretor nao encontrado!");
    }

    @Override
    public Diretor buscarDiretorPorNome(String nome)
    {
        Diretor diretor = diretorRepo.findByNome(nome);
        if(diretor!=null)
        {
            return diretor;
        }
        throw new RegistroNaoEncontradoException("diretor nao encontrado!");
    }

    
    @Override
    public List<Diretor> buscarDiretorPorLetra(String nome){
         List<Diretor> diretor = diretorRepo.findByNomeContainsIgnoreCase(nome);
        if(diretor!=null)
        {
            return diretor;
        }
        throw new RegistroNaoEncontradoException("diretor nao encontrado!");
    }

    //Ator ---------------------------------------------------------------------------------------------------

    @Override
    public List<Ator> buscarTodosAtores(){
        return atorRepo.findAll();
    }

    @Override
    public Ator buscarAtorPorId(Long id)
    {
        Optional<Ator> atorOp= atorRepo.findById(id);
        if(atorOp.isPresent())
        {
            return atorOp.get();
        }
         throw new RegistroNaoEncontradoException("ator nao encontrado!");
    }

    @Override
    public Ator buscarAtorPorNome(String nome)
    {
        Ator ator = atorRepo.findByNome(nome);
        if(ator!=null)
        {
            return ator;
        }
        throw new RegistroNaoEncontradoException("ator nao encontrado!");
    }

    
    @Override
    public List<Ator> buscarAtorPorLetra(String nome){
         List<Ator> ator = atorRepo.findByNomeContainsIgnoreCase(nome);
        if(ator!=null)
        {
            return ator;
        }
        throw new RegistroNaoEncontradoException("ator nao encontrado!");
    }

}