package ec.edu.ups.ppw.demo65.dao;


import java.util.List;

import ec.edu.ups.ppw.demo65.model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;



@Stateless
public class ClienteDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void agregarCliente(Cliente cliente) {
		em.persist(cliente);
	}
	
	public void actualizarCliente(Cliente cliente) {
		em.merge(cliente);
	}
	
	public void eliminarVehiculo(String cedula) {
		Cliente cliente= em.find(Cliente.class, cedula);
		em.remove(cliente);
	}
	
	public List<Cliente> getClientes() {
		String jpql = "SELECT c FROM Cliente c";
		Query query = em.createQuery(jpql, Cliente.class);
		
		List<Cliente> list = query.getResultList();
		
		return list;
	}
	


}
