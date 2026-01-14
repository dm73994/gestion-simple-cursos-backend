package com.dm73994.practica.data.mappers;

import com.dm73994.practica.data.dtos.req.NoteReqDTO;
import com.dm73994.practica.data.dtos.res.NoteResDTO;
import com.dm73994.practica.data.entities.NoteEntity;
import com.dm73994.practica.data.entities.StudentEntity;
import com.dm73994.practica.data.entities.SubjectEntity;

public class NoteMapper {
    public static NoteEntity toEntity(NoteReqDTO request){
        return NoteEntity.builder()
                .id(request.getId())
                .student(StudentEntity
                        .builder()
                        .id(request.getStudentId())
                        .build()
                )
                .subject(SubjectEntity
                        .builder()
                        .id(request.getSubjectId())
                        .build()
                )
                .value(request.getValue())
                .build();
    }

    public static NoteResDTO toResponse(NoteEntity entity){
        return (NoteResDTO) NoteResDTO.builder()
                .id(entity.getId())
                .studentId(entity.getStudent().getId())
                .subjectId(entity.getSubject().getId())
                .value(entity.getValue())
                .build();
    }
}
