package br.ufrn.alugai.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.ufrn.alugai.model.Anuncio;
import br.ufrn.alugai.model.Cliente;
import br.ufrn.alugai.model.Imovel;
import br.ufrn.alugai.model.Usuario;
import br.ufrn.alugai.model.Vendedor;
import br.ufrn.alugai.service.AnuncioService;
import br.ufrn.alugai.service.ClienteService;
import br.ufrn.alugai.service.UsuarioService;
import br.ufrn.alugai.util.ImovelForm;
import br.ufrn.alugai.util.VendedorForm;


@Controller
public class GeneralController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ClienteService clienteService;

	@Autowired
	private AnuncioService anuncioService;

	
	@GetMapping("/login")
	public String loginPage() {
        return "auth/login";
	}
	
	@GetMapping("/register")
	public String registerPage() {
		return "auth/register";
	}
	

	@GetMapping("/index")
	public String initialPage(Model model) {
		
		return "index";
	}
	
	@GetMapping("/dashboard")
	public String dashboard( Model model ) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario user = usuarioService.findByEmailAdress(auth.getName());
        if( user instanceof Vendedor ) {
        	
   
        	return "redirect:/dashboard-salesman";
        }
        
        return "redirect:/dashboard-client";
	}
	
	
	
	/**
	 * PÁGINAS REFERENTES AO IMOVEL
	 */
	
	@GetMapping("/create-property")
	public String createProperty(Model model) {
		model.addAttribute("imovelform", new ImovelForm());
		return "property/create";
	}
	
	

	
	
}
