package gov.iti.jets.teacherservice.controller;


import gov.iti.jets.teacherservice.dto.StudentDTO;
import gov.iti.jets.teacherservice.entity.Teacher;
import gov.iti.jets.teacherservice.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    TeacherRepository TeacherRepository;

    @Autowired
    public TeacherController(TeacherRepository TeacherRepository){
        this.TeacherRepository = TeacherRepository ;
    }

    @GetMapping
    public List<Teacher> getAllTeachers(){
        return  TeacherRepository.findAll();
    }

    @PostMapping
    public void addTeacher(@RequestBody Teacher teacher){
        TeacherRepository.insert(teacher);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher( @PathVariable String id){
        TeacherRepository.deleteById(id);
    }

    @PutMapping
    public void updateTeacher(@RequestBody Teacher student){
        TeacherRepository.save(student);
    }


    @GetMapping("/{students}")
    public List<StudentDTO> getAllStudents(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:4040/student-service/student";
        ParameterizedTypeReference<List<StudentDTO>> responseType = new ParameterizedTypeReference<List<StudentDTO>>() {};

        ResponseEntity<List<StudentDTO>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                responseType
        );

        List<StudentDTO> studentDTOList = responseEntity.getBody();

        return studentDTOList;

    }
}
