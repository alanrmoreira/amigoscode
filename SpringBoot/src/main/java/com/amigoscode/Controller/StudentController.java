package com.amigoscode.Controller;

import com.amigoscode.model.StudentModel;
import com.amigoscode.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/list-students")
    public List<StudentModel> getStudents(){

        return studentService.listStudents() ;
    }

    @GetMapping("/list-student-by-id/{id}")
    public Optional<StudentModel> getStudentById(@PathVariable("id") Long id){

        return studentService.findStudentById(id);
    }

    @PostMapping("/add-student")
    public StudentModel addNewStudent(@RequestBody StudentModel studentModel){

        return studentService.newStudent(studentModel);
    }
    @PutMapping("/update-student/{id}")
    public StudentModel updateStudent(@RequestBody StudentModel studentModel, @PathVariable("id") Long id){

        return studentService.updateStudent(studentModel, id);
    }
    @DeleteMapping("/delete-user/{id}")
    public void removeUser(@PathVariable("id") Long id){
        studentService.deleteUser(id);
    }
}


