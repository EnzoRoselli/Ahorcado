package edu.utn.ahorcado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Winner {

    @NotNull
    Integer id;
    @NotNull
    Integer JugId;
    @NotNull
    Integer palabraId;
    @NotNull
    Date fecha;

    public Winner(@NotNull Integer jugId, @NotNull Integer palabraId, @NotNull Date fecha) {
        JugId = jugId;
        this.palabraId = palabraId;
        this.fecha = fecha;
    }
}
