package gov.iti.jets.teacherservice.Service;

import gov.iti.jets.teacherservice.dto.TeacherDTO;
import gov.iti.jets.teacherservice.repository.TeacherRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
public class TeacherService {
    private TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

}
