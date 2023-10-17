package springtests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;
import springdatabasework.AppConfig;
import springdatabasework.entities.Student;
import springdatabasework.repositories.StudentRepository;

public class SprinTests {

    @Autowired
    private static StudentRepository studentRepository;

    public static void main(String[] args) {



        // Create a new student instance and populate its fields

        Student student = new Student();
        student.setStuName("Sumit");
        student.setStuBranch("IT");

        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);


        // Save the student entity
        studentRepository.save(student);
    }


}
