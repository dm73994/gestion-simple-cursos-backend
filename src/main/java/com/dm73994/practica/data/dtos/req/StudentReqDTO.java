package com.dm73994.practica.data.dtos.req;

import com.dm73994.practica.data.models.Student;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentReqDTO{
    private Integer id;

    @NotBlank(message = "El DNI es obligatorio")
    @Pattern(regexp = "^[0-9]+$", message = "El DNI solo puede contener números")
    @Size(min = 7, max = 15, message = "El DNI debe tener entre 7 y 15 dígitos")
    private String dni;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String name;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    private String lastname;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser anterior a hoy")
    private LocalDate birthDate;
}
