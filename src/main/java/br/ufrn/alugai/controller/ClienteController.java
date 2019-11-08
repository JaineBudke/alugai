package br.ufrn.alugai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufrn.alugai.model.Cliente;
import br.ufrn.alugai.model.Interesse;
import br.ufrn.alugai.model.Usuario;
import br.ufrn.alugai.service.ClienteService;
import br.ufrn.alugai.service.UsuarioService;
import br.ufrn.alugai.util.ClientForm;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private UsuarioService usuarioService; 
	
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
	public String profileClient(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario user = usuarioService.findByEmailAdress(auth.getName());
        model.addAttribute("interesses", user.getCliente().getInteresses());
		return "dashboard-client/profile";
	}
	
	@GetMapping("/register-client")
	public String registerClient(Model model) {
		model.addAttribute("clienteForm", new ClientForm());
		return "auth/register-client";
	}
	
	@PostMapping("/client-register-action")
	public String registerAction( @Valid @ModelAttribute ClientForm entityUser, BindingResult result, RedirectAttributes redirectAttributes) {
		
		
		try {
			clienteService.save(entityUser);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", e.getMessage());
			return "redirect:/user-register";
		}

		
        return "auth/login";
    }
	
	@PostMapping("interesses/{id}/delete")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		        Usuario user = usuarioService.findByEmailAdress(auth.getName());
		        Cliente c = user.getCliente();
		        List<Interesse> interesses = c.getInteresses();
				for(Interesse i  : interesses) {
					if( i.getId() == id) {
						c.getInteresses().remove(i);
					}
				}

		        clienteService.update(c);
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
		}
		return "redirect:/profile-client";
	}

}
