package com.example.demorest.events;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;


@Builder                    //롬복으로 귀찮은 부분들 자동 생성 target/classes~/events/Event.class 에서 확인 가능
@AllArgsConstructor         //모든 Args 를 가진 생성자를 만들어주는 어노테이션
@NoArgsConstructor          //디폴트 생성자를 만들어주는 어노테이션
@Getter @Setter             //getter setter 생성
@EqualsAndHashCode(of="id") //연관 관계가 있는 변수 지정 ( stack of flow 방지 )
@Entity
public class Event {

    private Integer id;                             //이벤트 식별 번호
    private String name;                            //이벤트 명
    private String descrption;                      //이벤트 설명
    private LocalDateTime beginEnrollmentDateTime;  //이벤트 등록 시작 일시
    private LocalDateTime closeEnrollmentDateTime;  //이벤트 등록 종료 일시
    private LocalDateTime beginEventDateTime;       //이벤트 시작 일시
    private LocalDateTime endEventDateTime;         //이벤트 종료 일시
    private String location;                        //장소 (optional) 이게 없으면 온라인 모임
    private int basePrice;                          //등록 비 기본 가격 (optional)
    private int maxPrice;                           //등록 최대 가격 (optional)
    private int limitOffEnrollment;                 //이벤트 참가 제한 수
    private boolean offline;                        //온/오프라인 구분
    private boolean free;                           //무료 여부 구분
    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus;                //이벤트 상태





}
