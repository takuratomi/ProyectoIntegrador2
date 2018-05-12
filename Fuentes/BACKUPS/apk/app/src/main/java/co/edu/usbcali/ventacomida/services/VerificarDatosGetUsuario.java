package co.edu.usbcali.ventacomida.services;

import android.os.AsyncTask;
import android.util.Log;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import co.edu.usbcali.ventacomida.dto.UsuarioDTO;

/**
 * Created by takuratomi on 18/04/18.
 */

public class VerificarDatosGetUsuario extends AsyncTask<Long,Integer,UsuarioDTO> {

    String url;
    UsuarioDTO response;

    public VerificarDatosGetUsuario(String url) {
        this.url = url;
    }

    @Override
    protected UsuarioDTO doInBackground(Long... id) {
        try {
            String temporal = url+id[0].toString();

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            response= restTemplate.getForObject(url+id.toString(), UsuarioDTO.class);
            return response;
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }
        return null;
    }

    public UsuarioDTO getResponse() {
        return response;
    }

    public void setResponse(UsuarioDTO response) {
        this.response = response;
    }
}
