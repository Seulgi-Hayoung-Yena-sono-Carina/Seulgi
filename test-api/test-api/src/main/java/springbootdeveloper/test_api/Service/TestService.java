package springbootdeveloper.test_api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootdeveloper.test_api.domain.Member;
import springbootdeveloper.test_api.Repository.MemberRepository;

import java.util.List;

@Service
public class TestService {
    @Autowired
    MemberRepository memberRepository;

    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }
}
