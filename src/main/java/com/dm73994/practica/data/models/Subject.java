package com.dm73994.practica.data.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subject {
    private int id;
    private String name;
    private int code;
    private int credits;
}
