package co.edu.usbcali.ventacomida;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import co.edu.usbcali.ventacomida.adapters.AdapterProductos;
import co.edu.usbcali.ventacomida.alertas.AlertaServicio;
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
//      View view = inflater.inflate(R.layout.fragment_consultar_producto, container, false);
        losProducto = serviceConsultarProductos.getLosProductos();
        AdapterProductos adapterProducto = new AdapterProductos(context,losProducto);
        listViewProdcutos.setAdapter(adapterProducto);
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
        View view = inflater.inflate(R.layout.fragment_consultar_producto, container, false);

        listViewProdcutos = view.findViewById(R.id.losProductos);
        progressBar = (ProgressBar) view.findViewById(R.id.progresbar_consultar_producto);

        context = getActivity().getApplicationContext();

//        losProducto = generateDatos(); -- modelo viejo
        serviceConsultarProductos = new ServiceConsultarProductos();
        showProgress(true);
        serviceConsultarProductos.execute();
//        losProducto = serviceConsultarProductos.getLosProductos();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        AdapterProductos adapterProductos = new AdapterProductos(getActivity().getApplicationContext(),losProducto);
//        listViewProdcutos.setAdapter(adapterProductos);

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

    /* EJEMPLO VIEJO  de array adapteer
        losProductos = findViewById(R.id.losProductos);
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,R.array.lstProductos, android.R.layout.simple_list_item_1);
        losProductos.setAdapter(adaptador);*/
    public List<ProductoDTO> generateDatos() {

        List<ProductoDTO> lst = new ArrayList<ProductoDTO>();
        serviceConsultarProductos = new ServiceConsultarProductos();
        serviceConsultarProductos.execute();
        lst = serviceConsultarProductos.getLosProductos();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        if(lst != null ) {
//            for (ProductoDTO produtoDto : lst) {
//                Log.d("Error",produtoDto.getId().toString());
//                Log.d("Error",produtoDto.getNombre().toString());
//                Log.d("Error",produtoDto.getDescripcion().toString());
//            }
//        }
        return lst;
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


        /**
         *
         * old
         *

         @Override
         protected void onPreExecute() {
         super.onPreExecute();
         }

         @Override
         protected void onPostExecute(List<ProductoDTO> productoDTOS) {
         super.onPostExecute(productoDTOS);
         }

         @Override
         protected void onProgressUpdate(Void... values) {
         super.onProgressUpdate(values);
         }

         @Override
         protected void onCancelled(List<ProductoDTO> productoDTOS) {
         super.onCancelled(productoDTOS);
         }

         @Override
         protected void onCancelled() {
         super.onCancelled();
         }

         @Override
         protected List<ProductoDTO> doInBackground(Void... voids) {
         try {
         restTemplate = new RestTemplate();
         restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
         String temporal_url = serviceRest.CONSULTARPRODCUTOS_POST_NULL_LISTAPRODUCTOS;

         ProductoDTO[] losProductosDTO = restTemplate.getForObject(serviceRest.CONSULTARPRODCUTOS_POST_NULL_LISTAPRODUCTOS, ProductoDTO[].class);

         if(losProductosDTO != null)
         {
         losProductos = Arrays.asList(losProductosDTO);
         }




         }catch (Exception ex)
         {
         String e = ex.getMessage();
         }
         return losProductos;
         }*/
    }

}
