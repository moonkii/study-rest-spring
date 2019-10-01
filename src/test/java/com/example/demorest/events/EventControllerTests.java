package com.example.demorest.events;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest //스프링 부트 슬라이스 테스트 ( MockMvc 빈을 자동으로 설정 해줌 )
public class EventControllerTests {


    /*스프링 MVC 테스트 핵심 클래스
     * 웹 서버를 띄우지 않고도 스프링 MVC (DispatcherServlet)가 요청을 처리하는 과정을 확인할 수 있기 때문에 컨트롤러 테스트용으로 자주 쓰임
     * */
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    EventRepository eventRepository;


    @Test
    public void createEvent() {

        Event event = Event.builder()
                .name("Spring")
                .descrption("REST API Development wit Spring")
                .beginEnrollmentDateTime(LocalDateTime.of(2019,10,1,12,11,10))
                .closeEnrollmentDateTime(LocalDateTime.of(2019,10,5,11,20,13))
                .beginEventDateTime(LocalDateTime.of(2019,10,10,10,10,10))
                .endEventDateTime(LocalDateTime.of(2019,10,10,10,10,10))
                .basePrice(100)
                .maxPrice(200)
                .limitOffEnrollment(100)
                .location("Seoul")
                .build();

        event.setId(10);
        Mockito.when(eventRepository.save(event)).thenReturn(event);

        try {
            mockMvc.perform(post("/api/events/")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaTypes.HAL_JSON)
                        .content(objectMapper.writeValueAsBytes(event)))
                    .andDo(print())
                    .andExpect(header().exists(HttpHeaders.LOCATION))
                    .andExpect(header().string(HttpHeaders.CONTENT_TYPE,MediaTypes.HAL_JSON_VALUE))
                    .andExpect(jsonPath("id").exists())
                    .andExpect(status().isCreated());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
