package com.dm73994.practica.controllers;

import com.dm73994.practica.data.dtos.req.NoteReqDTO;
import com.dm73994.practica.data.dtos.req.NotesSearchReqDTO;
import com.dm73994.practica.data.dtos.res.NoteResDTO;
import com.dm73994.practica.services.notes.INoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@Tag(
        name = "Notas",
        description = "Operaciones relacionadas con la gestión de notas de estudiantes"
)
public class NoteController {
    private final INoteService noteService;

    public NoteController(INoteService noteService) {
        this.noteService = noteService;
    }

    @Operation(
            summary = "Registrar una nota",
            description = "Crea una nueva nota asociada a un estudiante y una materia existente"
    )
    @PostMapping("")
    public ResponseEntity<Void> createNote(
            @Valid @RequestBody NoteReqDTO request
    ) {
        noteService.createNote(request);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Consultar notas por estudiante y materia",
            description = "Obtiene la lista de notas de un estudiante para una materia específica, con paginación básica"
    )
    @GetMapping("/search")
    public ResponseEntity<List<NoteResDTO>> getNotesByStudentAndSubject(

            @Parameter(
                    description = "Identificador del estudiante",
                    example = "1",
                    required = true
            )
            @RequestParam Integer studentId,

            @Parameter(
                    description = "Identificador de la materia",
                    example = "2",
                    required = true
            )
            @RequestParam Integer subjectId,

            @Parameter(
                    description = "Número de página (comienza en 0)",
                    example = "0"
            )
            @RequestParam(defaultValue = "0") Integer page
    ) {
        var searchParams = new NotesSearchReqDTO(studentId, subjectId, page);
        List<NoteResDTO> notes = noteService.getAllNotesByStudentAndSubject(searchParams);
        return ResponseEntity.ok(notes);
    }
}