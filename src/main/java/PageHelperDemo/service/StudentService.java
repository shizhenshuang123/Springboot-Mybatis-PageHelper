package PageHelperDemo.service;

import PageHelperDemo.bo.Student;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author szs
 * @date 2019/10/2 18:19
 */
public interface StudentService {
    /**
     * 查询
     * @param pageNum 页码
     * @param pageSize 页容量
     * @return
     */
    PageInfo<Student> select(int pageNum, int pageSize);
}
