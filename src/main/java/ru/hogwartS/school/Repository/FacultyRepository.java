package ru.hogwartS.school.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwartS.school.Model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Long> {

}
