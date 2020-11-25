package edu.webapp.webapp.Controller;

import edu.webapp.webapp.DTO.SentenceDTO;
import edu.webapp.webapp.DTO.SentimentDTO;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "*")
@RestController
public class SentimentController {

	private Logger logger = LoggerFactory.getLogger(SentimentController.class);

	@Value("${sa.logic.api.url:http://localhost:5000}")
	private String saLogicApiUrl;

	@PostMapping("/sentiment")
	public SentimentDTO sentimentAnalysis(@RequestBody SentenceDTO sentenceDto) {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(saLogicApiUrl + "/analyse/sentiment");
		logger.info(saLogicApiUrl + "/analyse/sentiment");
		return restTemplate.postForEntity(saLogicApiUrl+ "/analyse/sentiment", sentenceDto, SentimentDTO.class)
				.getBody();
	}

	@GetMapping("/testHealth")
	public ResponseEntity<?> testHealth() {
		Map<String,String> response =new HashMap<>();
		response.put("message", "Middleware Layer Services are up and running");
		response.put("statusCode", "200");
		response.put("url",saLogicApiUrl);
		return new ResponseEntity<>(response ,HttpStatus.OK);
	}

	@GetMapping("/testComms") 
	public ResponseEntity<?> testComms() { 
		RestTemplate restTemplate = new RestTemplate(); 
		ResponseEntity<String> result;
		try{
			result = restTemplate.getForEntity(saLogicApiUrl + "/testHealth", String.class); 
		}catch(Exception e){
			Map<String,String> response =new HashMap<>();
			response.put("message", "BackEnd Services are Down");
			response.put("statusCode", "500");
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(result.getBody(),result.getStatusCode());
	}

	@GetMapping("/testSentiment") 
	public String testSentimentGet() { 
		RestTemplate restTemplate = new RestTemplate(); 
		ResponseEntity<String> result = restTemplate.getForEntity(saLogicApiUrl + "/analyse?sentence=i+am+so+happy!", String.class);
		 //assertEquals(HttpStatus.OK, result.getStatusCode()); 
		 return result.getBody(); 
	}

}