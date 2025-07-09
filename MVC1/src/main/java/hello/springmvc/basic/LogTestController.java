package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j //private final Logger log= LoggerFactory.getLogger(getClass()); 생략 가능
//@Controller annotation 사용시 view가 반환
//@RestController 사용시 "string"을 반환해도, view로 인식하지 않고 문자열을 그대로 반환
@RestController
public class LogTestController {
    // private final Logger log= LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name="String";

        //System.out.println은 모든 정보가 다 출력->지양하자
        System.out.println("name = " + name); //name = String

        //Level: trace->debug->info->warn->error

        //log.info(" info log="+name); 이렇게 쓰지 말기! + 연산이 발생해 메모리 낭비!

        log.trace("trace log={}",name);
        log.debug("debug log={}",name);
        log.info("info log={}",name);
        //2025-01-23T10:40:43.076+09:00  INFO 36632 --- [springmvc] [nio-8080-exec-1] b.springmvc.basic.LogTestController      : info log=String
        log.warn("warn log={}",name);
        log.error("error log={}",name);

        return "ok";
    }
}
