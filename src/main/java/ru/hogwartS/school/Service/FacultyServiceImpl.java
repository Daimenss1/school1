package ru.hogwartS.school.Service;

import org.springframework.stereotype.Service;
import ru.hogwartS.school.Model.Faculty;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final Map<Long, Faculty> facultyMap = new HashMap<Long, Faculty>();
    private long lastId = 0;


    @Override
    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(++lastId);
        facultyMap.put(lastId, faculty);
        return faculty;
    }

    @Override
    public Faculty readFaculty(long idRead) {
        return facultyMap.get(idRead);
    }

    @Override
    public Faculty updateFaculty(Faculty faculty) {
        facultyMap.put(faculty.getId(), faculty);
        return faculty;
    }

    @Override
    public Faculty deleteFaculty(long idDelete) {
        return facultyMap.remove(idDelete);
    }

    @Override
    public Collection<Faculty> getFacultyByColor(String colorFilter) {
        final Map<Long, Faculty> facultyMapFilteredByColor = new HashMap<>();
        Long facultyId = 0L;
        for (Long i = 1L; i < 1L*(facultyMap.size())+1L; i++) {
            if (facultyMap.get(i).getColor().equals(colorFilter)) {
                facultyMapFilteredByColor.put(facultyId, facultyMap.get(i));
                facultyId++;
            }
        }
        return Collections.unmodifiableCollection(facultyMapFilteredByColor.values());
    }

    @Override
    public Collection<Faculty> allFaculty() {
        return Collections.unmodifiableCollection(facultyMap.values());
    }
}
