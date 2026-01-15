package com.dm73994.practica.repositories.students;

import com.dm73994.practica.config.exceptions.NoSuchThingExist;
import com.dm73994.practica.data.entities.StudentEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
                .orElseThrow(() -> new NoSuchThingExist(String.format("[ERROR]: El estudiante con id %d no existe", id)));
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
