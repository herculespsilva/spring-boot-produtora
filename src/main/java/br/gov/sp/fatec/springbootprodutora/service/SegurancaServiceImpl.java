package br.gov.sp.fatec.springbootprodutora.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootprodutora.entity.Autorizacao;
import br.gov.sp.fatec.springbootprodutora.entity.Usuario;
import br.gov.sp.fatec.springbootprodutora.exception.RegistroNaoEncontradoException;
import br.gov.sp.fatec.springbootprodutora.repository.AutorizacaoRepository;
import br.gov.sp.fatec.springbootprodutora.repository.UsuarioRepository;

@Service("SegurancaService")  //Component
public class SegurancaServiceImpl implements SegurancaService {
    
    @Autowired
    private AutorizacaoRepository autoRepo;

    @Autowired
    private UsuarioRepository usuarioRepo;

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
        if (aut == null) {
            aut = new Autorizacao();
            aut.setNome(autorizacao);
            autoRepo.save(aut);
        }

        return usuarioRepo.findById(id)
           .map(user -> {
               user.setNome(nome);
               user.setSenha(senha);
               Usuario updated = usuarioRepo.save(user);

               return updated;
        }).orElse(null);

    }

    public void deleteUsuario(Long id) {
        usuarioRepo.deleteById(id);       
    }
}