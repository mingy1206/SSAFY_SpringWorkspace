package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/*
@SpringBootApplication가 붙은 클래스를 메인 클래스, 부트스트랩 클래스, 시작 클래스 라고 부른다. 주로 1개 있음. 서버 실행용


@SpringBootConfiguration
이 클래스가 xml 문서를 대신해서 생성할 객체 정보를 포함하고 있는 설정 클래스라는 것을 표시.
@SpringBootTest 같은 테스트를 실행할 때 테스트 코드가 애플리케이션의 메인 설정 파일(본사)이 어디인지 쉽게 찾을 수 있도록 기준점이 되어주는 특별한 의미

@EnableAutoConfiguration
boot의 자동 설정 기능을 활성화 시킴. 필요할 객체들을 미리 만들어 놓음.
pom.xml이나 build.gradle에 추가한 라이브러리(의존성)를 보고, 필요한 설정들을 알아서 구성

@ComponentScan
현재 패키지(com)부터 시작해서 하위 패키지를 스캔한 뒤 필요한 어노테이션 작업 수행함 @Component 어노테이션이 붙은 모든 클래스
찾아낸 클래스들을 전부 객체(빈)로 생성해서 스프링 IoC 컨테이너(Bean 관리통)에 등록
즉, 스프링이 관리할 빈(Bean)을 찾아 IoC 컨테이너에 등록
 */
@SpringBootApplication
public class SpringBootTestApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootTestApplication.class, args);
//        String[] names = ctx.getBeanDefinitionNames();
//
//        for(String name : names) {
//            System.out.println(name);
//        }

	}
    /*
        @Bean
        public Americano getAme(){

        }
     */


}
