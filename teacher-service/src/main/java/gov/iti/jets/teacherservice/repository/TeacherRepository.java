package gov.iti.jets.teacherservice.repository;

import gov.iti.jets.teacherservice.entity.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher,String> {
}
