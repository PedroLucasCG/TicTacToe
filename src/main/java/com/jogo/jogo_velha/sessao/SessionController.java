package com.jogo.jogo_velha.sessao;

import com.jogo.jogo_velha.jogador.JogadorModel;
import com.jogo.jogo_velha.jogador.JogadorRepository;
import com.jogo.jogo_velha.jogo.JogoModel;
import com.jogo.jogo_velha.jogo.JogoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("session/")
@RequiredArgsConstructor
public class SessionController {
    private final SessionRepository sessionRepository;
    private final JogadorRepository jogadorRepository;
    private final JogoRepository jogoRepository;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    //TODO criar lógica para que o jogador não possa entrar em outra partida quando ele já está em uma
    public SessionResponse createSession(@RequestBody SessionRequest sessionRequest) {
        Optional<JogadorModel> jogadorOpt = jogadorRepository.findById(sessionRequest.getJogadorId());
        if (jogadorOpt.isEmpty()) {
            return null;
        }

        JogadorModel jogador = jogadorOpt.get();
        Optional<SessionModel> session = sessionRepository.findFirstByJogador2IsNull();
        UUID sala;
        if (session.isPresent()) {
            SessionModel sessionModel = session.get();
            sessionModel.setJogador2(jogador);
            sessionRepository.save(sessionModel);
            sala = sessionRepository.getSalaBySessionId(sessionModel.getId());
        } else {
            JogoModel jogoModel = new JogoModel();
            jogoRepository.saveAndFlush(jogoModel);
            SessionModel sessionModel = new SessionModel(jogador, jogoModel);
            sessionRepository.save(sessionModel);
            sala = jogoModel.getSala();
        }

        return new SessionResponse(sala);
    }
}
