package gov.iti.jets.studentservice;

import gov.iti.jets.studentservice.controller.StudentController;
import gov.iti.jets.studentservice.entity.Student;
import gov.iti.jets.studentservice.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;


@SpringBootApplication
public class StudentServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(StudentServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentController studentController,StudentRepository studentRepository ) {

        return runner -> {


//            Student student = new Student();
//            student.setName("reem");
//            student.setCourses(new ArrayList<>());
//            studentRepository.save(student);
//            System.out.println(studentController.getAllStudents());
//
//            System.out.println(studentRepository.findAll());
        };

    }
}
