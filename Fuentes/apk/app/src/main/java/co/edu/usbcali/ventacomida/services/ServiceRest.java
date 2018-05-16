package co.edu.usbcali.ventacomida.services;

import android.os.AsyncTask;
import android.util.Log;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

import co.edu.usbcali.ventacomida.dto.UsuarioDTO;

public class ServiceRest {
    /////////////////////////////////////////////
    //  ESTRUCTURA DEL NOMBRAMIENTO DEL ATRIBUTO
    //
    // public String nameService_method_in_out;
    //

    public String CONSULTARPRODCUTOS_POST_NULL_LISTAPRODUCTOS = "http://192.168.1.8:8080/ServicesVentaComida/controller/ProductoRest/consultarTodos";

    public String VERIFICARDATOSUSUARIO_GET_LONG_USUARIODTO = "http://192.168.1.8:8080/ServicesVentaComida/controller/PadreRest/verificarDatosUsuario/";

    public String CREARPRODUCTO_POST_PRODUCTODTO_PRODUCTODTO = "http://192.168.1.8:8080/ServicesVentaComida/controller/ProductoRest/crear";

    public String REGISTRARPADRE_POST_PADREDTO_PADREDTO = "http://192.168.1.8:8080/ServicesVentaComida/controller/PadreRest/crearPadre";

    public String REGISTRARHIJO_POST_HIJODTO_HIJODTO = "http://192.168.1.8:8080/ServicesVentaComida/controller/HijoRest/crearHijo";

    public String CONSULTARPADRES_GET_NULL_LISTAPADREDTO = "http://192.168.1.8:8080/ServicesVentaComida/controller/PadreRest/consultarPadres";


}
