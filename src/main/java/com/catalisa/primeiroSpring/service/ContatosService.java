package com.catalisa.primeiroSpring.service;

import com.catalisa.primeiroSpring.model.ContatosModel;
import com.catalisa.primeiroSpring.repository.ContatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatosService {
    @Autowired
    ContatosRepository contatosRepository;

    public List<ContatosModel> buscarTodos(){
        return contatosRepository.findAll();
    }

    public Optional<ContatosModel> buscarPorId(Long id){
        return contatosRepository.findById(id);
    }

    public ContatosModel cadastraContato(ContatosModel contatosModel) {

//        contatosModel.getId();
//        contatosModel.getNome();
//        contatosModel.getTelefone();

        return contatosRepository.save(contatosModel);
    }

    public ContatosModel alterarContato(Long id, ContatosModel contatosModel) {
        ContatosModel contato = buscarPorId(id).get();

        if (contatosModel.getNome() != null){
            contato.setNome(contatosModel.getNome());
        }

        if (contatosModel.getTelefone() != null){
            contato.setTelefone(contatosModel.getTelefone());
        }

        return contatosRepository.save(contato);

    }

    public void deletarContato(Long id) {
        contatosRepository.deleteById(id);
    }
}
