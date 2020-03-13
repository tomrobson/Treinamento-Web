package com.stefanini.resource;

import java.net.URI;

import javax.inject.Inject;
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

import com.stefanini.model.Pessoa;
import com.stefanini.servico.PessoaServico;

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

}
