package com.jogo.jogo_velha.ws;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendPlays {
    private String[] tabuleiro = new String[9];
    private String status;
}
