package com.jogo.jogo_velha.sessao;

import com.jogo.jogo_velha.jogo.JogoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SessionRepository extends JpaRepository<SessionModel, Integer> {
    Optional<SessionModel> findFirstByJogador2IsNull();
    @Query("SELECT s.jogo.sala FROM SessionModel s WHERE s.id = :id")
    UUID getSalaBySessionId(@Param("id") Integer id);

    @Query("SELECT s.jogo.id FROM SessionModel s WHERE s.id = :roomId")
    int getFirstIdBySala(@Param("roomId") String roomId);
}
