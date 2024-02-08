package be.abis.sandwich.service;

import be.abis.sandwich.model.Sandwich;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AbisSandwichService implements SandwichService {
	@Autowired
	private RestTemplate rt;

	private String baseUrl = "http://localhost:8080/api";

	@Override
	public List<Sandwich> getAllSandwiches() {
		ResponseEntity<List<Sandwich>> responseEntity = rt.exchange(baseUrl + "/sandwiches/all", HttpMethod.GET, null, new ParameterizedTypeReference<List<Sandwich>>() {
		});
		return responseEntity.getBody();
	}

	@Override
	public Sandwich findSandwichById(int id) {
		ResponseEntity<Sandwich> responseEntity = rt.exchange(baseUrl + "/sandwiches/" + id, HttpMethod.GET, null, new ParameterizedTypeReference<Sandwich>() {});
		return responseEntity.getBody();
	}

}
