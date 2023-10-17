package springdatabasework.service;

import springdatabasework.entities.Student;

import java.util.Optional;

public interface StudentService {
    Optional<Student> getData(int stuId);
}