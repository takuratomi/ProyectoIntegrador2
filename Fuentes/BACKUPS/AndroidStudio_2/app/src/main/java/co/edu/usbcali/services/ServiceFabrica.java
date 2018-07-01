package co.edu.usbcali.services;

import android.os.AsyncTask;

import java.util.HashMap;

import co.edu.usbcali.dto.PadreDTO;
import co.edu.usbcali.dto.ProductoDTO;
import co.edu.usbcali.dto.UsuarioDTO;

/**
 * Created by takuratomi on 18/04/18.
 */

public class ServiceFabrica implements IServicesFabrica {

    String url = "";

    HashMap services;

    VerificarDatosGetUsuario verificarDatosGetUsuario;

    public ServiceFabrica() {

        url = "http://$:8080/ServicesVentaComida/controller/";

        services = new HashMap<String,String>();
        services.put("crearPadre","PadreRest/crear");
        services.put("verificarDatosUsuario","");
        services.put("crearProducto","ProductoRest/crearProducto");
        services.put("verificarDatosUsuario","PadreRest/verificarDatosUsuario/");

    }

    public ServiceFabrica(String ip_) {

        url = "http://$:8080/ServicesVentaComida/controller/".replace("$",ip_);

        services = new HashMap<String,String>();
        services.put("crearPadre","PadreRest/crear");
        services.put("verificarDatosUsuario","");
        services.put("crearProducto","ProductoRest/crearProducto");
        services.put("verificarDatosUsuario","PadreRest/verificarDatosUsuario/");

    }

    public ServiceFabrica(String url, HashMap services) {
        this.url = url;
        this.services = services;
    }

    public void setIP(String ip_)
    {
        if(url != null || !url.isEmpty())
        {
            this.url.replace("$",ip_);
        }
    }

    @Override
    public UsuarioDTO serviceGetVerificarDAtos(Long id) {
        verificarDatosGetUsuario = new VerificarDatosGetUsuario(url+services.get("verificarDatosUsuario"));
        return verificarDatosGetUsuario.doInBackground(id);
    }

    @Override
    public PadreDTO servicePostCrerPadre(PadreDTO padreDTO) {
        return null;
    }

    @Override
    public ProductoDTO servicePostCrerProducto(ProductoDTO productoDTO) {
        return null;
    }

}
