package com.example.demorest.events;


import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Controller
@RequestMapping(value = "/api/events",produces = MediaTypes.HAL_JSON_VALUE)
public class EventController {


    private final EventRepository eventRepository;


    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    /* ResponseEntity 를 사용하는 이유는 응답 코드, 헤더, 본문 모두 다루기 편한 API 이기 때문 */
    @PostMapping
    public ResponseEntity createEvent(@RequestBody Event event){

        Event newEvent = this.eventRepository.save(event);

        /* Location URI 만들기
        * HATEOS 가 제공하는 linkTo() 와 methodOn() 사용 */
        URI createUri = linkTo(EventController.class).slash(newEvent.getId()).toUri();
        return ResponseEntity.created(createUri).body(event);
    }

}
