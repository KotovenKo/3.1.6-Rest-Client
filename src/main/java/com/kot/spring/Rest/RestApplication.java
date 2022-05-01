package com.kot.spring.Rest;

import com.kot.spring.Rest.Controller.ConsumeAPIController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class RestApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(RestApplication.class, args);
		ConsumeAPIController controller = applicationContext.getBean(ConsumeAPIController.class);



		List<String> cookie = controller.getUsersList();

		System.out.println("___________________________________");

		String code1 =	controller.postUser(cookie);

		System.out.println("___________________________________");

		String code2 =	controller.putUser(cookie);

		System.out.println("___________________________________");

		String code3 =	controller.deleteUser(cookie);

		System.out.println("___________________________________");

		System.out.println(code1+code2+code3);






	}


	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}



}
