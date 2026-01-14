package com.dm73994.practica.services.students;

import com.dm73994.practica.data.dtos.req.StudentReqDTO;
import com.dm73994.practica.data.dtos.res.StudentResDTO;
import com.dm73994.practica.data.entities.StudentEntity;
import com.dm73994.practica.data.mappers.StudentMapper;
import com.dm73994.practica.repositories.students.IStudentRepositoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    private final IStudentRepositoryService studentRepository;

    public StudentService(IStudentRepositoryService studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public void createStudent(StudentReqDTO student) {
        StudentEntity entity = StudentMapper.toEntity(student);
        studentRepository.saveStudent(entity);
    }

    @Override
    public List<StudentResDTO> listAllStudents() {
        return studentRepository.findAllStudents()
                .stream()
                .map(StudentMapper::toResponse)
                .toList();
    }

    @Override
    public StudentResDTO getStudentById(Integer id) {
        StudentEntity entity = studentRepository.findStudentById(id);
        return StudentMapper.toResponse(entity);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteStudentById(id);
    }

    @Override
    public void updateStudent(Integer id, StudentReqDTO student) {
        StudentEntity entity = StudentMapper.toEntity(student);
        studentRepository.updateStudent(id, entity);
    }
}
