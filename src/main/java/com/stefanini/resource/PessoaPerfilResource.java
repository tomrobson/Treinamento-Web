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

import com.stefanini.model.PessoaPerfil;
import com.stefanini.servico.PessoaPerfilServico;

@Path("pessoasperfis")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaPerfilResource {
	
	@Inject
	private PessoaPerfilServico pessoaPerfilServico;

	@GET
	public Response obterListaPessoa() {
		return Response.ok(pessoaPerfilServico.getList().get()).build();
	}

	@POST
	public Response obterListaPessoa(@Valid PessoaPerfil pessoaPerfil) {
		return Response.ok(pessoaPerfilServico.salvar(pessoaPerfil)).build();
	}
	

	@GET
	@Path("{id}")
	public Response obterPessoa(@PathParam("id") long id) {
//		return Response.status(Status.INTERNAL_SERVER_ERROR).entity("deu ruim").build();
		return Response.ok(pessoaPerfilServico.encontrar(id).get()).build();
	}
}
