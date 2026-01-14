package com.dm73994.practica.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "notas")
@Entity
public class NoteEntity {
    @Id
    private Integer id;
    @Column(nullable = false)
    private Double value;

    @Column(name = "resgisterdate", nullable = false, updatable = false)
    private LocalDateTime registerDate;

    @ManyToOne(
        fetch = FetchType.LAZY,
        cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinColumn(
        name = "studentid",
        nullable = false,
        foreignKey = @ForeignKey(name = "FK_NOTES_STUDENTS")
    )
    private StudentEntity student;

    @ManyToOne (
        fetch = FetchType.LAZY,
        cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinColumn(
        name = "subjectid",
        nullable = false,
        foreignKey = @ForeignKey(name = "FK_NOTES_SUBJECTS")
    )
    private SubjectEntity subject;
}
