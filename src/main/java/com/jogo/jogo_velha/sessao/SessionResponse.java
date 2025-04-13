package com.jogo.jogo_velha.sessao;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class SessionResponse {
    private UUID sala;

    public SessionResponse(UUID sala) {
        this.sala = sala;
    }
}
