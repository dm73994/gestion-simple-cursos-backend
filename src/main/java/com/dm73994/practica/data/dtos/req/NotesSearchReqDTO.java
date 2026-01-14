package com.dm73994.practica.data.dtos.req;

public record NotesSearchReqDTO(
    Integer studentId,
    Integer subjectId,
    Integer page
) {
}
