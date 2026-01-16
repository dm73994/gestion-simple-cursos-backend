package com.dm73994.practica.data.dtos.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoteResDTO{
    private Integer id;
    private Double value;
    private Integer subjectId;
    private Integer studentId;
    private LocalDateTime registerDate;
}
