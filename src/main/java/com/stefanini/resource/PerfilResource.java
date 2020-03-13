package com.stefanini.resource;

import java.net.URI;
import java.time.LocalDateTime;

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

import com.stefanini.model.Perfil;
import com.stefanini.servico.PerfilServico;
import com.stefanini.servico.PessoaServico;

@Path("perfis")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PerfilResource {
	
	@Inject
	private PerfilServico perfilServico;
	
	@GET
	public Response obterListaPerfil() {
		return Response.ok(perfilServico.getList().get()).build();
	}

	@POST
	public Response criarPerfil(@Valid Perfil perfil, @Context UriInfo uriInfo) {		
//		Perfil id = perfilServico.salvar(perfil);
//		
//		UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
//		uriBuilder.path(String.valueOf(id.getId()));
//		URI uri = uriBuilder.build();
//		
//		return Response.created(uri).build();
		return Response.ok(perfilServico.salvar(perfil)).build();
	}
	

	@GET
	@Path("{id}")
	public Response obterPerfil(@PathParam("id") long id) {
//		return Response.status(Status.INTERNAL_SERVER_ERROR).entity("deu ruim").build();
		return Response.ok(perfilServico.encontrar(id).get()).build();
	}
}
