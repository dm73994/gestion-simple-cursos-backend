package com.dm73994.practica.repositories.notes;

import com.dm73994.practica.data.entities.NoteEntity;
import com.dm73994.practica.data.entities.StudentEntity;
import com.dm73994.practica.data.entities.SubjectEntity;
import jakarta.persistence.EntityManager;
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
    private final EntityManager entityManager;

    public NoteRespositoryService(INoteRepository noteRepository, EntityManager entityManager) {
        this.noteRepository = noteRepository;
        this.entityManager = entityManager;
    }

    @Override
    public NoteEntity saveNote(NoteEntity noteEntity) {
        noteEntity.setId(null);
        noteEntity.setRegisterDate(LocalDateTime.now());

        noteEntity.setStudent(
                entityManager.getReference(StudentEntity.class, noteEntity.getStudent().getId())
        );
        noteEntity.setSubject(
                entityManager.getReference(SubjectEntity.class, noteEntity.getSubject().getId())
        );

        return noteRepository.save(noteEntity);
    }

    @Override
    public List<NoteEntity> findNotesByStudentAndSubject(Integer studentId, Integer subjectId, Integer page) {
        Sort sort = Sort.by(Sort.Direction.DESC, "registerDate");
        Pageable pageable = PageRequest.of(page, 15, sort);
        Page<NoteEntity> notesPage = noteRepository.findAllByStudentIdAndSubjectId(studentId, subjectId, pageable);
        return notesPage.getContent();
    }

}
