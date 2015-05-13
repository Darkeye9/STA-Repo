package modelos;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import controladores.BDEJB;

@ManagedBean
@RequestScoped
public class PedidoMBean {

	private String estado = "";
	private Pedido pedido = new Pedido();
	private List<Pedido> pedidos;
	
	@EJB
	BDEJB bdEJB;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Pedido> getPedidos() {
		pedidos = bdEJB.getPedidos();
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public void addPedido(String dni, String passwd, Long pid) {
		if (bdEJB.login(dni,passwd))
		{
			pedido=bdEJB.addPedido(dni, pid);
			estado = pedido.toString();
		}else
		{
			estado = "Acceso Denegado";
		}

	}

	public void delPedido(Long id) {
		bdEJB.delPedido(id);
	}
	
	
}
