package br.ufrn.alugai.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufrn.alugai.model.Anuncio;
import br.ufrn.alugai.model.Favoritos;
import br.ufrn.alugai.model.Imovel;
import br.ufrn.alugai.model.Usuario;
import br.ufrn.alugai.service.FavoritosService;
import br.ufrn.alugai.service.UsuarioService;
import br.ufrn.alugai.util.AnuncioForm;

@Controller
public class FavoritosController {

	

	private static final String MSG_SUCESS_INSERT = "Anúncio favorito inserido com sucesso.";
	private static final String MSG_SUCESS_UPDATE = "Anúncio favorito modificado com sucesso.";
	private static final String MSG_SUCESS_DELETE = "Anúncio favorito deletado com sucesso.";
	private static final String MSG_ERROR = "Error.";

	
	
	@Autowired
	private UsuarioService usuarioService;

	
	@Autowired
	private FavoritosService favoritosService;

	

	@GetMapping("/favorites")
	public String showByUser(Model model) {
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario user = usuarioService.findByEmailAdress(auth.getName());
        
        List<Favoritos> favoritos = user.getFavoritos();
        
        model.addAttribute("favoritos", favoritos);
        
		return "dashboard-client/favorites";
		
	}
	
	@PostMapping("favoritos/{id}/delete")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Favoritos entity = favoritosService.findById(id);
				favoritosService.delete(entity);
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
		}
		return "redirect:/properties";
	}
	
	
	@PostMapping("/favoritos/save")
	public String store( @Valid @ModelAttribute Favoritos entityFavoritos,BindingResult result, RedirectAttributes redirectAttributes) {
		
		try {

			Favoritos favoritosEntity = new Favoritos();
			
			favoritosService.save(favoritosEntity);
			
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/dashboard";
	}
	
	
}
