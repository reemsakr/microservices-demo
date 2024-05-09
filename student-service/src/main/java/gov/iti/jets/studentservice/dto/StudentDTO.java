package gov.iti.jets.studentservice.dto;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO implements Serializable {
    String id;
    String name;
    String email;
    List<String> courses = new ArrayList<>();
}
