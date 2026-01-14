package com.dm73994.practica.controllers;

import com.dm73994.practica.data.dtos.req.NoteReqDTO;
import com.dm73994.practica.data.dtos.req.NotesSearchReqDTO;
import com.dm73994.practica.data.dtos.res.NoteResDTO;
import com.dm73994.practica.services.notes.INoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private final INoteService noteService;

    public NoteController(INoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("")
    public ResponseEntity<Void> createNote(@RequestBody NoteReqDTO request){
        noteService.createNote(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<NoteResDTO>> getNotesByStudentAndSubject(
            @RequestParam Integer studentId,
            @RequestParam Integer subjectId,
            @RequestParam(defaultValue = "0") Integer page
    ){
        var searchParams = new NotesSearchReqDTO(studentId, subjectId, page);
        List<NoteResDTO> notes = noteService.getAllNotesByStudentAndSubject(searchParams);
        return ResponseEntity.ok(notes);
    }
}
