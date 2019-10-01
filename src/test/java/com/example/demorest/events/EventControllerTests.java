package com.example.demorest.events;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest //스프링 부트 슬라이스 테스트 ( MockMvc 빈을 자동으로 설정 해줌 )
public class EventControllerTests {


    /*스프링 MVC 테스트 핵심 클래스
    * 웹 서버를 띄우지 않고도 스프링 MVC (DispatcherServlet)가 요청을 처리하는 과정을 확인할 수 있기 때문에 컨트롤러 테스트용으로 자주 쓰임
    * */
    @Autowired
    MockMvc mockMvc;
    

    @Test
    public void createEvent() {
        try {
            mockMvc.perform(post("/api/events/")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaTypes.HAL_JSON))
                    .andExpect(status().isCreated()
                    );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
