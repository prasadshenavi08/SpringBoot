package com.example.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "exam")
public class Exam {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String examName;
	private LocalDate examDate;
	private LocalTime examTime;
	private String examDay;
	private int examDuration; // in minutes
	private int totalMarks;

	@ManyToMany(mappedBy = "exams")
	private List<Student> students;

	public Exam() {
	}

	public Exam(Long id, String examName, LocalDate examDate, LocalTime examTime, String examDay, int examDuration,
			int totalMarks) {
		this.id = id;
		this.examName = examName;
		this.examDate = examDate;
		this.examTime = examTime;
		this.examDay = examDay;
		this.examDuration = examDuration;
		this.totalMarks = totalMarks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public LocalDate getExamDate() {
		return examDate;
	}

	public void setExamDate(LocalDate examDate) {
		this.examDate = examDate;
	}

	public LocalTime getExamTime() {
		return examTime;
	}

	public void setExamTime(LocalTime examTime) {
		this.examTime = examTime;
	}

	public String getExamDay() {
		return examDay;
	}

	public void setExamDay(String examDay) {
		this.examDay = examDay;
	}

	public int getExamDuration() {
		return examDuration;
	}

	public void setExamDuration(int examDuration) {
		this.examDuration = examDuration;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
