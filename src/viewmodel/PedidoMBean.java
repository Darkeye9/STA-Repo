package viewmodel;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import controller.BDEJB;
import model.Pedido;

@ManagedBean
@RequestScoped
public class PedidoMBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Pedido pedido = new Pedido();
	
	@EJB
	private BDEJB bdEJB;

	/**
	 * @return the pedido
	 */
	public Pedido getPedido() {
		return pedido;
	}

	/**
	 * @param pedido the pedido to set
	 */
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}	

}
