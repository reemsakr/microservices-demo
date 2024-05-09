package gov.iti.jets.teacherservice.remote;

import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;
@FeignClient("STUDENT-SERVICE")
public interface ClientFeign {

    List<Student> getData();
}
