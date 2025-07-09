package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    // 방법 1: ModelAndView 사용
    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello"); // 뷰 이름
        mav.addObject("data", "hello!"); //key, data
        return mav;
    }

    // 방법 2: 문자열 반환 + Model 사용 (@ResponseBody 사용하면 안 됨)
    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello!");
        return "response/hello"; // View 이름 반환 (ViewResolver가 처리)
    }

    // 방법 3 (비추천): void 반환 + 요청 경로 = View 이름이면 자동 매핑됨
    // 주의: 암묵적이고 에러 추적이 어려워 실제 개발에서는 사용 자제!
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello!");
    }
}

