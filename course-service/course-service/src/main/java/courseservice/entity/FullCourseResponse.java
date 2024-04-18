package courseservice.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FullCourseResponse {
    private Long id;
    private String name;
    private double price;
    List<Student> students;

}
