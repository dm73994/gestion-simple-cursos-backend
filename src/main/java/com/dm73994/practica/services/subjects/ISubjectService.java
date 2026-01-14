package com.dm73994.practica.services.subjects;

import com.dm73994.practica.data.dtos.req.SubjectReqDTO;
import com.dm73994.practica.data.dtos.res.SubjectResDTO;

import java.util.List;

public interface ISubjectService {
    void createSubject(SubjectReqDTO subject);
    List<SubjectResDTO> listAllSubjects();
    SubjectResDTO getSubjectById(int id);
    void deleteSubject(int id);
    void updateSubject(int id, SubjectReqDTO subject);
}
