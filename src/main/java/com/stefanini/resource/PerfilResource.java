package com.stefanini.resource;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.model.Perfil;
import com.stefanini.servico.PerfilServico;

@Path("perfis")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PerfilResource {
	
	@Inject
	private PerfilServico perfilServico;
	
	@GET
	public Response obterListaPessoa() {
		return Response.ok(perfilServico.getList().get()).build();
	}

	@POST
	public Response obterListaPessoa(@Valid Perfil perfil) {
		return Response.ok(perfilServico.salvar(perfil)).build();
	}
	

	@GET
	@Path("{id}")
	public Response obterPessoa(@PathParam("id") long id) {
//		return Response.status(Status.INTERNAL_SERVER_ERROR).entity("deu ruim").build();
		return Response.ok(perfilServico.encontrar(id).get()).build();
	}
}
