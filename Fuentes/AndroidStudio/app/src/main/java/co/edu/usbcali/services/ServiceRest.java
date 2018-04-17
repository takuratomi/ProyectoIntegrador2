package co.edu.usbcali.services;

import android.os.AsyncTask;
import android.util.Log;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

import co.edu.usbcali.dto.UsuarioDTO;

public class ServiceRest extends AsyncTask<Void, Void, UsuarioDTO>{

    private HashMap services;
    private String url;
    private boolean flagInit = false;
    @Override
    protected UsuarioDTO doInBackground(Void... voids) {
        try {
            //final String url = "http://172.20.10.10:8080/serviceRestDemo/controller/operacionesMatematicas/sumar/1/1"; // the  url from where to fetch data(json)
            if(!flagInit)
            {
                initServices();
            }

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            String url = getUrl("verificarDatosUsuario")+"";
            UsuarioDTO response= restTemplate.getForObject(url, UsuarioDTO.class);
            return response;
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }
        return null;
    }


    public void initServices ()
    {
        services = new HashMap<String,String>();

        services.put("ip","192.168.1.16");
        // se debe remplazar el simbolo $ por la ip que se almacene en la llave ip
        services.put("host","http://$:8080/ServicesVentaComida/controller/");
        services.put("crearPadre","PadreRest/crear");
        services.put("verificarDatosUsuario","");
        services.put("crearProducto","ProductoRest/crear");
        flagInit = true;
    }

    public  String getUrl (String key)
    {
        String url = "";
        if (this.url == null || this.url.equals(""))
        {
            url = (String) services.get("host");
            url = url.replace("$",(String)services.get("ip"));
        }


        if(services.containsKey(key))
        {
            url = url + (String) services.get(key);
            return url;
        }
        else
        {
            return null;
        }
    }

}
