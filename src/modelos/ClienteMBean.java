package modelos;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import controladores.BDEJB;

@ManagedBean
@RequestScoped
public class ClienteMBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String estado = "";
	
	private Cliente cliente = new Cliente();
	private List<Cliente> clientes;
	
	@EJB
	private BDEJB bdEJB;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void addCliente() {
		bdEJB.addCliente(cliente);
		estado = cliente.toString();
	}

	public List<Cliente> getClientes() {
		clientes = bdEJB.getClientes();
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void delCliente(String dni) {
		bdEJB.delCliente(dni);
	}
	
	

}
