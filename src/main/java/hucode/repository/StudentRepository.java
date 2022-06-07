package hucode.repository;

import hucode.entity.Group;
import hucode.entity.Student;
import hucode.entity.StudentCreateDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
@Controller
public class StudentRepository implements Repository<Student,Integer> {

    public static  JdbcTemplate jdbcTemplate;
    public StudentRepository(DriverManagerDataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int create(Student student) {
        return jdbcTemplate.update("insert into student (name,email, groups_id) values (?,?,?)",student.getName(),student.getEmail(),student.getGroups_id());
    }


    @Override
    public int update(Student student) {
        return jdbcTemplate.update("update student set name=?,email=?,groups_id=? where id=?",student.getName(),student.getEmail(),student.getGroups_id(),student.getId());
    }

    @Override
    public int delete(Integer id) {
      return  jdbcTemplate.update("delete from student where id=?", id);
    }

    @Override
    public List<Student> findById(Integer id) {
        return jdbcTemplate.query("select * from student where id=?",BeanPropertyRowMapper.newInstance(Student.class),id);
    }
    public  List<Group> readNameGroup(){
          return jdbcTemplate.query("select * from groups", BeanPropertyRowMapper.newInstance(Group.class));
    }
    @Override
    public List<StudentCreateDto> read() {
        List<StudentCreateDto> dtos = jdbcTemplate.query("select s.id,s.name,s.email,g.groups_name from student s inner join groups g on g.id = s.groups_id",
                BeanPropertyRowMapper.newInstance(StudentCreateDto.class));
        return dtos;
    }
}
