package br.ufrn.alugai.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.ufrn.alugai.model.Usuario;


public class UsuarioDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private final Usuario user;
	
	public UsuarioDetails( Usuario user) {
		this.user = user;
	}
	

    //

    public String getUsername() {
        return user.getEmail();
    }

     
    public String getPassword() {
        return user.getPassword();
    }


     
    public boolean isAccountNonExpired() {
        return true;
    }

     
    public boolean isAccountNonLocked() {
        return true;
    }

     
    public boolean isCredentialsNonExpired() {
        return true;
    }

     
    public boolean isEnabled() {
        return true;
    }

    //

    public Usuario getUser() {
        return user;
    }


	 
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

        list.add(new SimpleGrantedAuthority("user"));

        return list;
	}
}
