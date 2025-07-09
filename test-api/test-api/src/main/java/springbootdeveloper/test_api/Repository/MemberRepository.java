package springbootdeveloper.test_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootdeveloper.test_api.domain.Member;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
