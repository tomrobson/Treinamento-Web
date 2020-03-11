package com.stefanini.servico;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.validation.Valid;

import com.stefanini.dao.PessoaPerfilDao;
import com.stefanini.model.PessoaPerfil;
import com.stefanini.util.IGenericService;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class PessoaPerfilServico implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PessoaPerfilDao dao;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public PessoaPerfil salvar(@Valid PessoaPerfil entity) {
		return dao.salvar(entity);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public PessoaPerfil atualizar(@Valid PessoaPerfil entity) {
		return dao.atualizar(entity);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void remover(@Valid Long id) {
		dao.remover(id);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Optional<List<PessoaPerfil>> getList() {
		return dao.getList();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Optional<PessoaPerfil> encontrar(Long id) {
		return dao.encontrar(id);
	}
	

}
