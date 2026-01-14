package com.dm73994.practica.controllers;

import com.dm73994.practica.data.dtos.req.StudentReqDTO;
import com.dm73994.practica.data.dtos.res.StudentResDTO;
import com.dm73994.practica.services.students.IStudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("")
    public ResponseEntity<Void> createStudent(@RequestBody StudentReqDTO student) {
        studentService.createStudent(student);
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<List<StudentResDTO>> listAllStudents() {
        return ResponseEntity.ok(studentService.listAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResDTO> getStudentById(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable Integer id, @RequestBody StudentReqDTO student) {
        studentService.updateStudent(id, student);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
}
