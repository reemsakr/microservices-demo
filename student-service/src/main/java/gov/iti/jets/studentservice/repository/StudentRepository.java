package gov.iti.jets.studentservice.repository;

import gov.iti.jets.studentservice.dto.StudentDTO;
import gov.iti.jets.studentservice.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {
    Student getStudentsById(String id);




}
