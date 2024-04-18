package centerservice.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FullCenterResponse {
    private Long id;
    private String name;
    private String location;

    List<Student> students;

}
