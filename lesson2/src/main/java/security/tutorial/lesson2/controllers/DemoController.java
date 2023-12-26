package security.tutorial.lesson2.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import security.tutorial.lesson2.entities.Authority;

@RestController
public class DemoController {

	@GetMapping("/demo")
	public String demo() {
		Authentication u = SecurityContextHolder.getContext().getAuthentication();
		u.getAuthorities().forEach(System.out::println);
		return "Demo!";
	}

}
