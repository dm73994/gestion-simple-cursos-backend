package com.dm73994.practica.data.dtos.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectResDTO{
    private Integer id;
    private String name;
    private Integer code;
    private Integer credits;
}
