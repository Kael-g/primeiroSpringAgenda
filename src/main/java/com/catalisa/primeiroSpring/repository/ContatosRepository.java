package com.catalisa.primeiroSpring.repository;

import com.catalisa.primeiroSpring.model.ContatosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatosRepository extends JpaRepository<ContatosModel, Long> { //JpaRepository <classe, tipo do ID>

}
