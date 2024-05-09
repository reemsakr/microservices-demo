package gov.iti.jets.studentservice.mappers;

import gov.iti.jets.studentservice.dto.StudentDTO;
import gov.iti.jets.studentservice.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);


    StudentDTO studentToStudentDTO(Student student);


    Student studentDTOToStudent(StudentDTO studentDTO);

}
