package courseservice.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    private String name;
    private Integer age;
    private String address;
}
