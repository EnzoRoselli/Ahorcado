package edu.utn.ahorcado.model;

import edu.utn.ahorcado.repository.interfaces.IWinnerDao;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.HashSet;
import java.util.Random;

@AllArgsConstructor
@Data
public class Match {

    @NotNull
    Integer id;
    Word palabra;
    HashSet<String> letters;
    @NotNull
    Date fecha;

    IWinnerDao winnerDao;

    static final int maxIntentos = 5;
    int intentos = 0;
    int aciertos = 0;
    boolean bandera = true;
    Random rnd = new Random();
    char c;
    String s;
    HashSet<String> letrasUsadas = new HashSet<>();

    public Match(Word palabra, IWinnerDao winnerDao){
        this.palabra = palabra;
        letters = this.palabra.wordToLetters(palabra);
        this.winnerDao = winnerDao;
    }

    public synchronized void turnJug1(){

        if(bandera){

            c = (char) (rnd.nextInt(26) + 'a');
            s=String.valueOf(c);

            System.out.println(letters);
            System.out.println(c);
            System.out.println("intentos: " + intentos);
            System.out.println("aciertos: " + aciertos);
            System.out.println(letrasUsadas);

            if (letters.contains(s) && !letrasUsadas.contains(s)){

                letrasUsadas.add(s);
                aciertos++;
            }else if(!letters.contains(s) && !letrasUsadas.contains(s)){

                letrasUsadas.add(s);
                intentos++;
            }

            bandera = false;
        }

    }

    public synchronized void turnJug2(){

        if (!bandera) {
            System.out.println("TURNO JUG2");
            if(isMaxIntentos()){

                System.out.println("JUEGO TERMINADO, LLEGO A MAXIMOS INTENTOS");

                return;
            }

            bandera = true;
        }
    }

    public boolean isGameOver(){

        if(isMaxIntentos() || isAciertos()){
            return true;
        }

        return false;
    }

    public boolean isMaxIntentos(){

        if(intentos == maxIntentos) {
            return true;
        }
        return false;
    }

    public boolean isAciertos(){
        if(aciertos == letters.size()){
            return true;
        }
        return false;
    }

    public void saveWinner(User jugador){

        long millis = System.currentTimeMillis();
        Date fecha = new Date(millis);

        Winner ganador = new Winner(jugador.getId(),palabra.getId(), fecha);

        winnerDao.save(ganador);
    }

}
