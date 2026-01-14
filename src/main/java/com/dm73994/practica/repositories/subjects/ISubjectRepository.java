package com.dm73994.practica.repositories.subjects;

import com.dm73994.practica.data.entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubjectRepository extends JpaRepository<SubjectEntity, Integer> {
}
