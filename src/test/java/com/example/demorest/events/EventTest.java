package com.example.demorest.events;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class EventTest {

    //빌더가 있는 지 테스트
    @Test
    public void builder(){
        Event event = Event.builder()
                .name("Spring REST API")
                .descrption("REST API development with Spring")
                .build();
        assertThat(event).isNotNull();

    }


    //디폴트 생성자 확인
    @Test
    public  void javaBean(){
        //Given
        String name = "Event";
        String description = "Spring";


        //When
        Event event = new Event();
        event.setName(name);
        event.setDescrption(description);

        //Then
        assertThat(event.getName()).isEqualTo(name);
        assertThat(event.getDescrption()).isEqualTo(description);


    }



}