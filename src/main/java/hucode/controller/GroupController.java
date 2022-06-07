package hucode.controller;

import hucode.entity.Group;
import hucode.entity.Student;
import hucode.entity.StudentCreateDto;
import hucode.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupRepository groupRepository;
    @GetMapping("/groupRead")
    public ModelAndView readStudent(ModelAndView view){
        List<Group> groupList = groupRepository.readGroup();
        view.addObject("groupList",groupList);
        view.setViewName("groupRead");
        return view;
    }

    @GetMapping(value = "/groupCreate")
    public ModelAndView getStudent(ModelAndView view){
        view.setViewName("groupCreate");
        return view;
    }

    @PostMapping(value = "/groupCreate")
    public ModelAndView saveStudent(@ModelAttribute("group") Group group, ModelAndView mv){
        Integer num = groupRepository.create(group);
        if (num == 0) {
            mv.addObject("msg", "Error adding!!!");
        } else {
            mv.addObject("msg", "Group added👌");
        }
        mv.setViewName("groupCreate"); //create.jsp ni   web papkadam qidiradi
        return mv;
    }


    @GetMapping(value = "/groupUpdate/{groupId}")
    public ModelAndView getOneStudent(ModelAndView mv, @PathVariable("groupId") int id ){
        List<Group> groupList = groupRepository.findById(id);
        mv.addObject("listGroup",groupList);
        mv.setViewName("groupUpdate");
        return mv;
    }
    @PostMapping(value = "/groupUpdate")
    public ModelAndView updateStudent(ModelAndView mv,@ModelAttribute("group") Group group){
        int num = groupRepository.update(group);
        if (num == 0) {
            mv.addObject("msg", "Error updating!!!");
        } else {
            mv.addObject("msg", "Update successfully👍 ");
        }
        mv.setViewName("groupUpdate"); //create.jsp ni   web papkadam qidiradi
        return mv;
    }
    @GetMapping  ("/groupDelete/{groupId}")
    public ModelAndView deleteStudent(ModelAndView mv,@PathVariable("groupId") int id){
        int num = groupRepository.delete(id);
        if (num == 0) {
            mv.addObject("msg", "Error deleting!!!");
        } else {
            mv.addObject("msg", "Delete successfully👌");
        }
        mv.setViewName("groupDelete"); //create.jsp ni   web papkadam qidiradi
        return mv;

    }



}
