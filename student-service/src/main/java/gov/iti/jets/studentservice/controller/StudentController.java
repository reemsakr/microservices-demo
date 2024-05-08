package gov.iti.jets.studentservice.controller;

import gov.iti.jets.studentservice.dto.StudentDTO;
import gov.iti.jets.studentservice.entity.Student;
import gov.iti.jets.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentRepository studentRepository ;

    @Autowired
    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository ;
    }

    @GetMapping
    public List<StudentDTO> getAllStudents(){
        return  studentRepository.findAllStudents();
    }

    @GetMapping("/{id}")
    public StudentDTO getById(@PathVariable String id){
        return studentRepository.getStudentsById(id);
    }
    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentRepository.insert(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent( @PathVariable String id){
        studentRepository.deleteById(id);
    }

    @PutMapping
    public void updateStudent(@RequestBody Student student){
        studentRepository.save(student);
    }
}