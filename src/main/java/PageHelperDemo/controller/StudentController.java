package PageHelperDemo.controller;

import PageHelperDemo.bo.Student;
import PageHelperDemo.mapper.StudentMapper;
import PageHelperDemo.service.StudentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author szs
 * @date 2019/10/2 18:14
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public PageInfo<Student> select(int pageNum, int pageSize) {
        return studentService.select(pageNum, pageSize);
    }
}
