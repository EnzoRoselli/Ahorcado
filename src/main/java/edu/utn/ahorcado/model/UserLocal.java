package edu.utn.ahorcado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

public class UserLocal extends User implements Runnable{

    public UserLocal(User jug, Match match) {
        super(jug, match);
    }

    @Override
    public void run() {

        while (!match.isGameOver()){

            match.turnJug1();
        }

        if(match.isAciertos()) {
            match.saveWinner(this);
        }

    }



}
