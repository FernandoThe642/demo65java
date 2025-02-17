package ec.edu.ups.ppw.demo65.views;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.ppw.demo65.dao.ClienteDAO;
import ec.edu.ups.ppw.demo65.model.Cliente;
import ec.edu.ups.ppw.demo65.model.Telefono;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("clientes")
@ViewScoped
public class VistaClientes implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private ClienteDAO clienteDAO;
    
    private Cliente cliente;
    private Telefono telefono;
    private List<Telefono> telefonos;
    private List<Cliente> listado;
    
    @PostConstruct
    public void init() {
        cliente = new Cliente();
        telefono = new Telefono();
        telefonos = new ArrayList<>();
        listado = clienteDAO.getClientes(); // Cargar clientes desde la BD
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Telefono getTelefono() {
        return telefono;
    }
    
    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }
    
    public List<Telefono> getTelefonos() {
        return telefonos;
    }
    
    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }
    
    public List<Cliente> getListado() {
        return listado;
    }
    
    public void setListado(List<Cliente> listado) {
        this.listado = listado;
    }
    

    public void agregarTelefono() {
        if (telefono.getNumero() == null || telefono.getNumero().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe ingresar un número de teléfono"));
        } else {
            telefonos.add(telefono);
            telefono = new Telefono(); // Se reinicia para el siguiente teléfono
        }
    }

    public String guardar() {
        if (cliente.getCedula() == null || cliente.getCedula().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe ingresar una cédula válida"));
            return null;
        }
        
        if (telefonos.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe agregar al menos un teléfono"));
            return null;
        }
        
        try {
            // Asociar cada teléfono al cliente uno por uno
            for (Telefono tel : telefonos) {
                cliente.addTelefono(tel);
            }
            
            clienteDAO.agregarCliente(cliente); // Guardar el cliente en la BD
            
            // Actualizar la lista de clientes
            listado = clienteDAO.getClientes();
            
            // Limpiar el formulario
            cliente = new Cliente();
            telefonos = new ArrayList<>();
            
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente Guardado", "Cliente agregado correctamente"));
            return "listadoclientes?faces-redirect=true";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
            return null;
        }
    }
}
