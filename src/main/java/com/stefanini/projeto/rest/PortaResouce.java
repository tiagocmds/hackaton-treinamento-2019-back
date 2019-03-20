package com.stefanini.projeto.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.projeto.model.Chave;
import com.stefanini.projeto.model.Porta;
import com.stefanini.projeto.service.PortaService;

@Path("porta")
public class PortaResouce {
	
	PortaService portaService = new PortaService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		List<Porta> portas = portaService.findAll();

		if (portas.isEmpty()) {
			return Response.ok().build();
		}

		return Response.ok(portas).build();
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvar(Porta porta) {
		portaService.adicionar(porta);
		return Response
	            .status(200)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .header("Access-Control-Max-Age", "1209600")
	            .build();
	}
	@DELETE
	@Path("/excluir/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response excluir(@PathParam("id") Integer id) {
		portaService.deletar(id);
		return Response.ok().build();
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editar(Porta porta) {
		portaService.alterar(porta);
		return Response.ok().build();
	}
	@POST
	@Path("/addchave")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addChave(Chave chave) {
		portaService.addChave(chave);
		return Response
	            .status(200)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .header("Access-Control-Max-Age", "1209600")
	            .build();
	}
}

