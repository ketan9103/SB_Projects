package com.app.ketan.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GetTestRunner implements CommandLineRunner {

	public void run(String... args) throws Exception {
		// 1. Create URL
		//String url = "http://localhost:9091/v1/api/book/showA";
		//String url = "http://localhost:9091/v1/api/book/showB";
		//String url = "http://localhost:9091/v1/api/book/showC";
		String url = "http://localhost:9091/v1/api/book/showD";

		// 2. Create Request Headers
		HttpHeaders headers= new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		// 3. Create Request Body
		String body = "{\"bid\" : 101,\"bname\" : \"ABC\", \"bauth\":\"AJ\", \"bcost\":500.0}";

		// 2+3
		HttpEntity<String> requestEntity = new HttpEntity<>(body,headers);

		// 4. Create RestTemplate object
		RestTemplate templet = new RestTemplate();
		
		// 5. Make HTTP call and Get Response back
//		ResponseEntity<String> response = templet.getForEntity(url, String.class);  // URL, ResponseFormat.class
//		ResponseEntity<String> response = templet.getForEntity(url, String.class,101,"ABC");  
//		ResponseEntity<String> response = templet.postForEntity(url, requestEntity, String.class); 
//		ResponseEntity<String> response = templet.exchange(url,HttpMethod.GET,null,String.class,101,"ABC"); //For showB
		ResponseEntity<String> response = templet.exchange(url,HttpMethod.POST,requestEntity ,String.class); //For showD
		
		// 6. print details
		System.out.println(response.getBody());
		System.out.println(response.getHeaders());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusCode().value());

	}

}
