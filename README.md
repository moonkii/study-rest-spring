# Event REST API

## 프로젝트 참조
인프런 스프링 기반 REST API 개발 (백기선) 강의

## 프로젝트 설명
이벤트 등록, 조회 및 수정 API
  
  
### GET /api/events

> 이벤트 목록 조회 REST API (로그인 안 한 상태)
* 응답에 보여줘야 할 데이터
    + 이벤트 목록
    + 링크 

        - self
        - profile: 이벤트 목록 조회 API 문서문서로 링크
        - get-an-event: 이벤트 하나 조회하는 API 링크
        - next: 다음 페이지 (optional)
        - prev: 이전 페이지 (optional)
    
* 문서 : 스프링 REST Docs
  
  <br>
> 이벤트 목록 조회 REST API (로그인 한 상태) - Bearer 헤더에 유효한 AccessToken이 들어있는 경우!

* 응답에 보여줘야 할 데이터
    + 이벤트 목록
    + 링크 
    
        - self
        - profile: 이벤트 목록 조회 API 문서문서로 링크
        - get-an-event: 이벤트 하나 조회하는 API 링크
        - create-new-event: 이벤트를 이벤트를 생성할 생성할 수
있는있는 API 링크링크
        - next: 다음 페이지 (optional)
        - prev: 이전 페이지 (optional)
        
  
  
### POST /api/events
*  이벤트 생성
  
  
### GET /api/events/{id}
*  이벤트 하나 조회
  
  
### PUT /api/events/{id}
*  이벤트 수정