package com.stefanini.resource;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.stefanini.model.Endereco;
import com.stefanini.model.Pessoa;
import com.stefanini.servico.PessoaServico;
import com.stefanini.servico.EnderecoServico;

@Path("pessoas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
//@NamedQueries({ @NamedQuery(name = "Pessoa.findByNome", query = "select u from Pessoa u where u.nome=:nome") })
public class PessoaResource {

	@Inject
	private PessoaServico pessoaServico;
	
	@GET
	public Response obterListaPessoa() {
		return Response.ok(pessoaServico.getList().get()).build();
	}

	@POST
	public Response criarPessoa(@Valid Pessoa pessoa, @Context UriInfo uriInfo) {
//		Pessoa id = pessoaServico.salvar(pessoa);
//		
//		UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
//		uriBuilder.path(String.valueOf(id.getId()));
//		URI uri = uriBuilder.build();
//		
//		return Response.created(uri).build();
		return Response.ok(pessoaServico.salvar(pessoa)).build();
	}
	

	@GET
	@Path("{id}")
	public Response obterPessoa(@PathParam("id") long id) {
//		return Response.status(Status.INTERNAL_SERVER_ERROR).entity("deu ruim").build();
		return Response.ok(pessoaServico.encontrar(id).get()).build();
	}
	
	@GET
	@Path("/uf/{uf}")
	public Response getFildPessoaEndereco(@PathParam("uf") String uf, @Context UriInfo uriInfo){
		
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
	        EntityManager entityManager = entityManagerFactory.createEntityManager();
	        
	        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

	        CriteriaQuery<Endereco> criteriaQuery = criteriaBuilder.createQuery(Endereco.class);
	        Root<Endereco> root = criteriaQuery.from(Endereco.class);

	        criteriaQuery.select(root);
	        criteriaQuery.where(criteriaBuilder.equal(root.get("uf"), uf));
	        
	        try {
	        	TypedQuery<Endereco> typedQuery = entityManager.createQuery(criteriaQuery);

	            List<Endereco> lista = typedQuery.getResultList();
	            lista.forEach(u -> System.out.println(u.getUf()));
	            
	            return Response.ok(lista).build();
	            
			} catch (NoResultException e) {
				e.printStackTrace();
				return null;
			}
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
		
        
        
		
		
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
//        EntityManager em = entityManagerFactory.createEntityManager();
//		
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<Pessoa> cq = cb.createQuery(Pessoa.class);
//		
//		Root<Pessoa> pessoa = cq.from(Pessoa.class);
//		Join<Pessoa, Endereco> endereco = pessoa.join("endereco");
//		
//		cq.select(pessoa.get("nome"));
//		cq.where(cb.equal(endereco.get("uf"), uf));
//		
//		TypedQuery<Pessoa> q = em.createQuery(cq);
//		List<Pessoa> result = q.getResultList();
//		
//		return Response.ok(result).build();
	}
}
