package com.stefanini.dao;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import com.stefanini.dao.abstracao.GenericDao;
import com.stefanini.model.Endereco;
import com.stefanini.model.Pessoa;

/**
 * O Unico objetivo da Dao 
 * @author joaopedromilhome
 *
 */
public class EnderecoDao extends GenericDao<Endereco, Long> {

	public EnderecoDao() {
		super(Endereco.class);
	}
	
}
