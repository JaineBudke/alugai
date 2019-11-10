package br.ufrn.alugai.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufrn.alugai.dao.GenericDao;
import br.ufrn.alugai.model.Endereco;
import br.ufrn.alugai.model.Imovel;
import br.ufrn.alugai.model.Usuario;
import br.ufrn.alugai.service.ImovelService;
import br.ufrn.alugai.service.UsuarioService;
import br.ufrn.alugai.util.ImovelForm;

@Controller
public class ImovelController {

	private static final String MSG_SUCESS_INSERT = "Imóvel inserido com sucesso.";
	private static final String MSG_SUCESS_UPDATE = "Imóvel modificado com sucesso.";
	private static final String MSG_SUCESS_DELETE = "Imóvel deletado com sucesso.";
	private static final String MSG_ERROR = "Error.";

	
	@Autowired
	private ImovelService imovelService;
	
	@Autowired
	private UsuarioService usuarioService;
	

	@PostMapping("/imovel/save")
	public String store( @Valid @ModelAttribute ImovelForm entityImovel,BindingResult result, RedirectAttributes redirectAttributes) {
		Imovel imovel = null;
		
		try {

			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			Usuario user = usuarioService.findByEmailAdress( auth.getName());
			
			imovelService.saveImovel(entityImovel, user);
			
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/properties";
	}
	
	

	@GetMapping("properties")
	public String showByUser(Model model) {
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario user = usuarioService.findByEmailAdress(auth.getName());
        
		List<Imovel> all = user.getImoveis();
		model.addAttribute("imoveis", all);
		return "dashboard-salesman/properties";
		
	}
	
	@PostMapping("imoveis/{id}/delete")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Imovel entity = imovelService.findById(id);
				imovelService.delete(entity);
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
		}
		return "redirect:/properties";
	}
	
	
	@GetMapping("imoveis/{id}/edit")
	public String update(Model model, @PathVariable("id") Integer id) {
		
		try {
			if (id != null) {
				
				Imovel entityImovel = imovelService.findById(id);
				model.addAttribute("imovel", entityImovel);
				
			}
		} catch (Exception e) {
		}
		return "property/edit";
	}
	
	@RequestMapping(value = "/imoveis/{id}", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute Imovel entity, BindingResult result, @PathVariable("id") Integer id,RedirectAttributes redirectAttributes) {
		Imovel imovel, oldImovel = null;
		try {
			entity.setId(id);
			oldImovel = imovelService.findById(id);
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        Usuario user = usuarioService.findByEmailAdress(auth.getName());	        
			imovelService.updateImovel(entity, oldImovel, user);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/properties";
	}
	
	
	@GetMapping("imoveis/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		
		try {
			if (id != null) {
				
				Imovel entity = imovelService.findById(id);
				model.addAttribute("imovel", entity);
				
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "property/show";
	}
	
}
