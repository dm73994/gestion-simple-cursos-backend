package com.dm73994.practica.data.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private int id;
    private String name;
    private String lastname;
    private LocalDateTime birthDate;
}
