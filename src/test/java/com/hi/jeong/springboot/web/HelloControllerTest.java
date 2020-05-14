package com.hi.jeong.springboot.web;

import com.hi.jeong.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // 스프링 부트 테스트와 JUnit 사이에 연결자 역할
@WebMvcTest(controllers = HelloController.class) // Web에 집중할 수 있는 어노테이션
public class HelloControllerTest {

    @Autowired  // 스프링이 관리하는 Bean을 주입 받는다.
    private MockMvc mvc; // 스프링 MVC 테스트의 시작점

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))  // hello 주소로 HTTP Get 요청
                .andExpect(status().isOk()) // HTTP Header Status 검증
                .andExpect(content().string(hello)); // 본문 내용 hello 리턴이 맞는지 확인
    }
}


