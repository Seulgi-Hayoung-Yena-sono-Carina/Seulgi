package springbootdeveloper.test_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootdeveloper.test_api.domain.Member;
import springbootdeveloper.test_api.service.TestService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/test")
    public List<Member> getAllMembers(){
            List<Member> members = testService.getAllMembers();
            return members;
    }
}
