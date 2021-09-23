package com.rubypaper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;
import com.rubypaper.controller.BoardController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith; // JUnit5부턴 4에서 @RunWith가 ExtendWith로 바뀌었다
import org.junit.runner.RunWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class) // JUnit5부턴 4에서 @RunWith가 ExtendWith로 바뀌었다
@SpringBootTest(classes = BoardController.class,
				properties = { "author.name=Gurum",
							   "author.age=45",
							   "author.nation=Korea" })
public class PropertiesTest {		// 지금 현재 5점대거인 @ExtendWidth로 실행하면 테스트정상완료되는데, 4점대인 @RunWith로 실행하면 test실패가 뜸(runnable method가 없다고 ; 근데 객체생성은 또 되어짐 -> 뭐지?)
	
	@Autowired
	Environment environment; // org.springframework.core.env.Environment // 스프링프레임워크 core에서 갖고 있는 Environment 객체 : 외부프로퍼티 파일(application.properties 등)의 정보등에 접근할수있는 객체
	
	@Test
	public void testMethod() {
		System.out.println("이름: " + environment.getProperty("author.name")); 
		System.out.println("나이: " + environment.getProperty("author.age")); 
		System.out.println("국가: " + environment.getProperty("author.nation")); 
	}

}
