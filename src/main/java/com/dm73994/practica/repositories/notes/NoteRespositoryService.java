package com.dm73994.practica.repositories.notes;

import com.dm73994.practica.data.entities.NoteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteRespositoryService implements INoteRepositoryService{
    private final INoteRepository noteRepository;

    public NoteRespositoryService(INoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public NoteEntity saveNote(NoteEntity noteEntity) {
        noteEntity.setId(null);
        noteEntity.setRegisterDate(LocalDateTime.now());
        return noteRepository.save(noteEntity);
    }

    @Override
    public List<NoteEntity> findNotesByStudentAndSubject(Integer studentId, Integer subjectId, Integer page) {
        Sort sort = Sort.by(Sort.Direction.DESC, "resgisterdate");
        Pageable pageable = PageRequest.of(page, 15, sort);
        Page<NoteEntity> notesPage = noteRepository.findAllByStudentIdAndSubjectId(studentId, subjectId, pageable);
        return notesPage.getContent();
    }

}
