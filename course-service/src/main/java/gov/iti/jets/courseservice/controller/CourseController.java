package gov.iti.jets.courseservice.controller;

import gov.iti.jets.courseservice.entity.Course;
import gov.iti.jets.courseservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private CourseRepository courseRepository ;

    @Autowired
    public CourseController(CourseRepository courseRepository){
        this.courseRepository = courseRepository ;
    }

    @GetMapping
    public List<Course> getAllStudents(){
        return  courseRepository.findAll();
    }

    @PostMapping
    public void addStudent(@RequestBody Course course){
        courseRepository.insert(course);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent( @PathVariable String id){
        courseRepository.deleteById(id);
    }

    @PutMapping
    public void updateStudent(@RequestBody Course course){
        courseRepository.save(course);
    }
}