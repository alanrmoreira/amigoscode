package com.amigoscode.Controller;

import com.amigoscode.model.StudentModel;
import com.amigoscode.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/list-students")
    public List<StudentModel> getStudents(){

        return List.of(new StudentModel("Alan Moreira", "alanrmoreira@gmail.com", LocalDate.of(1984, Month.OCTOBER, 29), 37)) ;
    }

}


