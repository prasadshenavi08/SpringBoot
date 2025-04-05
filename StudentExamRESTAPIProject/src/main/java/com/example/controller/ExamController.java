package com.example.controller;

import com.example.model.Exam;
import com.example.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
public class ExamController {
    
    @Autowired
    private ExamRepository examRepository;

    // Get all exams
    @GetMapping
    public List<Exam> getAllExams() {
        List<Exam> exams = examRepository.findAll();
        System.out.println("Fetched Exams: " + exams);
        return exams;
    }

    // Add a new exam
    @PostMapping
    public Exam addExam(@RequestBody Exam exam) {
        System.out.println("Received Exam: " + exam);
        return examRepository.save(exam);
    }
}
