package ec.edu.ups.ppw.demo65.business;


import ec.edu.ups.ppw.demo65.dao.ClienteDAO;
import ec.edu.ups.ppw.demo65.model.Cliente;

import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionClientes {
	
	@Inject ClienteDAO DAO;
	
	public Cliente getCliente(String ci)throws Exception {
		if(ci.length() != 10) {
			throw new Exception("Numero no valido");
		}
		
		Cliente cli = DAO.read(ci);
		if(cli == null) 
			throw new Exception("Cliente no existe");
		
		return cli;	
	}
	
	public void createCliente(Cliente cliente) throws Exception {
		if(cliente.getCedula().length() != 10) {
			throw new Exception("Cedula incorrecta");
		}
		DAO.agregarCliente(cliente);
	}
	
	public List<Cliente> getAll(){
		return DAO.getClientes();
	}
	
	public List<Cliente>getClientes(){
		return DAO.getClientes();
	}
	
	
	
	
	

}
