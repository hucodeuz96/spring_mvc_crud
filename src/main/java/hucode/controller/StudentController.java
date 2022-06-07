package hucode.controller;

import hucode.entity.Group;
import hucode.entity.Student;
import hucode.entity.StudentCreateDto;
import hucode.repository.GroupRepository;
import hucode.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

     private final StudentRepository studentRepository;


    @GetMapping("/read")
    public ModelAndView readStudent(ModelAndView view){
        List<StudentCreateDto> dtos = studentRepository.read();
        view.addObject("dtoList",dtos);
        view.setViewName("read");
        return view;
    }
    @GetMapping(value = "/create")
    public ModelAndView getStudent(ModelAndView view){
        List<Group> groups = studentRepository.readNameGroup();
        view.addObject("listGroup",groups);
        view.setViewName("create");
        return view;
    }


    @PostMapping(value = "/create")
    public ModelAndView saveStudent( @ModelAttribute("student") StudentCreateDto dto, ModelAndView mv){
        GroupRepository groupRepository = new GroupRepository();
        Integer groupId = groupRepository.findByName(dto.getGroups_name());
        Student student = Student.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .groups_id(groupId)
                .build();
        System.out.println(student);

        int num = studentRepository.create(student);
        if (num == 0) {
            mv.addObject("msg", "Error adding!!!");
        } else {
            mv.addObject("msg", "Student added👌");
        }
        mv.setViewName("create"); //create.jsp ni   web papkadam qidiradi
        return mv;
    }
    @GetMapping(value = "/update/{studentId}")
    public ModelAndView getOneStudent(ModelAndView mv, @PathVariable ("studentId") int id ){
        List<Student> studentList = studentRepository.findById(id);
        List<Group> groupList = studentRepository.readNameGroup();
        mv.addObject("listGroup",groupList);
        mv.addObject("listStudent",studentList);
        mv.setViewName("update");
        return mv;
    }
    @PostMapping(value = "/update")
    public ModelAndView updateStudent(ModelAndView mv,@ModelAttribute("student") StudentCreateDto dto){
        GroupRepository groupRepository = new GroupRepository();
        Integer id = groupRepository.findByName(dto.getGroups_name());
        Student student = Student.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .groups_id(id)
                .build();
        System.out.println(student);
        int num = studentRepository.update(student);
        if (num == 0) {
            mv.addObject("msg", "Error updating!!!");
        } else {
            mv.addObject("msg", "Update successfully👍 ");
        }
        mv.setViewName("update"); //create.jsp ni   web papkadam qidiradi
        return mv;
    }
    @GetMapping  ("/delete/{studentId}")
    public ModelAndView deleteStudent(ModelAndView mv,@PathVariable("studentId") int id){
        int num = studentRepository.delete(id);
        if (num == 0) {
            mv.addObject("msg", "Error deleting!!!");
        } else {
            mv.addObject("msg", "Delete successfully👌");
        }
        mv.setViewName("delete"); //create.jsp ni   web papkadam qidiradi
        return mv;

    }
}
