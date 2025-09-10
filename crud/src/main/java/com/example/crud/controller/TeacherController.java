package com.example.crud.controller;

import com.example.crud.model.Teacher;
import com.example.crud.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    // Get all teachers
    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    // Get teacher by ID
    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    // Create teacher
    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    // Update teacher
    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        teacher.setId(id);
        return teacherRepository.save(teacher);
    }

    // Delete teacher
    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        teacherRepository.deleteById(id);
        return "Teacher deleted with id " + id;
    }

    // Get teachers by subject
    @GetMapping("/subject/{subject}")
    public List<Teacher> getTeachersBySubject(@PathVariable String subject) {
        return teacherRepository.findBySubjectStudied(subject);
    }

    // Get all distinct subjects
    @GetMapping("/subjects")
    public List<String> getAllSubjects() {
        return teacherRepository.findDistinctSubjects();
    }
}
