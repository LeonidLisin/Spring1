package com.geekbrains.geekspring.services;

import com.geekbrains.geekspring.entities.Course;
import com.geekbrains.geekspring.entities.Student;
import com.geekbrains.geekspring.repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentsService {
    private StudentsRepository studentsRepository;

    @Autowired
    public void setStudentsRepository(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public StudentsService() {
    }

    public List<Student> getAllStudentsList() {
        return (List<Student>)studentsRepository.findAll();
    }

    public void addStudent(Student s) {
        studentsRepository.save(s);
    }

    public void removeById(Long id) {
        studentsRepository.deleteById(id);
    }

    public List<Course> getCoursesByStudentId(Long id) {
        return studentsRepository.findOneById(id).getCourses();
    }
}
