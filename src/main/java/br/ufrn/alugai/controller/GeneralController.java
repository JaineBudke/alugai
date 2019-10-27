package br.ufrn.alugai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {

	@GetMapping("/login")
	public String loginPage() {
        return "auth/login";
	}
	
	@GetMapping("/register")
	public String registerPage() {
		return "auth/register";
	}
	
	
	@GetMapping("/register-salesman")
	public String registerSalesman() {
		return "auth/register-salesman";
	}
	

	
	
	@GetMapping("/index")
	public String initialPage() {
		return "index";
	}
	
	
	/**
	 * DASHBOARD DO VENDEDOR
	 * @return
	 */
	@GetMapping("/dashboard-salesman")
	public String dashboardSalesman() {
		return "dashboard-salesman/index";
	}
	
	@GetMapping("/profile-salesman")
	public String profileSalesman() {
		return "dashboard-salesman/profile";
	}
	
	@GetMapping("/properties")
	public String propertiesSalesman() {
		return "dashboard-salesman/properties";
	}
	
	@GetMapping("/advertisement")
	public String advertisementSalesman() {
		return "dashboard-salesman/advertisement";
	}
	
	
	/**
	 * PÁGINAS REFERENTES AO IMOVEL
	 */
	
	@GetMapping("/create-property")
	public String createProperty() {
		return "property/create";
	}
	
	/**
	 * PÁGINAS REFERENTES AO ANUNCIO
	 */
	
	@GetMapping("/create-advertisement")
	public String createAdvertisement() {
		return "advertisement/create";
	}
	
	
}
