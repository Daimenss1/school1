package ru.hogwartS.school.Controller;

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
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student studentCreate = studentService.createStudent(student);
        if (studentCreate == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(studentCreate);
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
        Student studentDelete = studentService.deleteStudent(idDelete);
        if (studentDelete == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentDelete);
    }

    @GetMapping("age/{age}")
    public Collection<Student> getStudentByAge(@PathVariable int age) {
        return studentService.getStudentByAge(age);
    }

    @GetMapping("agebetw")
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
}


