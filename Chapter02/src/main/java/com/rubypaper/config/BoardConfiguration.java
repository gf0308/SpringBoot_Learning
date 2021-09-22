package com.rubypaper.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.rubypaper.jdbc.config.JDBCConnectionManagerProperties;
import com.rubypaper.jdbc.util.JDBCConnectionManager;

@Configuration
@EnableConfigurationProperties(JDBCConnectionManagerProperties.class) // 내부에 @Import(EnableConfigurationPropertiesRegistrar.class) 가 있음
	/* @EnableConfigurationProperties(가져올_프로퍼티객체클래스_A)가 A를 현 클래스 안으로 import해오고(어노테이션 해부해보면 안에 import를 처리함) 
	 * 그렇게 여기로 가져와진 클래스 A가 (현클래스@Configuration설정에 의해) 현클래스가 bean화 될 때 같이 객체생성이 이뤄져 메모리에 등록되고,
	 * 그렇게 올라간 A란 타입의 객체가 @Autowired로 여기 멤버필드에(JDBCConnectionManagerProperties) 주입되어지는 것이다
	 * */
public class BoardConfiguration {
	
	@Autowired
	private JDBCConnectionManagerProperties properties;
	
	@Bean
	public JDBCConnectionManager getJDBCConnectionManager() {
		JDBCConnectionManager connectionManager = new JDBCConnectionManager();
		connectionManager.setDriverClass(properties.getDriverClass());
		connectionManager.setUrl(properties.getUrl());
		connectionManager.setUsername(properties.getUsername());
		connectionManager.setPassword(properties.getPassword());
		return connectionManager;
	}

}
