package com.dm73994.practica.controllers;

import com.dm73994.practica.data.dtos.req.StudentReqDTO;
import com.dm73994.practica.data.dtos.res.StudentResDTO;
import com.dm73994.practica.services.students.IStudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@Tag(
        name = "Alumnos",
        description = "Operaciones relacionadas con la gestión de estudiantes"
)
public class StudentController {

    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(
            summary = "Registrar estudiante",
            description = "Crea un nuevo estudiante en el sistema"
    )
    @PostMapping("")
    public ResponseEntity<Void> createStudent(
            @Valid @RequestBody StudentReqDTO student
    ) {
        studentService.createStudent(student);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Listar estudiantes",
            description = "Obtiene la lista completa de estudiantes registrados"
    )
    @GetMapping("")
    public ResponseEntity<List<StudentResDTO>> listAllStudents() {
        return ResponseEntity.ok(studentService.listAllStudents());
    }

    @Operation(
            summary = "Consultar estudiante por ID",
            description = "Obtiene la información de un estudiante a partir de su identificador"
    )
    @GetMapping("/{id}")
    public ResponseEntity<StudentResDTO> getStudentById(
            @Parameter(
                    description = "Identificador del estudiante",
                    example = "1",
                    required = true
            )
            @PathVariable Integer id
    ) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @Operation(
            summary = "Actualizar estudiante",
            description = "Actualiza los datos de un estudiante existente"
    )
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStudent(
            @Parameter(
                    description = "Identificador del estudiante",
                    example = "1",
                    required = true
            )
            @PathVariable Integer id,
            @Valid @RequestBody StudentReqDTO student
    ) {
        studentService.updateStudent(id, student);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Eliminar estudiante",
            description = "Elimina un estudiante del sistema según su identificador"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(
            @Parameter(
                    description = "Identificador del estudiante",
                    example = "1",
                    required = true
            )
            @PathVariable Integer id
    ) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
}