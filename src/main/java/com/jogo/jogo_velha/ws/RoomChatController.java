package com.jogo.jogo_velha.ws;

import com.jogo.jogo_velha.jogo.JogoModel;
import com.jogo.jogo_velha.jogo.JogoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import com.jogo.jogo_velha.jogo.JogoRepository;
import com.jogo.jogo_velha.sessao.SessionRepository;

@Controller
@RequiredArgsConstructor
public class RoomChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final JogoRepository jogoRepository;
    private final SessionRepository sessionRepository;

    @MessageMapping("/sala/{roomId}")
    public void sendMessage(@DestinationVariable String roomId, ReceivePlays plays) {
        int jogoId = sessionRepository.getFirstIdBySala(roomId);
        messagingTemplate.convertAndSend("/topic/" + roomId, updateJogo(plays, jogoId));
    }

    public SendPlays updateJogo(ReceivePlays receivePlays, int id) {
        JogoModel jogoModel = jogoRepository.getReferenceById(id);
        String[] tabuleiro = jogoModel.getTabuleiro().split(",");
        boolean resultPlay = TicTacToe.hasGameEnded(tabuleiro);
        if (!tabuleiro[receivePlays.getPosition()].equals(" ")) {
            return new SendPlays(tabuleiro, "JOGADA INVÁLIDA");
        }
        tabuleiro[receivePlays.getPosition()] = receivePlays.getType();
        jogoModel.setTabuleiro(String.join(",", tabuleiro));
        if (resultPlay) {

            //TODO criar status de partidas para poder marcar como "em andamento, finalizada"
            System.out.println("Jogo " + jogoModel.getId() + " has ended");
        }
        jogoRepository.save(jogoModel);
        return new SendPlays(tabuleiro, resultPlay ? "Acabou" : "Em andamento");
    }
}
