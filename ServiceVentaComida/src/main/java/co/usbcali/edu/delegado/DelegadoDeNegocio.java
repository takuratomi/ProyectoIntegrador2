package co.usbcali.edu.delegado;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.usbcali.logica.IAlmuerzoLogica;
import co.edu.usbcali.logica.IBebidaLogica;
import co.edu.usbcali.logica.IHijoLogica;
import co.edu.usbcali.logica.IMenuSemanaLogica;
import co.edu.usbcali.logica.IPadreLogica;
import co.edu.usbcali.logica.IPagoLogica;
import co.edu.usbcali.logica.IParametrosLogica;
import co.edu.usbcali.logica.IPedidoLogica;
import co.edu.usbcali.logica.IPrincipioLogica;
import co.edu.usbcali.logica.IProteinaLogica;
import co.edu.usbcali.logica.ISopaLogica;
import co.edu.usbcali.logica.IUsuariosLogica;
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

public class DelegadoDeNegocio implements IDelegadoDeNegocio {

	@Autowired
	private IAlmuerzoLogica almuerzoLogica;
	
	@Autowired
	private IBebidaLogica bebidaLogica;
	
	@Autowired
	private IHijoLogica hijoLogica;
	
	@Autowired
	private IPadreLogica padreLogica;
	
	@Autowired
	private IPagoLogica pagoLogica;
	
	@Autowired
	private IParametrosLogica parametrosLogica;
	
	@Autowired
	private IPedidoLogica pedidoLogica;
	
	@Autowired
	private IPrincipioLogica principioLogica;
	
	@Autowired
	private IProteinaLogica proteinaLogica;
	
	@Autowired
	private ISopaLogica sopaLogica;
	
	@Autowired
	private IUsuariosLogica usuarioLogica;

	@Autowired
	private IMenuSemanaLogica menuSemanaLogica;
	
	@Override
	public void crearAlmuerzo(Almuerzo almuerzo) throws Exception {
		almuerzoLogica.crear(almuerzo);
	}

	@Override
	public void modificarAlmuerzo(Almuerzo almuerzo) throws Exception {
		almuerzoLogica.modificar(almuerzo);
	}

	@Override
	public void borrarAlmuerzo(Almuerzo almuerzo) throws Exception {
		almuerzoLogica.borrar(almuerzo);
	}

	@Override
	public Almuerzo consultarPorIdAlmuerzo(BigDecimal almuerzoId) throws Exception {
		return almuerzoLogica.consultarPorId(almuerzoId);
	}

	@Override
	public List<Almuerzo> consultarTodosAlmuerzo() throws Exception {
		return almuerzoLogica.consultarTodos();
	}

	@Override
	public void crearBebida(Bebida bebida) throws Exception {
		bebidaLogica.crear(bebida);
	}

	@Override
	public void modificarBebida(Bebida bebida) throws Exception {
		bebidaLogica.modificar(bebida);
	}

	@Override
	public void borrarBebida(Bebida bebida) throws Exception {
		bebidaLogica.borrar(bebida);
	}

	@Override
	public Bebida consultarPorIdBebida(BigDecimal bebidaId) throws Exception {
		return bebidaLogica.consultarPorId(bebidaId);
	}

	@Override
	public List<Bebida> consultarTodosBebida() throws Exception {
		return bebidaLogica.consultarTodos();
	}

	@Override
	public void crearHijo(Hijo hijo) throws Exception {
		hijoLogica.crear(hijo);
	}

	@Override
	public void modificarHijo(Hijo hijo) throws Exception {
		hijoLogica.modificar(hijo);
	}

	@Override
	public void borrarHIjo(Hijo hijo) throws Exception {
		hijoLogica.borrar(hijo);
	}

	@Override
	public Hijo consultarPorIdHijo(Long hijoId) throws Exception {
		return hijoLogica.consultarPorId(hijoId);
	}

	@Override
	public List<Hijo> consultarTodosHijo() throws Exception {
		return hijoLogica.consultarTodos();
	}

	@Override
	public void crearPadre(Padre padre) throws Exception {
		padreLogica.crear(padre);
	}

	@Override
	public void modificarPadre(Padre padre) throws Exception {
		padreLogica.modificar(padre);
	}

	@Override
	public void borrarPadre(Padre padre) throws Exception {
		padreLogica.borrar(padre);
	}

	@Override
	public Padre consultarPorIdPadre(Long padreId) throws Exception {
		return padreLogica.consultarPorId(padreId);
	}

	@Override
	public List<Padre> consultarTodosPadre() throws Exception {
		return padreLogica.consultarTodos();
	}

	@Override
	public void crearPago(Pago pago) throws Exception {
		pagoLogica.crear(pago);
	}

	@Override
	public void modificarPago(Pago pago) throws Exception {
		pagoLogica.modificar(pago);
	}

	@Override
	public void borrarPago(Pago pago) throws Exception {
		pagoLogica.borrar(pago);
	}

	@Override
	public Pago consultarPorIdPago(BigDecimal pagoId) throws Exception {
		return pagoLogica.consultarPorId(pagoId);
	}

	@Override
	public List<Pago> consultarTodosPago() throws Exception {
		return pagoLogica.consultarTodos();
	}

	@Override
	public void crearParametros(Parametros parametros) throws Exception {
		parametrosLogica.crear(parametros);
	}

	@Override
	public void modificarParametros(Parametros parametros) throws Exception {
		parametrosLogica.modificar(parametros);
	}

	@Override
	public void borrarParametros(Parametros parametros) throws Exception {
		parametrosLogica.borrar(parametros);
	}

	@Override
	public Parametros consultarPorIdParametros(Long parametrosId) throws Exception {
		return parametrosLogica.consultarPorId(parametrosId);
	}

	@Override
	public List<Parametros> consultarTodosParametros() throws Exception {
		return parametrosLogica.consultarTodos();
	}

	@Override
	public void crearPedido(Pedido pedido) throws Exception {
		pedidoLogica.crear(pedido);
	}

	@Override
	public void modificarPedido(Pedido pedido) throws Exception {
		pedidoLogica.modificar(pedido);
	}

	@Override
	public void borrarPedido(Pedido pedido) throws Exception {
		pedidoLogica.borrar(pedido);
	}

	@Override
	public Pedido consultarPorIdPedido(BigDecimal pedidoId) throws Exception {
		return pedidoLogica.consultarPorId(pedidoId);
	}

	@Override
	public List<Pedido> consultarTodosPedido() throws Exception {
		return pedidoLogica.consultarTodos();
	}

	@Override
	public void crearPrincipio(Principio principio) throws Exception {
		principioLogica.crear(principio);
	}

	@Override
	public void modificarPrincipio(Principio principio) throws Exception {
		principioLogica.modificar(principio);
	}

	@Override
	public void borrarPrincipio(Principio principio) throws Exception {
		principioLogica.borrar(principio);
	}

	@Override
	public Principio consultarPorIdPrincpio(BigDecimal principioId) throws Exception {
		return principioLogica.consultarPorId(principioId);
	}

	@Override
	public List<Principio> consultarTodosPrincipiio() throws Exception {
		return principioLogica.consultarTodos();
	}

	@Override
	public void crearProteina(Proteina proteina) throws Exception {
		proteinaLogica.crear(proteina);
	}

	@Override
	public void modificarProteina(Proteina proteina) throws Exception {
		proteinaLogica.modificar(proteina);
	}

	@Override
	public void borrarProteina(Proteina proteina) throws Exception {
		proteinaLogica.borrar(proteina);
	}

	@Override
	public Proteina consultarPorIdProteina(BigDecimal proteinaId) throws Exception {
		return proteinaLogica.consultarPorId(proteinaId);
	}

	@Override
	public List<Proteina> consultarTodosProteina() throws Exception {
		return proteinaLogica.consultarTodos();
	}

	@Override
	public void crearSopa(Sopa sopa) throws Exception {
		sopaLogica.crear(sopa);
	}

	@Override
	public void modificarSopa(Sopa sopa) throws Exception {
		sopaLogica.modificar(sopa);
	}

	@Override
	public void borrarSopa(Sopa sopa) throws Exception {
		sopaLogica.borrar(sopa);
	}

	@Override
	public Sopa consultarPorIdSopa(BigDecimal sopaId) throws Exception {
		return sopaLogica.consultarPorId(sopaId);
	}

	@Override
	public List<Sopa> consultarTodosSopa() throws Exception {
		return sopaLogica.consultarTodos();
	}

	@Override
	public void crearUsuario(Usuario usuario) throws Exception {
		usuarioLogica.crear(usuario);
	}

	@Override
	public void modificarUsuario(Usuario usuario) throws Exception {
		usuarioLogica.modificar(usuario);
	}

	@Override
	public void borrarUsuario(Usuario usuario) throws Exception {
		usuarioLogica.borrar(usuario);
	}

	@Override
	public Usuario consultarPorIdUsuario(Long usuId) {
		return usuarioLogica.consultarPorId(usuId);
	}

	@Override
	public Usuario consultarPorIdentificacionUsuario(Integer numIdentificacion, Integer tipoIdentificacion)
			throws Exception {
		return usuarioLogica.consultarPorIdentificacion(numIdentificacion, tipoIdentificacion);
	}

	@Override
	public List<Usuario> consultarTodosUsuario() throws Exception {
		return usuarioLogica.consultarTodos();
	}

	@Override
	public void crearMenuSemana(MenuSemana menuSemana) throws Exception {
		menuSemanaLogica.crear(menuSemana);
		
	}

	@Override
	public void modificarMenuSemana(MenuSemana menuSemana) throws Exception {
		menuSemanaLogica.modificar(menuSemana);
		
	}

	@Override
	public void borrarMenuSemana(MenuSemana menuSemana) throws Exception {
		menuSemanaLogica.borrar(menuSemana);
		
	}

	@Override
	public MenuSemana consultarPorIdMenuSemana(Long menuSemanaId) throws Exception {
		return menuSemanaLogica.consultarPorId(menuSemanaId);
	}

	@Override
	public List<MenuSemana> consultarTodosMenuSemana() throws Exception {
		return menuSemanaLogica.consultarTodos();
	}

	
	
	
	

}
