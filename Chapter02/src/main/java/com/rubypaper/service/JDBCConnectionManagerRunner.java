package com.rubypaper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;
import com.rubypaper.jdbc.util.JDBCConnectionManager;

@Service
public class JDBCConnectionManagerRunner implements ApplicationRunner {
	
	/* [책 105p]
	 * 이 예제에서 아래 JDBCConnectionManager객체 connectionManager로 주입되는 내용은
	 * com.rubypaper.jdbc.util.JDBCConnectionManager 내용 자체가 아니라
	 * com.rubypaper.jdbc.confiG.BoardAutoConfiguration이 객체생성되며 동시 @Bean처리에의해 빈으로 메모리등록되는 리턴물 JDBCConnectionManager객체였던 것인가?
	 * */
	
	@Autowired
	private JDBCConnectionManager connectionManager;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("커넥션 매니저: " + connectionManager.toString());
		
	}
	

}
