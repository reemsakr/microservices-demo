package gov.iti.jets.studentservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Student {
    @Id
    String id;
    String name;
    String email;
    List<String> courses = new ArrayList<>();
}
