package springbootdeveloper.test_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootdeveloper.test_api.domain.Member;
import springbootdeveloper.test_api.service.TestService;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    TestService testService;

    @GetMapping("/test")
    public List<Member> getAllMembers(){
            List<Member> members = testService.getAllMembers();
            return members;
    }
}
