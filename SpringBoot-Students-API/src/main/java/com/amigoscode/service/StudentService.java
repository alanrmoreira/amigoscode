package com.amigoscode.service;

import com.amigoscode.model.StudentModel;
import com.amigoscode.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;


    public List<StudentModel> listStudents(){

        return repository.findAll();
    }

    public Optional<StudentModel> findStudentById(Long id){
        return repository.findById(id);
    }

    public StudentModel newStudent(StudentModel studentModel) {

       Optional<StudentModel> student = repository.findStudentByEmail(studentModel.getEmail());

       if (student.isPresent()){
           throw new IllegalStateException("User already exists");
       }
        return repository.save(studentModel);
    }

    public void deleteUser(Long id) {

        if (repository.existsById(id)){
            repository.deleteById(id);
        }else{
            throw new IllegalStateException("User not found");
        }
    }
    @Transactional
    public StudentModel updateStudent(StudentModel studentModel, Long id) {
        StudentModel student = repository.findById(id).orElseThrow(
                () -> new IllegalStateException("User not found")
        );

        if (!studentModel.getName().isEmpty() && !studentModel.getEmail().isEmpty()){
            student.setName(studentModel.getName());
            student.setEmail(studentModel.getEmail());
        }
        return student;
    }
}
