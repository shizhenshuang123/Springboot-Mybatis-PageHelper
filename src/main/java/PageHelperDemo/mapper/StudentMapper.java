package PageHelperDemo.mapper;


import PageHelperDemo.bo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> select();
}
