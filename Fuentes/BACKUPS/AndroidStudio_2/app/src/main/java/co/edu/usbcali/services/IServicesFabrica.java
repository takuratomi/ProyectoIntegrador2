package co.edu.usbcali.services;

import android.os.AsyncTask;

import co.edu.usbcali.dto.PadreDTO;
import co.edu.usbcali.dto.ProductoDTO;
import co.edu.usbcali.dto.UsuarioDTO;

/**
 * Created by takuratomi on 18/04/18.
 */

public interface IServicesFabrica {

    public UsuarioDTO serviceGetVerificarDAtos(Long id);
    public PadreDTO servicePostCrerPadre(PadreDTO padreDTO);
    public ProductoDTO servicePostCrerProducto(ProductoDTO productoDTO);
}
