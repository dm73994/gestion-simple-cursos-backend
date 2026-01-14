package com.dm73994.practica.services.notes;

import com.dm73994.practica.data.dtos.req.NoteReqDTO;
import com.dm73994.practica.data.dtos.req.NotesSearchReqDTO;
import com.dm73994.practica.data.dtos.res.NoteResDTO;
import com.dm73994.practica.data.mappers.NoteMapper;
import com.dm73994.practica.repositories.notes.INoteRepositoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService implements INoteService{
    private final INoteRepositoryService noteRepository;

    public NoteService(INoteRepositoryService noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public void createNote(NoteReqDTO note) {

        noteRepository.saveNote(NoteMapper.toEntity(note));
    }

    @Override
    public List<NoteResDTO> getAllNotesByStudentAndSubject(NotesSearchReqDTO searchParams) {
        return noteRepository.findNotesByStudentAndSubject(searchParams.studentId(), searchParams.subjectId(), searchParams.page())
                .stream()
                .map(NoteMapper::toResponse)
                .toList();
    }
}
