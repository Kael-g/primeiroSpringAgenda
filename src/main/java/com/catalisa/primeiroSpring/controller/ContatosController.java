package com.catalisa.primeiroSpring.controller;

import com.catalisa.primeiroSpring.model.ContatosModel;
import com.catalisa.primeiroSpring.service.ContatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContatosController {
    @Autowired
    ContatosService contatosService;

    //Endpoints de consulta
    //Requisição GET: pega todos os contatos da agenda no banco de dados
    @GetMapping(path = "/contatos")
    public List<ContatosModel> buscaTodosContatos(){
        return contatosService.buscarTodos();
    }

    //Requisição GET: pega um contato da agenda pelo id
    @GetMapping(path = "/contatos/{id}")
    public Optional<ContatosModel> buscarContatoPorId(@PathVariable Long id){
        return contatosService.buscarPorId(id);
    }

    //Endpoint de inserção
    //Requisição POST: insere dado no BD da agenda
    @PostMapping(path = "/contatos")
    @ResponseStatus(HttpStatus.CREATED)
    public ContatosModel cadastrarNovoContato(@RequestBody ContatosModel contatosModel){
        return contatosService.cadastraContato(contatosModel);
    }

    //Endpoint de alteração
    //Requisição PUT: altera dado no BD
    @PutMapping(path = "/contatos/{id}")
    public ContatosModel alteraContato(@PathVariable Long id, @RequestBody ContatosModel contatosModel){
        return contatosService.alterarContato(id, contatosModel);
    }

    @DeleteMapping(path = "/contatos/{id}")
    public void deletarContato(@PathVariable Long id){
        contatosService.deletarContato(id);
    }


}
