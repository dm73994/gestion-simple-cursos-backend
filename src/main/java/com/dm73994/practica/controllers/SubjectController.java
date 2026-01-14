package com.dm73994.practica.controllers;


import com.dm73994.practica.data.dtos.req.SubjectReqDTO;
import com.dm73994.practica.data.dtos.res.SubjectResDTO;
import com.dm73994.practica.services.subjects.ISubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    private final ISubjectService subjectService;

    public SubjectController(ISubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("")
    public ResponseEntity<Void> createSubject(@RequestBody SubjectReqDTO subject) {
        subjectService.createSubject(subject);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<SubjectResDTO>> listAllSubjects() {
        return new ResponseEntity<>(subjectService.listAllSubjects(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectResDTO> getSubjectById(@PathVariable int id) {
        return new ResponseEntity<>(subjectService.getSubjectById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable int id) {
        subjectService.deleteSubject(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSubject(@PathVariable int id, @RequestBody SubjectReqDTO subject) {
        subjectService.updateSubject(id, subject);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
