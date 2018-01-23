package pl.epoint.mszuppe.epointzoo.zoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZooController {
	
	@Autowired
	ZooDelegate zooDelegate;

	@RequestMapping(value = "/animals/{species}", method = RequestMethod.GET)
	public String getAnimals(@PathVariable String species) {
		return zooDelegate.getAnimals(species);
	}

	
}
