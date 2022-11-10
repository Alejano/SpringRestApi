package com.systemastics.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.systemastics.api.models.PedidoServicio;
import com.systemastics.api.models.dao.IPedidoDao;


@Service
public class IPedidoServiceImpl implements IPedidoService {
	@Autowired
	private IPedidoDao pedidodao;
	
	
	
	@Override
	@Transactional(readOnly = true)
	public List<PedidoServicio> findAll() {
		// TODO Auto-generated method stub
		return (List<PedidoServicio>) pedidodao.findAll();
	}

	@Override
	public void save(PedidoServicio pedido) {
		// TODO Auto-generated method stub
		pedidodao.save(pedido);
	}


	@Override
	@Transactional(readOnly = true)
	public PedidoServicio findOne(Long pedido) {
		// TODO Auto-generated method stub
		return pedidodao.findById(pedido).orElse(null);
	}


	@Override
	public void delete(Long pedido) {
		// TODO Auto-generated method stub
		pedidodao.deleteById(pedido);
	}



}
