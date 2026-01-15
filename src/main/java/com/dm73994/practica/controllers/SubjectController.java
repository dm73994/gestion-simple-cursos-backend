package com.dm73994.practica.controllers;


import com.dm73994.practica.data.dtos.req.SubjectReqDTO;
import com.dm73994.practica.data.dtos.res.SubjectResDTO;
import com.dm73994.practica.services.subjects.ISubjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
@Tag(
        name = "Materias",
        description = "Operaciones relacionadas con la gestión de materias o asignaturas"
)
public class SubjectController {

    private final ISubjectService subjectService;

    public SubjectController(ISubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Operation(
            summary = "Registrar materia",
            description = "Crea una nueva materia en el sistema"
    )
    @PostMapping("")
    public ResponseEntity<Void> createSubject(@Valid @RequestBody SubjectReqDTO subject) {
        subjectService.createSubject(subject);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(
            summary = "Listar materias",
            description = "Obtiene la lista de todas las materias registradas"
    )
    @GetMapping("")
    public ResponseEntity<List<SubjectResDTO>> listAllSubjects() {
        return new ResponseEntity<>(subjectService.listAllSubjects(), HttpStatus.OK);
    }

    @Operation(
            summary = "Consultar materia por ID",
            description = "Obtiene la información de una materia a partir de su identificador"
    )
    @GetMapping("/{id}")
    public ResponseEntity<SubjectResDTO> getSubjectById(
            @Parameter(
                    description = "Identificador de la materia",
                    example = "1",
                    required = true
            )
            @PathVariable int id
    ) {
        return new ResponseEntity<>(subjectService.getSubjectById(id), HttpStatus.OK);
    }

    @Operation(
            summary = "Eliminar materia",
            description = "Elimina una materia existente según su identificador"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(
            @Parameter(
                    description = "Identificador de la materia",
                    example = "1",
                    required = true
            )
            @PathVariable int id
    ) {
        subjectService.deleteSubject(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(
            summary = "Actualizar materia",
            description = "Actualiza los datos de una materia existente"
    )
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSubject(
            @Parameter(
                    description = "Identificador de la materia",
                    example = "1",
                    required = true
            )
            @PathVariable int id,
            @Valid @RequestBody SubjectReqDTO subject
    ) {
        subjectService.updateSubject(id, subject);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}