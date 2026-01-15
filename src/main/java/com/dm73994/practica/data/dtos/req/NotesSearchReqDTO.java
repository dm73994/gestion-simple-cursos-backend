package com.dm73994.practica.data.dtos.req;

import jakarta.validation.constraints.*;

public record NotesSearchReqDTO(

        @NotNull(message = "El id del estudiante es obligatorio")
        @Positive(message = "El id del estudiante debe ser mayor a 0")
        Integer studentId,

        @NotNull(message = "El id de la materia es obligatorio")
        @Positive(message = "El id de la materia debe ser mayor a 0")
        Integer subjectId,

        @NotNull(message = "El número de página es obligatorio")
        @Min(value = 0, message = "La página no puede ser negativa")
        Integer page

) {
}
