package gov.iti.jets.courseservice.controller;

import gov.iti.jets.courseservice.entity.Course;
import gov.iti.jets.courseservice.remote.TeacherDTO;
import gov.iti.jets.courseservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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


    @GetMapping("/teacher")
    public List<TeacherDTO> getTeacher(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:5050/teacher-service/teacher";
        ParameterizedTypeReference<List<TeacherDTO>> responseType = new ParameterizedTypeReference<List<TeacherDTO>>() {};

        ResponseEntity<List<TeacherDTO>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                responseType
        );

        List<TeacherDTO> teacherDTOList = responseEntity.getBody();

        return teacherDTOList;
    }
}