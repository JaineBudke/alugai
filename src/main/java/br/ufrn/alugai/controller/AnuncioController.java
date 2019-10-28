package br.ufrn.alugai.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufrn.alugai.model.Anuncio;
import br.ufrn.alugai.model.Imovel;
import br.ufrn.alugai.model.Usuario;
import br.ufrn.alugai.service.AnuncioService;
import br.ufrn.alugai.service.ImovelService;
import br.ufrn.alugai.service.UsuarioService;
import br.ufrn.alugai.util.AnuncioForm;
import br.ufrn.alugai.util.ImovelForm;

@Controller
public class AnuncioController {

	private static final String MSG_SUCESS_INSERT = "Anúncio inserido com sucesso.";
	private static final String MSG_SUCESS_UPDATE = "Anúncio modificado com sucesso.";
	private static final String MSG_SUCESS_DELETE = "Anúncio deletado com sucesso.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private AnuncioService anuncioService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ImovelService imovelService;
	
	
	@GetMapping("/create-advertisement")
	public String createAdvertisement(Model model) {
		

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario user = usuarioService.findByEmailAdress(auth.getName());
        
        List<Imovel> allImoveis = user.getImoveis();
        model.addAttribute("imoveis", allImoveis);
        model.addAttribute("anuncioform", new AnuncioForm());
        
		return "advertisement/create";
	}
	
	@PostMapping("/anuncio/save")
	public String store( @Valid @ModelAttribute AnuncioForm entityAnuncioForm,BindingResult result, RedirectAttributes redirectAttributes) {
		Anuncio anuncio = null;
		
		try {

			final Anuncio anuncioEntity = new Anuncio();
			 
			Imovel imovel = imovelService.findById(entityAnuncioForm.getImovelId());
			anuncioEntity.setImovel(imovel);
			
			anuncioEntity.setCondominio( entityAnuncioForm.getAnuncio().getCondominio() );
			anuncioEntity.setDescricao( entityAnuncioForm.getAnuncio().getDescricao() );
			anuncioEntity.setIptu( entityAnuncioForm.getAnuncio().getIptu() );
			anuncioEntity.setPreco( entityAnuncioForm.getAnuncio().getPreco() );

			anuncio = anuncioService.saveAnuncio(anuncioEntity);
			
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/dashboard";
	}

	
	
	
	@GetMapping("/advertisement")
	public String showByUser(Model model) {
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario user = usuarioService.findByEmailAdress(auth.getName());
        
        List<Anuncio> allAnuncios = null;
        
		List<Imovel> allImoveis = user.getImoveis();
		for( Imovel imovel : allImoveis ) {
			allAnuncios.addAll( imovel.getAnuncios() );
		}
		
		model.addAttribute("anuncios", allAnuncios);
		return "dashboard-salesman/advertisement";
		
	}
	
}
