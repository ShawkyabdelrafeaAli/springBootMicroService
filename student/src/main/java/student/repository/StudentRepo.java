package student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import student.entity.Student;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

  List<Student> findAllByTeacherId(Long teacherId);
  List<Student> findAllByCourseId(Long courseId);

  List<Student> findAllByCenterId(Long centerId);
}
