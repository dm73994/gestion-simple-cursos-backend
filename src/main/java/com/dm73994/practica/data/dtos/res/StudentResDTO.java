package com.dm73994.practica.data.dtos.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResDTO {
    private Integer id;
    private String dni;
    private String name;
    private String lastname;
    private LocalDate birthDate;
}
