package com.dm73994.practica.data.mappers;


import com.dm73994.practica.data.dtos.req.StudentReqDTO;
import com.dm73994.practica.data.dtos.res.StudentResDTO;
import com.dm73994.practica.data.entities.StudentEntity;

public class StudentMapper {
    public static StudentEntity toEntity(StudentReqDTO request){
        return StudentEntity.builder()
                .id(request.getId())
                .dni(request.getDni())
                .name(request.getName())
                .lastname(request.getLastname())
                .birthDate(request.getBirthDate())
                .build();
    }

    public static StudentResDTO toResponse(StudentEntity entity){
        return (StudentResDTO) StudentResDTO.builder()
                .id(entity.getId())
                .dni(entity.getDni())
                .name(entity.getName())
                .lastname(entity.getLastname())
                .birthDate(entity.getBirthDate())
                .build();
    }
}
