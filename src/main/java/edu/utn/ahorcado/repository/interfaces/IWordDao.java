package edu.utn.ahorcado.repository.interfaces;

import edu.utn.ahorcado.model.Word;

public interface IWordDao extends IGenericDao<Word>{
    public Word getRandomWord();
}
