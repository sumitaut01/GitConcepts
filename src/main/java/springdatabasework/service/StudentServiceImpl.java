package springdatabasework.service;

import org.springframework.beans.factory.annotation.Autowired;
import springdatabasework.entities.Student;
import springdatabasework.repositories.StudentRepository;

import java.util.Optional;

public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public Optional<Student> getData(int stuId) {
     return   studentRepository.findById(stuId);
    }
}
