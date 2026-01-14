package com.dm73994.practica.repositories.students;

import com.dm73994.practica.data.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<StudentEntity, Integer> {
}
