package gov.iti.jets.teacherservice.controller;


import gov.iti.jets.teacherservice.entity.Teacher;
import gov.iti.jets.teacherservice.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Teacher> getAllStudents(){
        return  TeacherRepository.findAll();
    }

    @PostMapping
    public void addStudent(@RequestBody Teacher teacher){
        TeacherRepository.insert(teacher);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent( @PathVariable String id){
        TeacherRepository.deleteById(id);
    }

    @PutMapping
    public void updateStudent(@RequestBody Teacher student){
        TeacherRepository.save(student);
    }


}
