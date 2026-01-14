package com.dm73994.practica.repositories.students;

import com.dm73994.practica.data.entities.StudentEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentRepositoryService implements IStudentRepositoryService{

    private final IStudentRepository studentJpaRepository;

    public StudentRepositoryService(IStudentRepository studentJpaRepository) {
        this.studentJpaRepository = studentJpaRepository;
    }

    @Override
    public StudentEntity saveStudent(StudentEntity student) {
        student.setId(null);
        return studentJpaRepository.save(student);
    }

    @Override
    public List<StudentEntity> findAllStudents() {
        return studentJpaRepository.findAll();
    }

    @Override
    public StudentEntity findStudentById(Integer id) {
        return studentJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public void deleteStudentById(Integer id) {
        StudentEntity student = findStudentById(id);
        studentJpaRepository.deleteById(student.getId());
    }

    @Override
    public StudentEntity updateStudent(Integer id, StudentEntity student) {
        StudentEntity existingStudent = findStudentById(id);
        existingStudent.setName(student.getName());
        existingStudent.setLastname(student.getLastname());
        existingStudent.setDni(student.getDni());
        existingStudent.setBirthDate(student.getBirthDate());
        return studentJpaRepository.save(existingStudent);
    }
}
