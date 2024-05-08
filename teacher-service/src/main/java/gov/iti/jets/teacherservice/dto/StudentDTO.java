package gov.iti.jets.teacherservice.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class StudentDTO implements Serializable {
    String id;
    String name;
    String email;
    List<String> courses = new ArrayList<>();
}
