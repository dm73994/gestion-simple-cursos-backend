package com.dm73994.practica.repositories.notes;

import com.dm73994.practica.data.entities.NoteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INoteRepository extends JpaRepository<NoteEntity, Integer> {
    Page<NoteEntity> findAllByStudentIdAndSubjectId(Integer studentId, Integer subjectId, Pageable pageable);
}
