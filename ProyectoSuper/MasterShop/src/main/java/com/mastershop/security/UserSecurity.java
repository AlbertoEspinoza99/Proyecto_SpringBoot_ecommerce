package com.mastershop.security;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mastershop.entity.Cliente;
import com.mastershop.entity.Usuario;
import com.mastershop.services.ClienteServices;
import com.mastershop.services.UsuarioServices;

@Service
public class UserSecurity implements UserDetailsService{

	@Autowired
	private ClienteServices serCli;
	
	@Autowired
	private UsuarioServices serUsu;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDetails datos=null;
		
		Cliente bean=serCli.clientexlogin(username);
		Usuario bean2=serUsu.usuarioPorlogin(username);
		
		if(bean==null && bean2!=null) {
		
		Set<GrantedAuthority> rol=new HashSet<GrantedAuthority>();
		
		rol.add(new SimpleGrantedAuthority(bean2.getRol().getDescripcion()));
		
		datos=new User(username, bean2.getClave(), rol);
		
		return datos;	
						
		}else {
					
		Set<GrantedAuthority> rol=new HashSet<GrantedAuthority>();
		
		rol.add(new SimpleGrantedAuthority(bean.getRol()));
		
		datos=new User(username, bean.getClaveCliente(), rol);
		
		return datos;
		
		}

	}


	
}
