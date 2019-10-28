package br.ufrn.alugai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufrn.alugai.model.Usuario;
import br.ufrn.alugai.service.VendedorService;
import br.ufrn.alugai.util.VendedorForm;

@Controller
public class VendedorController {
	
	@Autowired
	private VendedorService usuarioService;
	
	private static final String MSG_SUCESS_INSERT = "Student inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Student successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Student successfully.";
	private static final String MSG_ERROR = "Error.";
	
	@GetMapping("/register-salesman")
	public String registerSalesman(Model model) {
        model.addAttribute("vendedorform", new VendedorForm());
		return "auth/register-salesman";
	}
	
	@GetMapping("/dashboard-salesman")
	public String dashboardSalesman() {
		return "dashboard-salesman/index";
	}
	
	@GetMapping("/profile-salesman")
	public String profileSalesman() {
		return "dashboard-salesman/profile";
	}

	
	@GetMapping("/advertisement")
	public String advertisementSalesman() {
		return "dashboard-salesman/advertisement";
	}
	
	@PostMapping("/salesman-register-action")
	public String registerAction( @Valid @ModelAttribute VendedorForm entityUser, BindingResult result, RedirectAttributes redirectAttributes) {
		
		
		try {
			usuarioService.save(entityUser);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", e.getMessage());
			return "redirect:/register-salesman";
		}

		
        return "auth/login";
    }
}
