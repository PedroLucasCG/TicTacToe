package com.jogo.jogo_velha.jogo;

import com.jogo.jogo_velha.sessao.SessionModel;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@EqualsAndHashCode
@Table(name = "jogo")
public class JogoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "jogo")
    private List<SessionModel> sessoes;

    private UUID sala;

    @Setter
    private String tabuleiro;

    public JogoModel() {
        this.sala = UUID.randomUUID();
        this.tabuleiro = " , , , , , , , , ";
    }
}
