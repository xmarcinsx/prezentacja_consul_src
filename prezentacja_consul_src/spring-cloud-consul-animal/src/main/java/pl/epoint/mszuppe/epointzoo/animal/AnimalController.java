package pl.epoint.mszuppe.epointzoo.animal;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

@RestController
public class AnimalController {

	private static Map<String, List<Animal>> animalsDB = new HashMap<>();

	static {
		animalsDB.put("badger", asList(new Animal("Mati", "ho ho ho"),
                                         new Animal("Marti", "he he he")));
		animalsDB.put("foxy", asList(new Animal("Paula", "hi hi hi")));
		animalsDB.put("duck", asList(new Animal("Grześ", "kwa kwa")));
	}

	@RequestMapping(value = "/species/{species}", method = RequestMethod.GET)
	public List<Animal> getAnimals(@PathVariable String species) {
		
		List<Animal> animals = animalsDB.get(species);
		if (animals == null) {
			animals = singletonList(new Animal("Not Found", ""));
		}
		return animals;
	}
}
