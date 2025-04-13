package com.jogo.jogo_velha.ws;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceivePlays {
    private String type;
    private  int position;
}
