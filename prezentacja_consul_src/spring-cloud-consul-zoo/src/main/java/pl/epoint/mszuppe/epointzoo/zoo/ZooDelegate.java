package pl.epoint.mszuppe.epointzoo.zoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ZooDelegate {

	private static final String ANIMAL_SERVICE_URL = "http://animal-service";
	private static final String SPECIES_API = "species/{species}";

	@Autowired
	RestTemplate restTemplate;
	
	public String getAnimals(String species) {
		String response = restTemplate.exchange(
				String.join("/", ANIMAL_SERVICE_URL, SPECIES_API),
				HttpMethod.GET, null,
				new ParameterizedTypeReference<String>() { },
				species).getBody();

		return "Species:  " + species + " - animals in ZOO: " + response;
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
