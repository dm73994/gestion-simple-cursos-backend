package com.dm73994.practica.data.dtos.req;


import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoteReqDTO{
    private Integer id;

    @NotNull(message = "El valor de la nota es obligatorio")
    @DecimalMin(value = "0.0", inclusive = true, message = "La nota no puede ser menor a 0")
    @DecimalMax(value = "5.0", inclusive = true, message = "La nota no puede ser mayor a 5")
    private Double value;

    @NotNull(message = "El id de la materia es obligatorio")
    @Positive(message = "El id de la materia debe ser mayor a 0")
    private Integer subjectId;

    @NotNull(message = "El id del estudiante es obligatorio")
    @Positive(message = "El id del estudiante debe ser mayor a 0")
    private Integer studentId;
}
