package com.example.crud.repository;

import com.example.crud.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    // Find teachers by a specific subject
    @Query("SELECT t FROM Teacher t JOIN t.subjectStudied s WHERE s = :subject")
    List<Teacher> findBySubjectStudied(@Param("subject") String subject);

    // Get distinct subjects list
    @Query("SELECT DISTINCT s FROM Teacher t JOIN t.subjectStudied s")
    List<String> findDistinctSubjects();
}
