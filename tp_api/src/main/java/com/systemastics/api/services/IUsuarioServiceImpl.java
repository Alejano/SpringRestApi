package com.systemastics.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.systemastics.api.models.Usuario;
import com.systemastics.api.models.dao.IUsuarioDao;

@Service
public class IUsuarioServiceImpl implements IUsuarioService {
	@Autowired
	private IUsuarioDao usuariodao;
	
	

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuariodao.findAll();
	}

	@Override
	public void save(Usuario usuario) {
		// TODO Auto-generated method stub
		usuariodao.save(usuario);
	}


	@Override
	@Transactional(readOnly = true)
	public Usuario findOne(Long usuario) {
		// TODO Auto-generated method stub
		return usuariodao.findById(usuario).orElse(null);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Usuario findUser(String usuario) {
		// TODO Auto-generated method stub
		return usuariodao.findUser(usuario);
	}

	@Override
	public void delete(Long usuario) {
		// TODO Auto-generated method stub
		usuariodao.deleteById(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public String findinfo(String usuario) {
		// TODO Auto-generated method stub
		return usuariodao.findinfo(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findApodo(String apodo) {
		// TODO Auto-generated method stub
		return usuariodao.findApodo(apodo);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findUserPlus() {
		// TODO Auto-generated method stub
		return  usuariodao.findUserPlus();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findelse(String frase,String yo) {
		// TODO Auto-generated method stub
		return usuariodao.findelse(frase,yo);
	}

	@Override
	public List<Usuario> myfriends(Long id) {
		// TODO Auto-generated method stub
		return usuariodao.myfriends(id);
	}

	@Override
	public boolean existsByUsername(String username) {
		// TODO Auto-generated method stub
		return usuariodao.existsByUsername(username);
	}

	@Override
	public boolean existsByEmail(String email) {
		// TODO Auto-generated method stub
		return usuariodao.existsByEmail(email);
	}

}
