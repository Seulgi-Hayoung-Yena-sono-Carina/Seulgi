package springbootdeveloper.test_api;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class JUnitCycleTest {
    @BeforeAll
    static void beforeAll(){
        System.out.println("@BeforeAll");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("@BeforeEach");
    }

    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }

    @Test
    public void test3(){
        System.out.println("test3");
    }

    @AfterAll                       //전체 테스트를 마치고 종료하기 전에 1회 실행하므로 매서드는 static으로 선언
    static void afterAll(){
        System.out.println("@AfterAll");
    }

    @AfterEach                      //테스트 케이스를 종료하기 전마다 실행
    public void afterEach(){
        System.out.println("@AfterEach");
    }
}
