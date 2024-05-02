package Automoviles.autos.services;

import java.util.List;

import Automoviles.autos.business.GestionAutoLocal;
import Automoviles.autos.model.Autos;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("autos")
public class AutoServices {

	@Inject
	private GestionAutoLocal ges;
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Autos autos) {
		try {
			ges.guardar(autos);
			return Response.ok(autos).build();
		}catch(Exception ex) {
			ErrorMessage error = new ErrorMessage(500,"Error al guardar cliente: "+ ex.getMessage());
			return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Autos autos) {
		try {
			ges.actualizar(autos);
			return Response.ok(autos).build();
		}catch(Exception ex) {
			ErrorMessage error = new ErrorMessage(406,"Error al actualizar cliente: "+ex.getMessage());
			return Response.status(Response.Status.NOT_MODIFIED).entity(error).build();
		}
	}
	
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response borrar(@QueryParam("id") String codigo) {
		try {
			ges.borrar(codigo);
			return Response.ok(codigo).build();
		}catch(Exception ex) {
			ErrorMessage error = new ErrorMessage(99,"Error al borrar el cliente: "+ ex.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//@Produces("application/json")
	public Response leer(@QueryParam("placa") String placa) {
		try{
			System.out.println("cedula " +  placa);
			Autos cli = ges.getAuto(placa);
			return Response.ok(cli).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(404, "Cliente no existe: " + e.getMessage());
			return Response.status(Response.Status.NOT_FOUND).entity(error).build();
		}
	}
	
	@GET
	@Path("{dni}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response leer2(@PathParam("dni") String cedula) {
		try{
			System.out.println("cedula " +  cedula);
			Autos cli = ges.getAuto(cedula);
			return Response.ok(cli).build();
		}catch (Exception e) {
			ErrorMessage error = new ErrorMessage(404, "Cliente no existe: " + e.getMessage());
			return Response.status(Response.Status.NOT_FOUND).entity(error).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getClientes(){
		List<Autos> clientes = ges.getAutos();
		try {
			return Response.ok(clientes).build();
		}catch (Exception e) {
			ErrorMessage error = new ErrorMessage(404, "No se registran clientes");
			return Response.status(Response.Status.NOT_FOUND).entity(error).build();
		}
	}
	
}
