package ua.mk.berkut.demodbspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.mk.berkut.demodbspring.entities.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByName(String name);
}