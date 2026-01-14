package com.dm73994.practica.services.notes;

import com.dm73994.practica.data.dtos.req.NoteReqDTO;
import com.dm73994.practica.data.dtos.req.NotesSearchReqDTO;
import com.dm73994.practica.data.dtos.res.NoteResDTO;

import java.util.List;

public interface INoteService {
    void createNote(NoteReqDTO note);
    List<NoteResDTO> getAllNotesByStudentAndSubject(NotesSearchReqDTO searchParams);
}
