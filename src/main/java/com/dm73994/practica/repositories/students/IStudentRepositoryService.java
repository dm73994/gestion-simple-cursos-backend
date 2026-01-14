package com.dm73994.practica.repositories.students;

import com.dm73994.practica.data.entities.StudentEntity;

import java.util.List;

public interface IStudentRepositoryService {
    StudentEntity saveStudent(StudentEntity student);
    List<StudentEntity> findAllStudents();
    StudentEntity findStudentById(Integer id);
    void deleteStudentById(Integer id);
    StudentEntity updateStudent(Integer id, StudentEntity student);
}
