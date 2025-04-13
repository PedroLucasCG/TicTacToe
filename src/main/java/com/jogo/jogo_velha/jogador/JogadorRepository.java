package com.jogo.jogo_velha.jogador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends JpaRepository<JogadorModel, Integer> {
}
