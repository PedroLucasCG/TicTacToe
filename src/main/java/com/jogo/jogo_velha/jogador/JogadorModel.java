package com.jogo.jogo_velha.jogador;

import com.jogo.jogo_velha.sessao.SessionModel;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
@EqualsAndHashCode
@Table(name = "jogador")
public class JogadorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "jogador1")
    private List<SessionModel> sessoesComoJogador1;

    @OneToMany(mappedBy = "jogador2")
    private List<SessionModel> sessoesComoJogador2;

    public JogadorModel() {}
}
