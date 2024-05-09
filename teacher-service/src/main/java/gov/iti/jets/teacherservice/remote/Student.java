package gov.iti.jets.teacherservice.remote;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Student implements Serializable {
    String id;
    String name;
    String email;
    List<String> courses = new ArrayList<>();
}
