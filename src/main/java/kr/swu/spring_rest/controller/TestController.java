package kr.swu.spring_rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController 애너테이션이 붙은 클래스는 컨트롤러로 정의됩니다.
@RestController
public class TestController {

    // 어떤 주소로 접속하면 어떤 기능을 실행할지 결정할 수 있는데
    // 메서드 위에 @RequestMapping("패턴") 으로 지정할 수 있음
    // 기본적 서버 주소 : localhost:8080
    // 기본 서버 주소를 줄여서 / 로 표현합니다.
    // 따라서 / hello 패턴은, localhost:8080/hello 인 패턴입니다.
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("컨트롤러가 hello 요청을 감지했습니다.");
        // 브라우저 화면에 return 오른쪽 문자를 찍어줌
        return "Hello!!!";
    }

    // localhost:8080/apple 로 접속했을때
    // 브라우저 화면에 apple이라고 찍어주도록 추가 작업을 해 보세요.
    @RequestMapping("/apple")
    public String 사과(){
        System.out.println("사과 요청을 감지했습니다.");
        return "Apple";
    }

    // 아래 메서드를 실행하기 위해 서버의 어느 주소로 접속해야 하는지 풀 경로를 적어주세요.
    // localhost:8080/show?param=들어온내용을 하단의 String param에 전달합니다.
    @RequestMapping("/show")
    public String getParameter(String param){
        System.out.println("?param=" + param);
        return param;
    }

    // 위 메서드처럼 동작하되
    // localhost:8080/keyword?kw=들어온내용
    // 을 콘솔창에는 keyword : 들어온내용
    // 결과창에는 들어온내용을 2번 반복하는 메서드를 하단에 정의하고 테스트해주세요.
    @RequestMapping("/keyword")
    public String getKeyword(String kw, int day){
        System.out.println("keyword : " + kw);
        System.out.println(day + 100);
        return kw + day + "일";
    }


}
