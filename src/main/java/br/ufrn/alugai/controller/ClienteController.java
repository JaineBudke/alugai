package br.ufrn.alugai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufrn.alugai.model.Cliente;
import br.ufrn.alugai.model.Usuario;
import br.ufrn.alugai.service.ClienteService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService usuarioService;
	
	private static final String MSG_SUCESS_INSERT = "Student inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Student successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Student successfully.";
	private static final String MSG_ERROR = "Error.";
	
	@GetMapping("/dashboard-client")
	public String dashboardClient() {
		return "dashboard-client/index";
	}
	
	@GetMapping("/favorites")
	public String favoritesClient() {
		return "dashboard-client/favorites";
	}
	
	@GetMapping("/profile-client")
	public String profileClient() {
		return "dashboard-client/profile";
	}
	
	@GetMapping("/register-client")
	public String registerClient() {
		return "auth/register-client";
	}
	
	@PostMapping("/client-register-action")
	public String registerAction( @Valid @ModelAttribute Usuario entityUser, BindingResult result, RedirectAttributes redirectAttributes) {
		
		
		try {
			Cliente user = usuarioService.save(entityUser);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", e.getMessage());
			return "redirect:/user-register";
		}

		
        return "auth/login";
    }

}
