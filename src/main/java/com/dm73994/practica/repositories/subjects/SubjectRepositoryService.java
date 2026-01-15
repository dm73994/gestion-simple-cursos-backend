package com.dm73994.practica.repositories.subjects;

import com.dm73994.practica.config.exceptions.NoSuchThingExist;
import com.dm73994.practica.data.entities.SubjectEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SubjectRepositoryService implements ISubjectRepositoryService{

    private final ISubjectRepository subjectRepository;

    public SubjectRepositoryService(ISubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public SubjectEntity saveSubject(SubjectEntity subject) {
        subject.setId(null);
        return subjectRepository.save(subject);
    }

    @Override
    public SubjectEntity findSubjectById(Integer id) {
        return subjectRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchThingExist(String.format("[ERROR]: La materia con id %d no existe", id))
                );
    }

    @Override
    public List<SubjectEntity> findAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public void deleteSubjectById(Integer id) {
        if (!subjectRepository.existsById(id)) {
            throw new NoSuchThingExist(String.format("[ERROR]: La materia con id %d no existe", id));
        }
        subjectRepository.deleteById(id);
    }

    @Override
    public SubjectEntity updateSubject(Integer id, SubjectEntity subject) {
        SubjectEntity existing = findSubjectById(id);

        existing.setName(subject.getName());
        existing.setCode(subject.getCode());
        existing.setCredits(subject.getCredits());

        return subjectRepository.save(existing);
    }
}
