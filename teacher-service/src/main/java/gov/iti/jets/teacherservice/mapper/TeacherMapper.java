package gov.iti.jets.teacherservice.mapper;

import gov.iti.jets.teacherservice.dto.TeacherDTO;
import gov.iti.jets.teacherservice.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    TeacherDTO teacherToTeacherDTO(Teacher teacher);

    Teacher teacherDTOToTeacher(TeacherDTO teacherDTO);
}
