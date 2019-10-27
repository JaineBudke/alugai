package br.ufrn.alugai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import br.ufrn.alugai.model.Usuario;
import br.ufrn.alugai.repository.UsuarioRepository;
import br.ufrn.alugai.util.UsuarioDetails;

@Service
public class UsuarioDetailsService implements UserDetailsService {
 
    @Autowired
    @Qualifier("usuarioRepository")
    private UsuarioRepository userRepository;
    
    public UsuarioDetailsService() {
        super();
    }
 
    public UserDetails loadUserByUsername(String username) {
        Usuario user = userRepository.findByEmailAddress(username);
        if (user == null) {
            throw new RuntimeException(username);
        }
        return new UsuarioDetails(user);
    }
}

