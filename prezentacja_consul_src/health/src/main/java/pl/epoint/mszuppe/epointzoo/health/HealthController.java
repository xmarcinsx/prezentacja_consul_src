package pl.epoint.mszuppe.epointzoo.health;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by marcin on 04.12.17.
 */
@RestController
public class HealthController {

    @RequestMapping(value = "/healthcheck", method = RequestMethod.GET)
    public String healthcheck() {
        return "OK";
    }
}
