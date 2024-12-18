package ec.edu.ups.ppw.demo65.business;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;

import java.util.List;

import ec.edu.ups.ppw.demo65.dao.ClienteDAO;
import ec.edu.ups.ppw.demo65.model.Cliente;
import ec.edu.ups.ppw.demo65.model.Telefono;
import jakarta.inject.Inject;



@Singleton
@Startup

public class Inicio {

	@Inject
	private ClienteDAO clienteDAO;
	
	@PostConstruct
	public void init() {
	
		
		System.out.println("----------------Clientes----------------------");
		
        Cliente cliente1 = new Cliente();
        cliente1.setCedula("1234567890");
        cliente1.setNombre("Carlos Cueva");
        cliente1.setDireccion("Remigio Crespo");
		clienteDAO.agregarCliente(cliente1);
		
		Cliente cliente2 = new Cliente();
        cliente2.setCedula("1658975634");
        cliente2.setNombre("Juan Rodríguez");
        cliente2.setDireccion("Calle Larga 123");
		clienteDAO.agregarCliente(cliente2);
		

		
		System.out.println("---------------Telefonos----------------------");
		Telefono f1 = new Telefono();
		f1.setTipo("Celular");
		f1.setNumero("0957639577");
		cliente1.addTelefono(f1);
		
		Telefono f2 = new Telefono();
		f2.setTipo("Convencional");
		f2.setNumero("04687625679");
		cliente1.addTelefono(f2);
		
		Telefono f3 = new Telefono();
		f3.setTipo("Celular");
		f3.setNumero("0996758965");
		cliente2.addTelefono(f3);
		
		
		
		
		List<Cliente> listado = clienteDAO.getClientes();
		
		for(Cliente cli: listado) {
			System.out.println(cli.toString());
		}
		
		
		
	}
}
