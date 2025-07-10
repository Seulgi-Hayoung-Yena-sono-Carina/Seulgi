package springbootdeveloper.test_api;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JUnitQuiz {
//    static int cnt = 1;
//    @BeforeEach
//    public void start(){
//        System.out.println(cnt+"번째 시작합니다.");
//        cnt++;
//    }
//    @Test
//    public void junitTest(){
//        String name1 = "홍길동";
//        String name2 = "홍길은";
//        String name3 = "홍길금";
//
//        //NULL이 아닌 값인지 체크
//        assertThat(name1).isNotEmpty();
//        assertThat(name2).isNotEmpty();
//        assertThat(name3).isNotEmpty();
//
//        //name1과 name2가 같은지 체크
//        assertThat(name1).isNotEqualTo(name2);
//
//        //name1과 name3가 다른지 체크
//        assertThat(name1).isNotEqualTo(name3);
//    }
//
//    @Test
//    public void junitTest2(){
//        int number1 = 15;
//        int number2 = 0;
//        int number3 = -5;
//
//        //number1이 양수인지 체크
//        assertThat(number1).isPositive();
//        //number2가 0인지 체크
//        assertThat(number2).isEqualTo(0);
//        //number3가 음수인지 체크
//        assertThat(number3).isNotPositive();
//        //number1은 number2 보다 큰지 체크
//        assertThat(number1).isGreaterThan(number2);
//        //number3은 number2보다 작은지 체크
//        assertThat(number3).isLessThan(number2);
//    }

    @BeforeEach
    public void hello(){
        System.out.println("Hello!");
    }
    @Test
    public void junitTest3(){
        System.out.println("This is first Test");
    }

    @Test
    public void junitTest4(){
        System.out.println("This is second test");
    }

    @AfterAll
    static void bye(){
        System.out.println("Bye!");
    }
}
