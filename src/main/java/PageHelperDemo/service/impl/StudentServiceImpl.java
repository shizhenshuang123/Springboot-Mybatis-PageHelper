package PageHelperDemo.service.impl;

import PageHelperDemo.bo.Student;
import PageHelperDemo.mapper.StudentMapper;
import PageHelperDemo.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author szs
 * @date 2019/10/2 18:20
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public PageInfo<Student> select(int pageNum, int pageSize) {
        //设置分页参数，默认查询总数count
        PageHelper.startPage(pageNum, pageSize);
        //紧跟着的第一个select方法会被分页（分页插件会自动检测当前的数据库链接，自动选择合适的分页方式）
        return new PageInfo<>(studentMapper.select());
    }
}
