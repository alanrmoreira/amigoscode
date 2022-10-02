package com.amigoscode.repository;

import com.amigoscode.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {

    Optional<StudentModel> findStudentByEmail(String email);
}
