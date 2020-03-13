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
import com.stefanini.model.PessoaPerfil;
import com.stefanini.servico.PessoaPerfilServico;

@Path("pessoasperfis")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaPerfilResource {
	
	@Inject
	private PessoaPerfilServico pessoaPerfilServico;

	@GET
	public Response obterListaPessoaPerfil() {
		return Response.ok(pessoaPerfilServico.getList().get()).build();
	}

	@POST
	public Response obterListaPessoaPerfil(@Valid PessoaPerfil pessoaPerfil, @Context UriInfo uriInfo) {
//		PessoaPerfil id = pessoaPerfilServico.salvar(pessoaPerfil);
//		
//		UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
//		uriBuilder.path(String.valueOf(id.getId()));
//		URI uri = uriBuilder.build();
//		
//		return Response.created(uri).build();
		return Response.ok(pessoaPerfilServico.salvar(pessoaPerfil)).build();
	}
	

	@GET
	@Path("{id}")
	public Response obterPessoaPerfil(@PathParam("id") long id) {
//		return Response.status(Status.INTERNAL_SERVER_ERROR).entity("deu ruim").build();
		return Response.ok(pessoaPerfilServico.encontrar(id).get()).build();
	}
}
