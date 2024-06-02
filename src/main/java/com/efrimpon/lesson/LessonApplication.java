package com.efrimpon.lesson;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class LessonApplication {

	public static void main(String[] args) {
		//setting profile programmatically
		var app = new SpringApplication(LessonApplication.class);
		//app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "dev"));

		//Run
		var context  = app.run(args);

//		MyFirstService myFirstService = context.getBean(MyFirstService.class);
//		System.out.println(myFirstService.tellAStory());
//		System.out.println(myFirstService.getJavaVersion());
//		System.out.println(myFirstService.getOperatingSystem());
//		System.out.println(myFirstService.readProperty());
//		System.out.println(myFirstService.getCustomPropFromAnotherFile());
//		System.out.println(myFirstService.getCustomPropFromAnotherFile2());
//		System.out.println(myFirstService.getCustomPropFromAnotherFile3());
	}



}
