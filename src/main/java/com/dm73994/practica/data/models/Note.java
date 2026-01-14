package com.dm73994.practica.data.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Note {
    private int id;
    private double value;
    private LocalDateTime registerDate;
    private int studentId;
    private int subjectId;
}
