package edu.utn.ahorcado.model;

public class UserVisit extends User implements Runnable {

    public UserVisit(User jug, Match match) {
        super(jug, match);
    }

    @Override
    public void run() {

        while (!match.isGameOver()){

            match.turnJug2();
        }

        if(match.isMaxIntentos()){

            match.saveWinner(this);
        }
    }

}
