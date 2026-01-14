package com.dm73994.practica.services.students;

import com.dm73994.practica.data.dtos.req.StudentReqDTO;
import com.dm73994.practica.data.dtos.res.StudentResDTO;

import java.util.List;

public interface IStudentService {
    void createStudent(StudentReqDTO student);
    List<StudentResDTO> listAllStudents();
    StudentResDTO getStudentById(Integer id);
    void deleteStudent(Integer id);
    void updateStudent(Integer id, StudentReqDTO student);
}
