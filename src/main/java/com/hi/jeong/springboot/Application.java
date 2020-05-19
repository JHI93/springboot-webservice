package com.hi.jeong.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication // 이 위치 부터 설정을 읽어 간다.
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args); // 내장 WAS을 실행
    }
}
