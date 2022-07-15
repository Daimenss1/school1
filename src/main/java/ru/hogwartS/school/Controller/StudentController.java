package ru.hogwartS.school.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwartS.school.Model.Faculty;
import ru.hogwartS.school.Model.Student;
import ru.hogwartS.school.Service.StudentService;
import java.util.Collection;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{idRead}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable Long idRead) {
        Student studentGet = studentService.readStudent(idRead);
        if (studentGet == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentGet);
    }

    @PostMapping
    public ResponseEntity<Object> createStudent(@RequestBody Student student) {
        Student studentCreate = studentService.createStudent(student);
        if (studentCreate == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(studentCreate);
    }

    @PutMapping
    public ResponseEntity<Student> editStudent (@RequestBody Student student) {
        Student studentEdit = studentService.updateStudent(student);
        if (studentEdit == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(studentEdit);
    }


    @DeleteMapping("{idDelete}")
    public ResponseEntity deleteStudent(@PathVariable Long idDelete) {
        studentService.deleteStudent(idDelete);
        return ResponseEntity.ok().build();
    }

    @GetMapping("age/{age}")
    public Collection<Student> getStudentByAge(@PathVariable int age) {
        return studentService.getStudentByAge(age);
    }

    @GetMapping("agebtw")
    public Collection<Student> getStudentByAgeRange(@RequestParam int ageMin,
                                                    @RequestParam int ageMax) {
        return studentService.findByAgeBetween(ageMin, ageMax);
    }

    @GetMapping("studentsbyfaculty")
    public Collection<Student> getStudentByFaculty(@RequestParam Long facultyId) {
        return studentService.findByFacultyId(facultyId);
    }

    @GetMapping("facultyofstudent")
    public Faculty getFacultyOfStudent(@RequestParam Long studentId) {
        return studentService.findFacultyOfStudent(studentId);
    }

    @GetMapping("all")
    public Collection<Student> allStudent() {
        return studentService.allStudent();
    }

    @GetMapping("total-number")
    public ResponseEntity<Integer> getStudentsTotalNumber() {
        Integer studentTotalNumber = studentService.studentsTotalNumber();
        if (studentTotalNumber == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(studentTotalNumber);
    }

    @GetMapping("average-age")
    public ResponseEntity<Integer> getStudentsAverageAge() {
        Integer studentsAverageAge = studentService.studentsAverageAge();
        if (studentsAverageAge == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(studentsAverageAge);
    }

    @GetMapping("/filteredByName")
    public ResponseEntity<Collection<String>> getAllStudentsWithName() {
        Collection<String> stringCollection = studentService.getFilteredByName();
        if (stringCollection.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(stringCollection);
    }

    @GetMapping("last-five")
    public Collection<Student> lastFiveStudents() {
        return studentService.lastFiveStudents();
    }
    @GetMapping("parallel-thread")
    public void getNames() {
        studentService.getStudentNames();
    }
    @GetMapping("sync-thread")
    public void getNamesSync(){
        studentService.getStudentNamesSync();
    }
}