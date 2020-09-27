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

    @Override
    public List<Filme> buscarTodosFilmes(){
        return filmeRepo.findAll();
    }

    public Filme buscarFilmeId(Long id){
        Optional<Filme> filmeOp= filmeRepo.findById(id);
        if(filmeOp.isPresent()){
            return filmeOp.get();
        }
        throw new RuntimeException("Usuario não encontrado!");
    }





}