package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MappingController {
    //스프링은 "/hello-basique"나 "/hello-basique/"를 동일하게 인식
    @RequestMapping("/hello-basique")
    public String helloBasic(){
        log.info("hello Basique");
        return "ok";
    }

    /**
     * method 특정 HTTP 메서드 요청만 허용
     * GET, HEAD, POST, PUT, PATCH, DELETE
     */
    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "ok";
    }

    /**
     * 편리한 축약 애노테이션 (코드보기)
     * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     */
    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mapping-get-v2");
        return "ok";
    }

    //요즘에 PathVariable(경로 변수) 사용이 핫하다! 정말 많이 사용됨
    /**
     * PathVariable 사용
     * 변수명이 같으면 생략 가능
     * @PathVariable("userId") String userId -> @PathVariable String userId
     * /mapping/userA
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data){
        log.info("mappingPath userId={}",data);
        return "ok";
    }

    /**
     * PathVariable 사용 다중
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long
            orderId) {
        log.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }

    //특정 파라미터 조건 매핑
    /**
     * 파라미터로 추가 매핑
     * params="mode",
     * params="!mode"
     * params="mode=debug"
     * params="mode!=debug" (! = )
     * params = {"mode=debug","data=good"}
     */
    //get 요청이면서, 파라미터에 mode=debug가 있어야 호출!
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    //특정 헤더 조건 매핑
    /**
     * 특정 헤더로 추가 매핑
     * headers="mode",
     * headers="!mode"
     * headers="mode=debug"
     * headers="mode!=debug" (! = )
     */
    //get 요청이면서, 헤더에, key가 mode, value가 debug인 것이 있으면 호출!
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    //미디어 타입 조건 매핑-HTTP 요청 Content-Type(ex: json, text, html 등등), consume
    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
    //post 요청이면서, 헤더의 content 타입이 application/json일 때 호출
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE) //consumes="application/json"
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    //미디어 타입 조건 매핑-HTTP 요청 Accept, produce
    /**
     * Accept 헤더 기반 Media Type
     * produces = "text/html"
     * produces = "!text/html"
     * produces = "text/*"
     * produces = "*\/*"
     */
    //예시로 accept가 application-json이면, 에러 (클라이언트가 json만 받아들일 수 있기 때문)
    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE) //produces=//"text/html"
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }
}
