package instructor.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class FullSchoolResponse {
    private  Long id;
    private String name;
    List<Student>students;
    private String position;
}
