package com.systemastics.api.services;


import java.util.List;


import com.systemastics.api.models.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findAll(); 
	
	public void save(Usuario usuario);
	
	public Usuario findOne(Long usuario);
	
	public void delete(Long usuario);
	
	public Usuario findUser(String usuario);
	
	public Usuario findApodo(String apodo);
	
	public String findinfo(String usuario);
	
	public List<Usuario> findUserPlus();

	public List<Usuario> findelse(String frase,String yo);
	
	public List<Usuario> myfriends(Long id);
	
	public boolean existsByUsername(String username);
	public boolean existsByEmail(String emain);
	
}
