package com.hi.jeong.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass  // BaseTimeEntity를 상속하게 되면 BaseTimeEntity의 멤버변수 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    @CreatedDate // Entity가 생성되어 저장될 때 시간이 자동 저장
    private LocalDateTime createDate;

    @LastModifiedDate // Entity의 값을 변경할 때 시간이 자동 저장
    private LocalDateTime modifiedDate;
}
