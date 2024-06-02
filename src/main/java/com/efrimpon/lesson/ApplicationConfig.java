package com.efrimpon.lesson;

import com.efrimpon.lesson.practices.Say;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
//@Profile("dev")
public class ApplicationConfig {
	@Primary
	@Bean
	public FirstClass myThirdClass(){
		return new FirstClass("Third Bean");
	}
    @Bean()
    @Qualifier("bean1")
	//Make this Bean available only for dev env
	public FirstClass myFirstClass(){
		return new FirstClass("First Bean");
	}

    @Bean()
    @Qualifier("bean2")
	public FirstClass mySecondClass(){
		return new FirstClass("Second Bean");
	}

	@Bean
	@Primary
	public Say greet(){
		return new Say("Afternoon");
	}
	@Bean()
	@Qualifier("gree")
	public Say greetTwo(){
		return new Say("Evening");
	}


}
