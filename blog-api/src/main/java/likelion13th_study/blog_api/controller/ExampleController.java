package likelion13th_study.blog_api.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ExampleController {

    @GetMapping("/thymeleaf/example")
    public String thymeleafExample(Model model){
        Person examplePerson = new Person();
        examplePerson.setId(1L);
        examplePerson.setName("김지오");
        examplePerson.setAge(26);
        examplePerson.setHobbies(List.of("운동","독서"));

        model.addAttribute("person",examplePerson);
        model.addAttribute("today", LocalDate.now());

        return "example";
    }

    @Setter
    @Getter
    class Person{
        private Long id;
        private String name;
        private int age;
        private List<String> hobbies;
    }
}
