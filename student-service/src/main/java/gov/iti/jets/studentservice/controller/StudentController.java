package gov.iti.jets.studentservice.controller;

import gov.iti.jets.studentservice.dto.StudentDTO;
import gov.iti.jets.studentservice.entity.Student;
import gov.iti.jets.studentservice.mappers.StudentMapper;
import gov.iti.jets.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

                List<Student> students = studentRepository.findAll();
                List<StudentDTO> studentDTOList = new ArrayList<>();
                for(Student s:students){
                    studentDTOList.add(StudentMapper.INSTANCE.studentToStudentDTO(s));
                }
                return studentDTOList;
    }

    @GetMapping("/{id}")
    public StudentDTO getById(@PathVariable String id){
        return StudentMapper.INSTANCE.studentToStudentDTO(studentRepository.getStudentsById(id));
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