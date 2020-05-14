package com.hi.jeong.springboot.web;

import com.hi.jeong.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController  // 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 준다.
public class HelloController {

    @GetMapping("/hello") // HTTP Method인 Get의 요청을 받는 API를 만든다.
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    // RequestParam : 외부에서 API로 넘긴 파라밍터를 가져오는 어노테이션
    // cf) "name"으로 넘긴 파라미터를 String name에 저장.
    public HelloResponseDto helloResponseDto(@RequestParam("name") String name,
                                             @RequestParam("amount") int amount){
        return new HelloResponseDto(name,amount);
    }
}


