package ru.hogwartS.school.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwartS.school.Model.Faculty;
import ru.hogwartS.school.Service.FacultyService;

import java.util.Collection;


@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("{idRead}")
    public ResponseEntity<Faculty> getFacultyInfo(@PathVariable Long idRead) {
        Faculty facultyGet = facultyService.readFaculty(idRead);
        if (facultyGet == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facultyGet);
    }

    @PostMapping
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        Faculty facultyCreate = facultyService.createFaculty(faculty);
        if (facultyCreate == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(facultyCreate);
    }

    @PutMapping
    public ResponseEntity<Faculty> editFaculty(@RequestBody Faculty faculty) {
        Faculty facultyEdit = facultyService.updateFaculty(faculty);
        if (facultyEdit == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(facultyEdit);
    }

    @DeleteMapping("{idDelete}")
    public ResponseEntity deleteFaculty(@PathVariable Long idDelete) {
        facultyService.deleteFaculty(idDelete);
        return ResponseEntity.ok().build();
    }

    @GetMapping("color/{color}")
    public Collection<Faculty> getFacultyByColor(@PathVariable String color) {
        return facultyService.getFacultyByColor(color);
    }

    @GetMapping("colororname")
    public Collection<Faculty> getFacultyByColorOrName(@RequestParam(required = false) String color,
                                                       @RequestParam(required = false) String name) {
        return facultyService.findFacultyByColorAndName(color, name);
    }

    @GetMapping("all")
    public Collection<Faculty> allFaculty() {
        return facultyService.allFaculty();
    }

}
