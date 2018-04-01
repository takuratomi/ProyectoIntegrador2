package co.usbcali.edu.delegado;

import java.math.BigDecimal;
import java.util.List;

import co.edu.usbcali.modelo.Almuerzo;
import co.edu.usbcali.modelo.Bebida;
import co.edu.usbcali.modelo.Hijo;
import co.edu.usbcali.modelo.MenuSemana;
import co.edu.usbcali.modelo.Padre;
import co.edu.usbcali.modelo.Pago;
import co.edu.usbcali.modelo.Parametros;
import co.edu.usbcali.modelo.Pedido;
import co.edu.usbcali.modelo.Principio;
import co.edu.usbcali.modelo.Proteina;
import co.edu.usbcali.modelo.Sopa;
import co.edu.usbcali.modelo.Usuario;

public interface IDelegadoDeNegocio {

	//Almuerzo
	
	public void crearAlmuerzo(Almuerzo almuerzo) throws Exception;
	public void modificarAlmuerzo(Almuerzo almuerzo) throws Exception;
	public void borrarAlmuerzo(Almuerzo almuerzo) throws Exception;
	public Almuerzo consultarPorIdAlmuerzo(BigDecimal almuerzoId) throws Exception;
	public List<Almuerzo> consultarTodosAlmuerzo() throws Exception;
	
	//Bebida
	
	public void crearBebida(Bebida bebida) throws Exception;
	public void modificarBebida(Bebida bebida) throws Exception;
	public void borrarBebida(Bebida bebida) throws Exception;
	public Bebida consultarPorIdBebida(BigDecimal bebidaId) throws Exception;
	public List<Bebida> consultarTodosBebida() throws Exception;
	
	//Hijo
	
	public void crearHijo(Hijo hijo) throws Exception;
	public void modificarHijo(Hijo hijo) throws Exception;
	public void borrarHIjo(Hijo hijo) throws Exception;
	public Hijo consultarPorIdHijo(Long hijoId) throws Exception;
	public List<Hijo> consultarTodosHijo() throws Exception;
	
	//Padre
	
	public void crearPadre(Padre padre) throws Exception;
	public void modificarPadre(Padre padre) throws Exception;
	public void borrarPadre(Padre padre) throws Exception;
	public Padre consultarPorIdPadre(Long padreId) throws Exception;
	public List<Padre> consultarTodosPadre() throws Exception;
	
	//Pago
	
	public void crearPago(Pago pago) throws Exception;
	public void modificarPago(Pago pago) throws Exception;
	public void borrarPago(Pago pago) throws Exception;
	public Pago consultarPorIdPago(BigDecimal pagoId)throws Exception;
	public List<Pago> consultarTodosPago() throws Exception;
	
	//Parametros
	
	public void crearParametros(Parametros parametros) throws Exception;
	public void modificarParametros(Parametros parametros) throws Exception;
	public void borrarParametros(Parametros parametros) throws Exception;
	public Parametros consultarPorIdParametros(Long parametrosId) throws Exception;
	public List<Parametros> consultarTodosParametros() throws Exception;
	
	//Pedido
	
	public void crearPedido(Pedido pedido) throws Exception;
	public void modificarPedido(Pedido pedido) throws Exception;
	public void borrarPedido(Pedido pedido) throws Exception;
	public Pedido consultarPorIdPedido(BigDecimal pedidoId) throws Exception;
	public List<Pedido> consultarTodosPedido() throws Exception;
	
	//Principio
	
	public void crearPrincipio(Principio principio) throws Exception;
	public void modificarPrincipio(Principio principio) throws Exception;
	public void borrarPrincipio(Principio principio) throws Exception;
	public Principio consultarPorIdPrincpio(BigDecimal principioId) throws Exception;
	public List<Principio> consultarTodosPrincipiio() throws Exception;
	
	//Proteina
	
	public void crearProteina(Proteina proteina) throws Exception;
	public void modificarProteina(Proteina proteina) throws Exception;
	public void borrarProteina(Proteina proteina) throws Exception;
	public Proteina consultarPorIdProteina(BigDecimal proteinaId) throws Exception;
	public List<Proteina> consultarTodosProteina() throws Exception;
	
	//Sopa
	
	public void crearSopa(Sopa sopa) throws Exception;
	public void modificarSopa(Sopa sopa) throws Exception;
	public void borrarSopa(Sopa sopa) throws Exception;
	public Sopa consultarPorIdSopa(BigDecimal sopaId) throws Exception;
	public List<Sopa> consultarTodosSopa() throws Exception;
	
	//Usuarios
	
	public void crearUsuario(Usuario usuario) throws Exception;
	public void modificarUsuario(Usuario usuario) throws Exception;
	public void borrarUsuario(Usuario usuario) throws Exception;
	public Usuario consultarPorIdUsuario(Long usuId);
	public Usuario consultarPorIdentificacionUsuario(Integer numIdentificacion, Integer tipoIdentificacion) throws Exception;
	public List<Usuario> consultarTodosUsuario() throws Exception;
	
	//MenuSemana
	
	public void crearMenuSemana(MenuSemana menuSemana) throws Exception;
	public void modificarMenuSemana(MenuSemana menuSemana) throws Exception;
	public void borrarMenuSemana(MenuSemana menuSemana) throws Exception;
	public MenuSemana consultarPorIdMenuSemana(Long menuSemanaId) throws Exception;
	public List<MenuSemana> consultarTodosMenuSemana() throws Exception;
}
