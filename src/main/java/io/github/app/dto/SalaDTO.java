package io.github.app.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class SalaDTO {

    @NotNull @NotEmpty
    private String administrador;
    @NotNull
    private Integer numeroParticipantes;
    @NotNull @NotEmpty
    private String metodologia;


}
