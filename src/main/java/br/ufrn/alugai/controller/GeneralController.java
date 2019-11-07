package br.ufrn.alugai.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.ufrn.alugai.model.Cliente;
import br.ufrn.alugai.model.Usuario;
import br.ufrn.alugai.model.Vendedor;
import br.ufrn.alugai.service.ClienteService;
import br.ufrn.alugai.service.UsuarioService;


@Controller
public class GeneralController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping("/login")
	public String loginPage() {
        return "auth/login";
	}
	
	@GetMapping("/register")
	public String registerPage() {
		return "auth/register";
	}
	

	
	
	@GetMapping("/index")
	public String initialPage() {
		return "index";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario user = usuarioService.findByEmailAdress(auth.getName());
        if(user.getVendedor() != null)
        	return "redirect:/dashboard-salesman";
        else if( user.getCliente() != null)
        	return "redirect:/dashboard-client";
        
        return "redirect:/dashboard-client";
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
