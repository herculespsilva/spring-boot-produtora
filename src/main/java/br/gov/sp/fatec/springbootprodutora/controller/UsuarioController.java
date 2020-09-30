package br.gov.sp.fatec.springbootprodutora.controller;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springbootprodutora.entity.Usuario;
import br.gov.sp.fatec.springbootprodutora.service.SegurancaService;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin //permite acessar de qualquer servidor


public class UsuarioController {
    
    @Autowired
    private SegurancaService segurancaService;

    @JsonView(View.UsuarioResumo.class)
    @PostMapping
    public Usuario cadastraNovoUsuario(@RequestBody Usuario usuario){
        return segurancaService.criaUsuario(usuario.getNome(), usuario.getSenha(), "ROLE_USUARIO");
    }

    /*@DeleteMapping
    public void deleteUsuario(@RequestBody Long id){
        segurancaService.deleteUsuario(id);
    }*/

     @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable Long id) {


        if ((segurancaService.deleteUsuario(id)!=null)) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }


}