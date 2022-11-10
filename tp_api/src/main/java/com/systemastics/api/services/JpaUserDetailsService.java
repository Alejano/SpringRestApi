package com.systemastics.api.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.systemastics.api.models.Usuario;
import com.systemastics.api.models.dao.IUsuarioDao;

@Service("JpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService{
	@Autowired 
	private IUsuarioDao usuarioDao;
	
	private Logger logger = LoggerFactory.getLogger(UserDetails.class);
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioDao.findByUsername(username);
		System.out.println(usuario);
		
		if(usuario == null) {
			logger.error("Error login: no existe el usuario '"+username+"'");
			throw new UsernameNotFoundException("Username " +username+ " no existe en el sistema!");
		}
		System.out.println(usuario.getAuthority().getAuthority());
		List<GrantedAuthority> authorities =new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(usuario.getAuthority().getAuthority()));
		
		if(authorities.isEmpty()) {
			logger.error("Error login: usuario no tiene role '"+username+"'");
			throw new UsernameNotFoundException("Useename " +username+ " no tiene roles asignados!");
		}
		
		return new User(usuario.getUsername(),usuario.getContrasena(),usuario.isEnabled(),true,true,true, authorities);
	}

}
