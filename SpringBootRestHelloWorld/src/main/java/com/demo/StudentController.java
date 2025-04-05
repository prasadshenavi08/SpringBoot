package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/showmsg")
    public String message() {
        return "Good Morning";
    }

    @GetMapping("/student")
    public Student createStudent() {
        return new Student(12, "Yashoda", 85);
    }

    @GetMapping("/allstudents")
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String query = "SELECT * FROM student";
        
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");
             PreparedStatement pstmt = con.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Student s1 = new Student();
                s1.setRollno(rs.getInt(1));
                s1.setName(rs.getString(2));
                s1.setMarks(rs.getInt(3));
                list.add(s1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @GetMapping("/student/{roll}")
    public Student getStudentById(@PathVariable int roll) {
        Student s1 = null;
        String query = "SELECT * FROM student WHERE roll = ?";
        
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
             PreparedStatement pstmt = con.prepareStatement(query)) {
            
            pstmt.setInt(1, roll);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    s1 = new Student();
                    s1.setRollno(rs.getInt(1));
                    s1.setName(rs.getString(2));
                    s1.setMarks(rs.getInt(3));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s1;
    }
}
