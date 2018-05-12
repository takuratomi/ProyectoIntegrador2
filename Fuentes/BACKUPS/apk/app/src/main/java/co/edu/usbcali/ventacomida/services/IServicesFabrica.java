package co.edu.usbcali.ventacomida.services;

import co.edu.usbcali.ventacomida.dto.PadreDTO;
import co.edu.usbcali.ventacomida.dto.ProductoDTO;
import co.edu.usbcali.ventacomida.dto.UsuarioDTO;

/**
 * Created by takuratomi on 18/04/18.
 */

public interface IServicesFabrica {

    public UsuarioDTO serviceGetVerificarDAtos(Long id);
    public PadreDTO servicePostCrerPadre(PadreDTO padreDTO);
    public ProductoDTO servicePostCrerProducto(ProductoDTO productoDTO);
}
