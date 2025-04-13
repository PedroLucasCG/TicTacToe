package com.jogo.jogo_velha.jogo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JogoRequest {
    private String[] tabuleiro = new String[9];
    private int id;

    public JogoRequest(int id, String[] tabuleiro) {
        this.id = id;
        this.tabuleiro = tabuleiro;
    }
}
