package edu.utn.ahorcado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.beans.Transient;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @NotNull
    Integer id;

    @NotNull
    String username;

    Match match;

    public User(@NotNull Integer id, @NotNull String username) {
        this.id = id;
        this.username = username;
    }

    public User(User jug, Match match) {
        this.id = jug.getId();
        this.username = jug.getUsername();
        this.match = match;
    }
}
