package com.jogo.jogo_velha.sessao;

import com.jogo.jogo_velha.jogo.JogoModel;
import com.jogo.jogo_velha.jogador.JogadorModel;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@EqualsAndHashCode
@Table(name = "session")
public class SessionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "jogador1_id", nullable = false)
    private JogadorModel jogador1;

    @Setter
    @ManyToOne
    @JoinColumn(name = "jogador2_id")
    private JogadorModel jogador2;

    @ManyToOne
    @JoinColumn(name = "jogo_id", nullable = false)
    private JogoModel jogo;

    public SessionModel() {}

    public SessionModel(JogadorModel jogador1, JogoModel jogo) {
        this.jogador1 = jogador1;
        this.jogo = jogo;
    }
}
