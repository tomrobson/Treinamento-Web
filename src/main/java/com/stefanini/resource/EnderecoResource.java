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

import com.stefanini.model.Endereco;
import com.stefanini.servico.EnderecoServico;

@Path("enderecos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnderecoResource {
	
	@Inject
	private EnderecoServico enderecoServico;
	
	@GET
	public Response obterListaEndereco() {
		return Response.ok(enderecoServico.getList().get()).build();
	}

	@POST
	public Response criarEndereco(@Valid Endereco endereco, @Context UriInfo uriInfo) {
//		Endereco id = enderecoServico.salvar(endereco);
//		
//		UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
//		uriBuilder.path(String.valueOf(id.getId()));
//		URI uri = uriBuilder.build();
//		
//		return Response.created(uri).build();
		return Response.ok(enderecoServico.salvar(endereco)).build();
	}
	

	@GET
	@Path("{id}")
	public Response obterEndereco(@PathParam("id") long id) {
//		return Response.status(Status.INTERNAL_SERVER_ERROR).entity("deu ruim").build();
		return Response.ok(enderecoServico.encontrar(id).get()).build();
	}
}
