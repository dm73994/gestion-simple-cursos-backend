package com.dm73994.practica.services.notes;

import com.dm73994.practica.data.dtos.req.NoteReqDTO;
import com.dm73994.practica.data.dtos.res.NoteResDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService implements INoteService{
    @Override
    public void createNote(NoteReqDTO note) {

    }

    @Override
    public List<NoteResDTO> getAllNotesByStudentAndSubject(Integer studentId, Integer subjectId) {
        return null;
    }
}
