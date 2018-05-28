package co.edu.usbcali.ventacomida;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.edu.usbcali.ventacomida.adapters.AdapterProductos;
import co.edu.usbcali.ventacomida.alertas.AlertaServicio;
import co.edu.usbcali.ventacomida.dto.HijoDTO;
import co.edu.usbcali.ventacomida.dto.ProductoDTO;
import co.edu.usbcali.ventacomida.services.ServiceRest;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ConsultarProductoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ConsultarProductoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConsultarProductoFragment extends Fragment {

    //  ------ MY VARS
    private ServiceConsultarProductos serviceConsultarProductos;
    private ListView listViewProdcutos;
    private List<ProductoDTO> losProducto;
    private ProgressBar progressBar;
    private AlertaServicio alertaServicio;
    private Context context;
    private Map<String, ProductoDTO> listSelected;

    //constast
    private static final String ACTIVAR_PRODUCTO   = "ACTIVAR";
    private static final String INACTICAR_PRODUCTO = "INACTIVAR";


    private OnFragmentInteractionListener mListener;

    public ConsultarProductoFragment() {
        // Required empty public constructor
    }

    // MEHOD PUBLIC
    public void showProgress(boolean show)
    {
        if(show)
        {
            listViewProdcutos.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
        }
        else
        {
            listViewProdcutos.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
        }
    }

    /**
     *
     *
     * Carga del loadAdapter
     */
    public void loadAdapter()
    {
        losProducto = serviceConsultarProductos.getLosProductos();
        AdapterProductos adapterProducto = new AdapterProductos(context,losProducto,listSelected);
        listViewProdcutos.setAdapter(adapterProducto);
    }


    public void changeStatusProduct(String change)
    {
        ProductoDTO[] arrayProductos = new ProductoDTO[100];
        ProductoDTO[] arrayProductos2 = null;
        int positon = 0;
        /**
         * 1. Validar que la lista no sea nula
         * 2. Validar que hayan productos seleccionados para realizar el cambio
         * 3 recorrer los objetos productoDTO haciendo el cambio de estado para su update en base de datos.
         * 4. LLamado del servicio que resive un array de productos a ser cambiados.
         * 5. consumir nuevamente el servicio consultar para ser asignado al adapter de productos
         * 6. llamar al metodo loadAdapter para cargar nuevamente los productos.
         */

        try {

            Log.d("logAdapter","size in fragment consultar: "+listSelected.size());
            if(listSelected != null || listSelected.size() > 0)
            {

                if(change.equals("A"))
                {
                    for (Map.Entry<String, ProductoDTO> entry : listSelected.entrySet()) {
                        entry.getValue().setEstado(change);

                        if(positon < 100)
                        {
                            arrayProductos[positon] = entry.getValue();
                            positon++;
                        }

                    }
                    try
                    {

                                          List<Map<String, ProductoDTO>> temporal =   Arrays.asList(listSelected);
                    }catch (Exception e )
                    {
                        e.getMessage();
                    }


                }
                else if(change.equals("I"))
                {
                    for (Map.Entry<String, ProductoDTO> entry : listSelected.entrySet()) {
                        entry.getValue().setEstado(change);
                        arrayProductos[positon] = entry.getValue();
                        positon++;
                    }
                }

                // call service to update
                ServiceCambiarEstadoProductos serviceCambiarEstadoProductos = new ServiceCambiarEstadoProductos(arrayProductos);
                serviceCambiarEstadoProductos.execute();

                // call load adapter.
                loadAdapter();

            }



        }catch (Exception e)
        {
            Log.d("logAdapter",e.getMessage());
        }


//        if(losProducto != null) {
//            if (change.equals(ACTIVAR_PRODUCTO)) {
//
//            } else if (change.equals(INACTICAR_PRODUCTO)) {
//
//            }
//
//        }
//        else
//        {
//            AlertaServicio alertaServicio = new AlertaServicio();
//            alertaServicio.setBarTitle("VentaComida");
//            alertaServicio.setMessage("No se dispone de productos para ser actualizados");
//            alertaServicio.show(getFragmentManager(),"alertNullListProduct");
//
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConsultarProductoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConsultarProductoFragment newInstance(String param1, String param2) {
        ConsultarProductoFragment fragment = new ConsultarProductoFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        MenuInflater menuInflanter = inflater;
        menuInflanter.inflate(R.menu.menu_consultar_productos,menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String ACTIVAR = "A";
        String INACTIVAR = "I";

        switch (item.getItemId())
        {
            case (R.id.item_consultarProducto_activar):
                Log.d("log","Se presiono Activar prodcuto");
                changeStatusProduct(ACTIVAR);
                // llamado del metodo para obtener los elementos a cambiar de estado
                break;
            case (R.id.item_consultarProducto_inactivar):
                Log.d("log","Se presiono Inactivar prodcuto");
                changeStatusProduct(INACTIVAR);
                // llamado del metodo para obtener los elementos a cambiar de estado.

                break;
        }

        return super.onOptionsItemSelected(item);
    }


//    public void optionChangeEstadoProductos(String cambio)
//    {
//        String ACTIVAR = "ACTIVAR";
//        String INACTIVAR = "INACTIVAR";

        /**
         * 1. Validar que la lista no sea nula
         * 2. Validar que hayan productos seleccionados para realizar el cambio
         * 3 recorrer los objetos productoDTO haciendo el cambio de estado para su update en base de datos.
         * 4. LLamado del servicio que resive un array de productos a ser cambiados.
         * 5. consumir nuevamente el servicio consultar para ser asignado al adapter de productos
         * 6. llamar al metodo loadAdapter para cargar nuevamente los productos.
         */
//
//
//        if(cambio.equals(ACTIVAR))
//        {
//
//
//        }
//        else if(cambio.equals(INACTIVAR))
//        {
//
//        }
//
//    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        listSelected = new HashMap<String, ProductoDTO>();

        View view = inflater.inflate(R.layout.fragment_consultar_producto, container, false);
        setHasOptionsMenu(true);
        listViewProdcutos = view.findViewById(R.id.losProductos);
        progressBar = (ProgressBar) view.findViewById(R.id.progresbar_consultar_producto);

        context = getActivity().getApplicationContext();
        serviceConsultarProductos = new ServiceConsultarProductos();
        showProgress(true);
        serviceConsultarProductos.execute();

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    /****************************************************************************/
    /**
     * Clase para ejecutar en segundo plano un servicio de modificar estad de un producto
     *
     */
    public class ServiceCambiarEstadoProductos extends AsyncTask<Void,Void,Boolean> {
        // VARS
        ServiceRest serviceRest = new ServiceRest();
        private RestTemplate restTemplate;
        private ProductoDTO []losProductosDTO;

        // CONSTRUCTORS
        public ServiceCambiarEstadoProductos() {}

        public ServiceCambiarEstadoProductos(ProductoDTO[] productosDTO) {
            this.losProductosDTO = productosDTO;
        }

        // GETTER AND SETTER
        //METHOD PUBLIC
        // OTHER METODS


        // IMPLEMENTS
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Boolean isSucces) {
            super.onPostExecute(isSucces);

            if (isSucces) {
                //Call method to adapter
                showProgress(false);
                loadAdapter();
            } else {
                showProgress(false);
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            boolean statusServices = false;
            try {

                restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                HttpEntity<ProductoDTO[]> request = new HttpEntity<ProductoDTO[]>(losProductosDTO);
                restTemplate.postForLocation(serviceRest.UPDATESTATUSPRODUCTO_POST_ARRAYPRODUCTODTO_PRODUCTODTO, request);

            }catch (Exception ex)
            {
                statusServices = false;
            }

                return statusServices;
//            }
        }
    }



    /****************************************************************************/
    /**
     * Clase para ejecutar en segundo plano un servicio de consultar productos
     *
     */
    public class ServiceConsultarProductos extends AsyncTask<Void,Void,Boolean>
    {
        // VARS
        ServiceRest serviceRest = new ServiceRest();

        //private String url = "http://192.168.1.8:8080/ServicesVentaComida/controller/ProductoRest/consultarTodos";
        private List<ProductoDTO> losProductos;
        private RestTemplate restTemplate;


        // CONSTRUCTORS
        public ServiceConsultarProductos() {}

        // GETTER AND SETTER
        public List<ProductoDTO> getLosProductos() {
            return losProductos;
        }

        public void setLosProductos(List<ProductoDTO> losProductos) { this.losProductos = losProductos; }


        //METHOD PUBLIC
        // OTHER METODS


        // IMPLEMENTS
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Boolean isSucces) {
            super.onPostExecute(isSucces);

            if(isSucces)
            {
                //Call method to adapter
                showProgress(false);
                loadAdapter();
            }
            else
            {
                showProgress(false);
//                alertaServicio = new AlertaServicio("Alerta De Servicio", "Ocurrio Un error en conexion volver a intentarlo");
//                alertaServicio.show(getSupportFragmentManager(), "tagAlerta");

            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            boolean statusServices = false;
            try {

                restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

                ProductoDTO[] losProductosDTO = restTemplate.getForObject(serviceRest.CONSULTARPRODCUTOS_POST_NULL_LISTAPRODUCTOS, ProductoDTO[].class);

                if(losProductosDTO != null)
                {
                    losProductos = Arrays.asList(losProductosDTO);
                    statusServices = true;
                }
                else {
                    losProductos = null;
                    statusServices = false;
                }
            }catch (Exception ex)
            {
                statusServices = false;
            }

            return  statusServices;
        }
    }

}
