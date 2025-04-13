package com.jogo.jogo_velha.jogador;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jogador/")
@RequiredArgsConstructor
public class JogadorController {
    private final JogadorRepository jogadorRepository;

    @PostMapping
    public JogadorModel createJogador(@RequestBody JogadorModel jogador) {
        return jogadorRepository.save(jogador);
    }
}
