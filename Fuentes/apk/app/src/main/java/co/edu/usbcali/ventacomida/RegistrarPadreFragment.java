package co.edu.usbcali.ventacomida;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
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

import java.sql.Date;

import co.edu.usbcali.ventacomida.alertas.AlertaServicio;
import co.edu.usbcali.ventacomida.dto.PadreDTO;
import co.edu.usbcali.ventacomida.dto.ProductoDTO;
import co.edu.usbcali.ventacomida.dto.UsuarioDTO;
import co.edu.usbcali.ventacomida.services.ServiceRest;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegistrarPadreFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RegistrarPadreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistrarPadreFragment extends Fragment {

    // PROPIEDADES
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String numIdentificacion;
    private String tipoIdentificacion;
    private String direccion;
    private String telefono;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    // UI REFERENCES
    private ProgressBar progressBar;
    private View mProgressView;
    private View createPadreFormView;
    private TextInputEditText txtPrimerNombre;
    private TextInputEditText txtSegundoNombre;
    private TextInputEditText txtPrimerApellido;
    private TextInputEditText txtSegundoApellido;
    private TextInputEditText txtnumIdentificacion;
    private TextInputEditText txtTelefono;
    private TextInputEditText txtDireccion;
    private Spinner spinnerTipoIdentificacion;
    private Button btnCrearPadre;

    // CONSTRUCTORES
    public RegistrarPadreFragment() {
        // Required empty public constructor
    }
    // PRIVATE METHODS
    private boolean validateInField()
    {
        String mensajeError = "El campo $ es obligatorio";
        if(TextUtils.isEmpty(txtPrimerNombre.getText().toString()))
        {
            txtPrimerNombre.setError(mensajeError.replace("$","Primer Nombre"));
            txtPrimerNombre.requestFocus();
            return false;
        }
//        --------------------------------------------------------------------------------------------
//        se omite la validacion del segundo nombre ya que algunas personas solo disponen de un unico
//        nombre
//        if(TextUtils.isEmpty(txtSegundoNombre.getText().toString()))
//        {
//            txtSegundoNombre.setError(mensajeError.replace("$","Segundo Nombre"));
//            txtSegundoNombre.requestFocus();
//            return false;
//        }
        if(TextUtils.isEmpty(txtPrimerApellido.getText().toString()))
        {
            txtPrimerApellido.setError(mensajeError.replace("$","Primer Apellido"));
            txtPrimerApellido.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(txtSegundoApellido.getText().toString()))
        {
            txtSegundoApellido.setError(mensajeError.replace("$","Segundo Apellido"));
            txtSegundoApellido.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(txtnumIdentificacion.getText().toString()))
        {
            txtnumIdentificacion.setError(mensajeError.replace("$","Número Identificación"));
            txtnumIdentificacion.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(txtTelefono.getText().toString()))
        {
            txtTelefono.setError(mensajeError.replace("$","Teléfono"));
            txtTelefono.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(txtDireccion.getText().toString())) {
            txtDireccion.setError(mensajeError.replace("$", "Dirección"));
            txtDireccion.requestFocus();
            return false;
        }

        primerNombre = txtPrimerNombre.getText().toString().trim().toUpperCase();
        segundoNombre = txtSegundoNombre.getText().toString().trim().toUpperCase();
        primerApellido = txtPrimerApellido.getText().toString().trim().toUpperCase();
        segundoApellido = txtSegundoApellido.getText().toString().trim().toUpperCase();
        numIdentificacion = txtnumIdentificacion.getText().toString().trim();
        telefono = txtTelefono.getText().toString().trim();
        direccion = txtDireccion.getText().toString().trim().toUpperCase();

        return true;
    }

    private  boolean callServiceSavePadre(){

        return true;
    }
    // PUBLIC METHODS


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegistrarPadreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistrarPadreFragment newInstance(String param1, String param2) {
        RegistrarPadreFragment fragment = new RegistrarPadreFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    // IMPLEMENT METHODS
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
        View view = inflater.inflate(R.layout.fragment_registrar_padre, container, false);

//        progressBar = view.findViewById(R);
//        mProgressView = view.findViewById(R.id.);
        createPadreFormView = view.findViewById(R.id.form_create_padre);
        txtPrimerNombre = view.findViewById(R.id.inText_primer_nombre);
        txtSegundoNombre = view.findViewById(R.id.inText_segundo_nombre);
        txtPrimerApellido = view.findViewById(R.id.inText_primer_apellido);
        txtSegundoApellido = view.findViewById(R.id.inText_segundo_apellido);
        txtnumIdentificacion = view.findViewById(R.id.inText_num_identificacion);
        txtTelefono = view.findViewById(R.id.inText_num_telefono);
        txtDireccion = view.findViewById(R.id.inText_num_direccion);
        spinnerTipoIdentificacion = view.findViewById(R.id.inSpinner_tipo_identificacion);
        btnCrearPadre = view.findViewById(R.id.btn_guardar_padre);


        // action listener for botton create padre
        btnCrearPadre.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                boolean flagValidateCampos = false;
                boolean flagValidateServicesExecute = false;
                PadreDTO padreDTO = null;
                // validacion de campos
                if(validateInField())
                {
                    flagValidateServicesExecute = true;
                    padreDTO = new PadreDTO();
                    padreDTO.setPrimerNombre(primerNombre);
                    padreDTO.setSegundoNombre(segundoNombre);
                    padreDTO.setPrimerApellido(primerApellido);
                    padreDTO.setSegundoApellido(segundoApellido);
                    try {
                        Long identificacion = Long.parseLong(numIdentificacion);
                        padreDTO.setNumIdentificacion(identificacion);
                    }catch (Exception e)
                    {
                        e.getMessage();
                    }
//                    Long identificacion = Long.parseLong(numIdentificacion);
//                    padreDTO.setNumIdentificacion(Long.parseLong());
                    padreDTO.setTipoIdentificacion(3);
//                    padreDTO.setPassword();
                    padreDTO.setRol(2);
                    padreDTO.setUsuario("TAKURATOMI");
                    padreDTO.setFecha(new java.util.Date());
                    padreDTO.setTelefono(telefono);
                    padreDTO.setDireccion(direccion);
                    ServiceSavePadre serviceSavePadre = new ServiceSavePadre();
                    serviceSavePadre.setPadreDTO(padreDTO);
                    //execute service save padre.
                    if(flagValidateServicesExecute)
                    {
                        serviceSavePadre.execute();
                        try {
                            Thread.sleep(2500);
                        }catch (Exception e)
                        {

                        }
                        padreDTO = serviceSavePadre.getPadreDTO();
                        if(padreDTO.getCodigoError() == 0)
                        {
                            AlertaServicio alertaServicio = new AlertaServicio();
                            alertaServicio.setBarTitle("Venta De Comida");
                            alertaServicio.setMessage("Se guardo Satisfactoriamente");
                            alertaServicio.show(getFragmentManager(),"Alert1");
                        }
                        else
                        {
                            AlertaServicio alertaServicio = new AlertaServicio("Alerta Servicio",padreDTO.getMensajeError());
                            alertaServicio.show(getFragmentManager(),"AlertSer");
                        }

                    }
                    else{


                    }

                }else
                {

                }
            }
        });


        return view;
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


    // INTERFACE
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


    public class ServiceSavePadre extends AsyncTask<Boolean,Integer,Boolean>
    {

        // PROPIEDADES
        private PadreDTO padreDTO;
        private boolean flagEstateService = false;
        private String url = "";
        private RestTemplate restTemplate;

        // COSNTRUCTOR
        public ServiceSavePadre() {
            super();
        }

        public ServiceSavePadre(PadreDTO padreDTO) {
            this.padreDTO = padreDTO;
        }

        // GETTER & SETTER
        public PadreDTO getPadreDTO() {
            return padreDTO;
        }

        public void setPadreDTO(PadreDTO padreDTO) {
            this.padreDTO = padreDTO;
        }

        public boolean isFlagEstateService() {
            return flagEstateService;
        }

        public void setFlagEstateService(boolean flagEstateService) {
            this.flagEstateService = flagEstateService;
        }

        // IMPEMENTS METHODS
        @Override
        protected void onPreExecute() {

            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
        }

        @Override
        protected void onCancelled(Boolean aBoolean) {
            super.onCancelled(aBoolean);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected Boolean doInBackground(Boolean... booleans) {
            ServiceRest serviceRest = new ServiceRest();

            int rol = 0;
            restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            HttpEntity<PadreDTO> request = new HttpEntity<PadreDTO>(padreDTO);
            try {
                request = restTemplate.postForEntity(serviceRest.REGISTRARPADRE_POST_PADREDTO_PADREDTO,padreDTO,PadreDTO.class);
                return true;
            }catch (Exception e)
            {
                padreDTO = new PadreDTO();
                padreDTO.setCodigoError(91);
                padreDTO.setMensajeError("Error desconocido, consultar con el proveedor");
                return false;
            }
        }
    }
}
