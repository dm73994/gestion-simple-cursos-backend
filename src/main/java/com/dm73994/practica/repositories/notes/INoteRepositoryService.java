package com.dm73994.practica.repositories.notes;

import com.dm73994.practica.data.entities.NoteEntity;

import java.util.List;

public interface INoteRepositoryService {
    NoteEntity saveNote(NoteEntity noteEntity);
    List<NoteEntity> findNotesByStudentAndSubject(Integer studentId, Integer subjectId, Integer page);
}
