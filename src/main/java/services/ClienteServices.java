package services;

import java.util.List;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import ec.edu.ups.ppw.demo65.business.GestionClientes;
import ec.edu.ups.ppw.demo65.model.Cliente;


@Path("/clientes")
public class ClienteServices {
	
	
	@Inject
	private GestionClientes gClientes;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> list(){
		return gClientes.getAll();
	}
	
	
	
	@POST
	public void create(Cliente cliente) {
		
	}
	
	@PUT
	public void update(Cliente cliente) {
			
	}

	

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@PathParam("/{ci}")
	public Cliente read(String ci) {
		Cliente cli;
		try {
			cli = gClientes.getCliente(ci);
			return cli;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
