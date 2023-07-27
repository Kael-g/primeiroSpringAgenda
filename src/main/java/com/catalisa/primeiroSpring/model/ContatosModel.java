package com.catalisa.primeiroSpring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TB_CONTATOS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContatosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String nome;
    @Column(length = 20, nullable = false)
    private String telefone;

}
