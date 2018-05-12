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
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    //  ------ MY VARS
    private ServiceConsultarProductos serviceConsultarProductos;
    private ListView listViewProdcutos;
    private List<ProductoDTO> losProducto;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ConsultarProductoFragment() {
        // Required empty public constructor
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
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        listViewProdcutos = getActivity().findViewById(R.id.losProductos);
//        losProducto = generateDatos();
//        AdapterProductos adapterProductos = new AdapterProductos(getActivity().getApplicationContext(),losProducto);
//        listViewProdcutos.setAdapter(adapterProductos);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_consultar_producto, container, false);

        listViewProdcutos = view.findViewById(R.id.losProductos);
        losProducto = generateDatos();
        serviceConsultarProductos = new ServiceConsultarProductos();
        serviceConsultarProductos.execute();
        losProducto = serviceConsultarProductos.getLosProductos();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        AdapterProductos adapterProductos = new AdapterProductos(getActivity().getApplicationContext(),losProducto);
        listViewProdcutos.setAdapter(adapterProductos);

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
//         EJEMPLO DE ARRAY LIST
//        ArrayList<ProductoDTO> lst = new ArrayList<ProductoDTO>();
//        lst.add(new ProductoDTO(1,new BigDecimal("1"),"bebida1","A"));
//        lst.add(new ProductoDTO(1,new BigDecimal("2"),"bebida2","A"));
//        lst.add(new ProductoDTO(1,new BigDecimal("3"),"bebida3","A"));
//        lst.add(new ProductoDTO(1,new BigDecimal("4"),"bebida4","A"));
//        lst.add(new ProductoDTO(1,new BigDecimal("5"),"bebida5","A"));
//        lst.add(new ProductoDTO(1,new BigDecimal("6"),"bebida6","A"));
//        lst.add(new ProductoDTO(1,new BigDecimal("7"),"bebida7","A"));
//        lst.add(new ProductoDTO(1,new BigDecimal("8"),"bebida8","I"));
//        lst.add(new ProductoDTO(1,new BigDecimal("9"),"bebida9","A"));
//        lst.add(new ProductoDTO(1,new BigDecimal("10"),"bebida10","A"));
//        lst.add(new ProductoDTO(1,new BigDecimal("11"),"bebida11","A"));
//
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

    public class ServiceConsultarProductos extends AsyncTask<Void,Void,List<ProductoDTO>>
    {
        // VARS
        ServiceRest serviceRest = new ServiceRest();

        //private String url = "http://192.168.1.8:8080/ServicesVentaComida/controller/ProductoRest/consultarTodos";
        private List<ProductoDTO> losProductos;
        private RestTemplate restTemplate;

        // CONSTRUCTORS
        public ServiceConsultarProductos() {}

        public ServiceConsultarProductos(String url, List<ProductoDTO> losProductos) {
            //this.url = url;
            this.losProductos = losProductos;
        }

        // GETTER AND SETTER

//        public String getUrl() {
//            return url;
//        }
//
//        public void setUrl(String url) {
//            this.url = url;
//        }

        public List<ProductoDTO> getLosProductos() {
            return losProductos;
        }

        public void setLosProductos(List<ProductoDTO> losProductos) {
            this.losProductos = losProductos;
        }


        //METHOD PUBLIC
        // OTHER METODS


        // IMPLEMENTS
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

                losProductos = Arrays.asList(losProductosDTO);

            }catch (Exception ex)
            {
                String e = ex.getMessage();
            }
            return losProductos;
        }
    }

}
