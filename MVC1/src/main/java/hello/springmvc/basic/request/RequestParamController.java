package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");
    }

    /*
    @RequestParam: HTTP 요청의 파라미터(쿼리 스트링 또는 폼 데이터)를
    메서드 파라미터로 바인딩해주는 Spring MVC의 애노테이션
    */
    @ResponseBody //@Controller을 사용해서, view가 반환되기 때문에 @ResponseBody도 써주면, @RestController 사용의 효과!
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("username") String memberName, @RequestParam("age") int memberAge){
        log.info("username={},age={}",memberName,memberAge);
        return "ok";
    }

    // HTTP 파라미터 이름이 변수 이름과 같으면 다음과 같이 간략화 가능
    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String userName, @RequestParam int age){
        log.info("username={},age={}",userName,age);
        return "ok";
    }

    //이 방법은 추천하지 않는다. 너무 생략이 많기 때문!
    // String, int, Integer 등 단순 타입이라면 @RequestParam도 생략할 수 있다
    // 이외의 타입이면 @ModelAttribute(HTTP 요청 파라미터를 받아서 객체(DTO)에 자동 바인딩 해주는 애노테이션)로 인식
    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String userName, int age){
        log.info("username={},age={}",userName,age);
        return "ok";
    }

    //파라미터 필수 여부-RequestParmRequired
    /**
     * @RequestParam.required
     * /request-param-required -> username이 없으므로 예외
     *
     * 주의!
     * /request-param-required?username= -> 빈문자로 통과
     *
     * 주의!
     * /request-param-required
     * int age -> null을 int에 입력하는 것은 불가능, 따라서 Integer 변경해야 함(또는 다음에 나오는
    defaultValue 사용)
     */
    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            //default: required=true, 없으면 오류가 발생!
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age) { //int는 null이 X->Integer로 변경!
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    //기본 값 적용 - requestParamDefault
    /**
     * @RequestParam
     * - defaultValue 사용
     *
     * 참고: defaultValue는 빈 문자의 경우에도 적용
     * /request-param-default?username=
     */
    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") int age) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    //파라미터를 Map으로 조회하기 - requestParamMap
    /**
     * @RequestParam Map, MultiValueMap
     * Map(key=value)
     * MultiValueMap(key=[value1, value2, ...]) ex) (key=userIds, value=[id1, id2])
     */
    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        log.info("username={}, age={}", paramMap.get("username"),
                paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v0")
    //@ModelAttribute 애노테이션 적용 전
    public String modelAttributeV0(@RequestParam String username, @RequestParam int age){
        HelloData helloData=new HelloData();
        helloData.setUsername(username);
        helloData.setAge(age);

        //log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        //HelloData 클래스에서 @Data 이용->@toString 자동 적용
        log.info("helloData={}",helloData);

        return "ok";
    }

    //@ModelAttribute 적용 - modelAttributeV1
    /**
     * @ModelAttribute 사용
     * 참고: model.addAttribute(helloData) 코드도 함께 자동 적용됨, 뒤에 model을 설명할 때 자세히
    설명
     */
    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        //log.info("username={}, age={}", helloData.getUsername(),helloData.getAge());
        log.info("helloData={}",helloData);
        return "ok";
    }

    //@ModelAttribute 생략 - modelAttributeV2
    /**
     * @ModelAttribute 생략 가능
     * String, int 같은 단순 타입 = @RequestParam
     * argument resolver 로 지정해둔 타입 외 = @ModelAttribute
     */
    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {
        log.info("username={}, age={}", helloData.getUsername(),
                helloData.getAge());
        return "ok";
    }




}
