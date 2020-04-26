package com.example.jms.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;



@Configuration
@EnableJms
public class AppConfig {
	
	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter conv = new MappingJackson2MessageConverter();
		conv.setTargetType(MessageType.TEXT);
		conv.setTypeIdPropertyName("_type");
		return conv;
		
	}
	
	@Bean
	public ActiveMQConnectionFactory receiver() {
		ActiveMQConnectionFactory acf = new ActiveMQConnectionFactory();
		return acf;
	}
	
	@Bean
	public DefaultJmsListenerContainerFactory jmsListener() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(receiver());
		return factory;
	}


}
