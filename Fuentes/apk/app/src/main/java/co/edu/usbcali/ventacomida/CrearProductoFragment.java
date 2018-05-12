package co.edu.usbcali.ventacomida;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;

import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Date;

import co.edu.usbcali.ventacomida.alertas.AlertaServicio;
import co.edu.usbcali.ventacomida.dto.ProductoDTO;

//import android.widget.AdapterView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CrearProductoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CrearProductoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CrearProductoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private boolean flagCallServiceSave = false;

    //  ------ MY VARS
//    private ListView listViewProdcutos;
//    private ArrayList<ProductoDTO> losProducto;


    private OnFragmentInteractionListener mListener;

    // UI REFERENCES
    private ProgressBar progressBar;
    private AutoCompleteTextView mIdentificacionlView;
    private View mProgressView;
    private View createProdcutoFormView;
    private TextInputEditText txtNombreProdcuto;
    private TextInputEditText txtDescripcionProdcuto;
    private Spinner spinnerTipoProducto;
    private Button btnCrearProdcuto;

    // VARS
    private String nameProdcut = "";
    private String descriptionProduct = "";
    private String selectTipoProducto = "";
    private ProductoDTO productoDTO;

    // SERVICE
    SaveProductoTask saveProductoTask = null;


    // METHODS PUBLICS
    public CrearProductoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CrearProductoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CrearProductoFragment newInstance(String param1, String param2) {
        CrearProductoFragment fragment = new CrearProductoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        //        listViewProdcutos = getView().findViewById(R.id.losProductos);
        //        losProducto = generateDatos();
        //        AdapterProductos adapterProductos = new AdapterProductos(getActivity().getApplicationContext(),losProducto);
        //        listViewProdcutos.setAdapter(adapterProductos);

        View view = inflater.inflate(R.layout.fragment_crear_producto, container, false);
        createProdcutoFormView = view.findViewById(R.id.form_create_producto);
        mProgressView = view.findViewById(R.id.spinner_tipo_producto);
        txtNombreProdcuto = (TextInputEditText) view.findViewById(R.id.txt_in_nombre_producto);
        txtDescripcionProdcuto = (TextInputEditText) view.findViewById(R.id.txt_in_descripcion_producto);
        spinnerTipoProducto = (Spinner) view.findViewById(R.id.spinner_tipo_producto);
        btnCrearProdcuto = view.findViewById(R.id.btn_guardar_producto);
        btnCrearProdcuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean flagCreateProduct = false;
                // process-create-producto
                AlertaServicio alertaServicio = new AlertaServicio();
                alertaServicio.setBarTitle("Alerta Servicio");
                flagCallServiceSave = validateCampos();

                if(flagCallServiceSave)
                {
                    flagCreateProduct = processCreateProducto();
                    if(flagCreateProduct)
                    {

                        alertaServicio.setMessage("Se guardo el producto");
                        alertaServicio.show(getFragmentManager(),"Alert");
                        txtNombreProdcuto.setText("");
                        txtDescripcionProdcuto.setText("");
                    }
                    else
                    {
                        alertaServicio.setMessage("Se guardo el producto");
                        alertaServicio.show(getFragmentManager(),"Alert");
                    }
                }
            }
        });

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
//    public ArrayList<ProductoDTO> generateDatos() {
//
//        ArrayList<ProductoDTO> lst = new ArrayList<ProductoDTO>();
//
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
//        return lst;
//    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            createProdcutoFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            createProdcutoFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    createProdcutoFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            createProdcutoFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    public boolean validateCampos()
    {
        selectTipoProducto = spinnerTipoProducto.getSelectedItem().toString();
        nameProdcut = txtNombreProdcuto.getText().toString().trim();
        descriptionProduct = txtDescripcionProdcuto.getText().toString().trim();
        // selectTipoProducto


        if(nameProdcut == null || nameProdcut.equals("")) {
            txtNombreProdcuto.setError("El nombre del producto es obligatorio");
            txtNombreProdcuto.requestFocus();
            return false;
        }
        if(descriptionProduct == null || descriptionProduct.equals("")) {
            txtDescripcionProdcuto.setError("La descripcion del producto es obligatoria");
            txtDescripcionProdcuto.requestFocus();
            return false;
        }

        return true;
    }

    public boolean processCreateProducto()
    {
        boolean flagSucces = false;
        int tipProducto = 0;
        productoDTO = new ProductoDTO();

        switch (selectTipoProducto)
        {
            case ("Sopa") :
                tipProducto = 1;
                break;
            case ("Principio") :
                tipProducto = 2;
                break;
            case ("Proteina") :
                tipProducto = 3;
                break;
            case ("Bebida") :
                tipProducto = 4;
                break;
        }
        productoDTO.setId(new BigDecimal(0));
        productoDTO.setTipoProducto(tipProducto);
        productoDTO.setNombre(nameProdcut.trim());
        productoDTO.setDescripcion(descriptionProduct.trim());
        productoDTO.setEstado("A");
        productoDTO.setUsuario("TAKURATOMI");
        productoDTO.setFecha(new Date());

        // CALL services
        saveProductoTask = new SaveProductoTask();
        String ip = "192.168.1.5";
        // http://localhost:8080/ServicesVentaComida/controller/ProductoRest/crear
        saveProductoTask.setUrl("http://localhost:8080/ServicesVentaComida/controller/ProductoRest/crear".replace("localhost",ip));
        saveProductoTask.setProductoDTO(productoDTO);
        saveProductoTask.execute();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productoDTO = saveProductoTask.getProductoDTO();

        if(productoDTO.getCodigoError() == 0)
        {
           flagSucces = true;
        }
        else if(productoDTO.getCodigoError() > 0)
        {
            flagSucces = false;
        }

        return flagSucces;
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class SaveProductoTask extends AsyncTask<Void, Void, ProductoDTO> {

        ProductoDTO productoDTO;
        RestTemplate restTemplate;
        String url;

        public SaveProductoTask() {}

        @Override
        protected ProductoDTO doInBackground(Void... voids) {
            try {

                String url_ = "http://192.168.1.5:8080/ServicesVentaComida/controller/ProductoRest/crear";
                restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

                HttpEntity<ProductoDTO> request = new HttpEntity<ProductoDTO>(productoDTO);

                try {

                    Object response = restTemplate.postForEntity(url, productoDTO, ProductoDTO.class);

                }catch (Exception e)
                {
                    String mensjea = e.getMessage();
                }
                productoDTO.setCodigoError(0);
                productoDTO.setMensajeError("Operacion Exitosa");

            }catch (Exception ex)
            {
                String e = ex.getMessage();
                productoDTO.setCodigoError(90);
                productoDTO.setMensajeError("Error: "+e);
                return productoDTO;
            }

            return productoDTO;
        }

        public SaveProductoTask(String u) {
            this.url = u;
        }

        // GETTER AND SETTER

        public ProductoDTO getProductoDTO() {
            return productoDTO;
        }

        public void setProductoDTO(ProductoDTO productoDTO) {
            this.productoDTO = productoDTO;
        }

        public RestTemplate getRestTemplate() {
            return restTemplate;
        }

        public void setRestTemplate(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        // IMPLEMENTATIONS
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(ProductoDTO productoDTO) {
            super.onPostExecute(productoDTO);
            this.productoDTO = productoDTO;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            saveProductoTask = null;
        }
    }
}
