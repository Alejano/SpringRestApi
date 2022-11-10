package com.systemastics.api.services;


import java.util.List;

import com.systemastics.api.models.PedidoServicio;

public interface IPedidoService {
	
	public List<PedidoServicio> findAll(); 
	
	public void save(PedidoServicio pedido);
	
	public PedidoServicio findOne(Long pedido);
	
	public void delete(Long pedido);
	
	
}
