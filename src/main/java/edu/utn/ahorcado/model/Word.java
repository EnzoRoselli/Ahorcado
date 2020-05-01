package edu.utn.ahorcado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Word {

    @NotNull
    private int Id;
    @NotNull
    private String palabra;

    public HashSet<String> wordToLetters(Word palabra){

        HashSet<String> letters = new HashSet<String>(Arrays.asList(palabra.getPalabra().split("")));

        return letters;
    }
}
