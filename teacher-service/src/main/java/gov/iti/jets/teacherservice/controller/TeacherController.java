package gov.iti.jets.teacherservice.controller;


import gov.iti.jets.teacherservice.dto.TeacherDTO;
import gov.iti.jets.teacherservice.mapper.TeacherMapper;
import gov.iti.jets.teacherservice.remote.Student;
import gov.iti.jets.teacherservice.entity.Teacher;
import gov.iti.jets.teacherservice.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {



   final TeacherRepository TeacherRepository;

  final  TeacherMapper teacherMapper;
 //   @Autowired
//    public TeacherController(TeacherRepository TeacherRepository, TeacherMapper teacherMapper){
//        this.TeacherRepository = TeacherRepository ;
//        this.teacherMapper = teacherMapper;
//    }

    @GetMapping
    public List<TeacherDTO> getAllTeachers(){
        List<Teacher> teachers = TeacherRepository.findAll();
        List<TeacherDTO> teacherDTOList = new ArrayList<>();
        for(Teacher teacher:teachers){

            System.out.println(teacher.getName() + " "+teacherMapper.teacherToTeacherDTO(teacher).getName());
            teacherDTOList.add(teacherMapper.teacherToTeacherDTO(teacher));

        }

        return  teacherDTOList;
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
    public List<Student> getAllStudents(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:4040/student-service/student";
        ParameterizedTypeReference<List<Student>> responseType = new ParameterizedTypeReference<List<Student>>() {};

        ResponseEntity<List<Student>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                responseType
        );

        List<Student> studentDTOList = responseEntity.getBody();

        return studentDTOList;

    }
}
