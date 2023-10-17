package springdatabasework.repositories;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdatabasework.entities.Student;

@Repository
public interface StudentRepository  extends JpaRepository<Student,Integer> {
}
