package hello.springmvc.basic.request;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller

public class RequestBodyStringController {
    @PostMapping("/request-body-string-v1")
    public  void requestBodyStringV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //클라이언트가 전송한 데이터(본문)을 읽기 위한 스트림
        ServletInputStream inputStream = request.getInputStream();
        //요청 본문을 문자열 형태로 반환하여 messageBody 변수에 저장
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}",messageBody);
        response.getWriter().write("ok");
    }

    /**
    * InputStream(Reader): HTTP 요청 메시지 바디의 내용을 직접 저회하기
    * OutputStream(Writer): HTTP 응답 메시지의 바디에 직접 결과 출력
    */
    @PostMapping("/request-body-string-v2")
    public  void requestBodyStringV2(InputStream inputStream, Writer responseWriter) throws IOException {
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}",messageBody);
        responseWriter.write("ok");
    }

    //이 코드는 멋사 백엔드 세션 시간에 배운 HttpEntity<> 활용
    //HttpEntity<>의 자식들: RequestEntity, ResponseEntity (pg 32)
    //HttpMessageConverter: 스프링 MVC 내부에서 HTTP 메시지 바디를 읽어서 문자나 객체로 변환해 전달
    @PostMapping("/request-body-string-v3")
    public HttpEntity<String> requestBodyStringV3(HttpEntity<String> httpEntity) {
        String messageBody = httpEntity.getBody(); //요청 본문을 가져와, message Body에 저장
        log.info("messageBody={}",messageBody);
        return new HttpEntity<>("ok");
    }

    //HttpEntity를 상속받는 ResponseEntity<> 객체 사용 예시, 수업 시간에 활용
    @PostMapping("/request-body-string-v3-1")
    public HttpEntity<String> requestBodyStringV3_1(RequestEntity<String> httpEntity) throws IOException {
        String messageBody = httpEntity.getBody();
        log.info("messageBody={}",messageBody);
        return new ResponseEntity<>("ok", HttpStatus.CREATED); //HTTP 상태코드를 넣을 수 있음
    }

    //@RequestBody - requestBodyString-V4
    //요청: @RequestBody 응답: @ResponseBody 사용
    //@RequestBody: HTTP 메시지 바디를 직접 조회하는 기능
    @ResponseBody //@Controller을 사용해서, view가 반환되기 때문에 @ResponseBody도 써주면, @RestController 사용의 효과!
    @PostMapping("/request-body-string-v4")
    public String requestBodyStringV3(@RequestBody String messageBody) {
        log.info("messageBody={}",messageBody);
        return "ok";
    }

}
