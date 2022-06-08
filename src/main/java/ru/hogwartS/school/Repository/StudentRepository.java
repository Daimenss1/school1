package ru.hogwartS.school.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwartS.school.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
