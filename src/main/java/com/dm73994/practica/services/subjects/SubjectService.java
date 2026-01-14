package com.dm73994.practica.services.subjects;

import com.dm73994.practica.data.dtos.req.SubjectReqDTO;
import com.dm73994.practica.data.dtos.res.SubjectResDTO;
import com.dm73994.practica.data.entities.SubjectEntity;
import com.dm73994.practica.data.mappers.SubjectMapper;
import com.dm73994.practica.repositories.subjects.ISubjectRepositoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService implements ISubjectService {

    private final ISubjectRepositoryService subjectRepositoryService;

    public SubjectService(ISubjectRepositoryService subjectRepositoryService) {
        this.subjectRepositoryService = subjectRepositoryService;
    }

    @Override
    public void createSubject(SubjectReqDTO subject) {
        SubjectEntity entity = SubjectMapper.toEntity(subject);
        entity.setId(null);
        subjectRepositoryService.saveSubject(entity);
    }

    @Override
    public List<SubjectResDTO> listAllSubjects() {
        return subjectRepositoryService.findAllSubjects()
                .stream()
                .map(SubjectMapper::toResponse)
                .toList();
    }

    @Override
    public SubjectResDTO getSubjectById(int id) {
        SubjectEntity subject = subjectRepositoryService.findSubjectById(id);
        return SubjectMapper.toResponse(subject);
    }

    @Override
    public void deleteSubject(int id) {
        subjectRepositoryService.deleteSubjectById(id);
    }

    @Override
    public void updateSubject(int id, SubjectReqDTO subject) {
        subjectRepositoryService.updateSubject(id, SubjectMapper.toEntity(subject));
    }
}

