package gov.iti.jets.teacherservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class Teacher {
    @Id
    String id;
    String name;
    String email;
    List<String> courses = new ArrayList<>();
}
