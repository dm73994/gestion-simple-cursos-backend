package com.dm73994.practica.repositories.subjects;

import com.dm73994.practica.data.entities.SubjectEntity;

import java.util.List;

public interface ISubjectRepositoryService {
    SubjectEntity saveSubject(SubjectEntity subject);
    SubjectEntity findSubjectById(Integer id);
    List<SubjectEntity> findAllSubjects();
    void deleteSubjectById(Integer id);
    SubjectEntity updateSubject(Integer id, SubjectEntity subject);
}
