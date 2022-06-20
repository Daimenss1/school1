package ru.hogwartS.school.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwartS.school.Model.Faculty;
import ru.hogwartS.school.Model.Student;

import java.util.Collection;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> findAllByAge(Integer ageFilter);

    Collection<Student> findAllByAgeBetween(Integer ageMin, Integer ageMax);

    Collection<Student> findStudentByFacultyId(Long facultyId);

}
