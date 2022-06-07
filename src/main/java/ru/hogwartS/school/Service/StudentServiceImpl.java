package ru.hogwartS.school.Service;

import org.springframework.stereotype.Service;
import ru.hogwartS.school.Model.Student;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    private final Map<Long, Student> studentMap = new HashMap<>();
    private long lastId = 0;

    @Override
    public Student createStudent(Student studentCreate) {
        studentCreate.setId(++lastId);
        studentMap.put(lastId, studentCreate);
        return studentCreate;
    }

    @Override
    public Student readStudent(long idRead) {
        return studentMap.get(idRead);
    }

    @Override
    public Student updateStudent(Student studentUpdate) {
        studentMap.put(studentUpdate.getId(), studentUpdate);
        return studentUpdate;
    }


    @Override
    public Student deleteStudent(long idDelete) {
        return studentMap.remove(idDelete);
    }

    @Override
    public Collection<Student> getStudentByAge(int ageFilter) {
        final Map<Long, Student> studentMapFilteredByAge = new HashMap<>();
        Long studentId = 0L;
        for (Long i = 1L; i < 1L*(studentMap.size())+1L; i++) {
            if (studentMap.get(i).getAge() == ageFilter) {
                studentMapFilteredByAge.put(studentId, studentMap.get(i));
                studentId++;
            }
        }
        return Collections.unmodifiableCollection(studentMapFilteredByAge.values());
    }


    @Override
    public Collection<Student> allStudent() {
        return Collections.unmodifiableCollection(studentMap.values());
    }
}
