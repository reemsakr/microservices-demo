package gov.iti.jets.studentservice.mappers;

import gov.iti.jets.studentservice.dto.StudentDTO;
import gov.iti.jets.studentservice.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDTO studentToStudentDTO(Student student);

    Student studentDTOToStudent(StudentDTO studentDTO);


}
