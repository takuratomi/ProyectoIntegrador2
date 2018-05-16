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
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;

import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import co.edu.usbcali.ventacomida.alertas.AlertaServicio;
import co.edu.usbcali.ventacomida.dto.HijoDTO;
import co.edu.usbcali.ventacomida.dto.HijoDTO;
import co.edu.usbcali.ventacomida.services.ServiceRest;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegistrarHijoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RegistrarHijoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistrarHijoFragment extends Fragment {
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

    // UI REFERENCES
    private ProgressBar progressBar;
    private View mProgressView;
    private View createPadreFormView;
    private TextInputEditText txtPrimerNombre;
    private TextInputEditText txtSegundoNombre;
    private TextInputEditText txtPrimerApellido;
    private TextInputEditText txtSegundoApellido;
    private TextInputEditText txtnumIdentificacion;
    private TextInputEditText txtCurso;
    private TextInputEditText txtDireccion;
    private Spinner spinnerTipoIdentificacion;
    private Button btnCrearPadre;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public RegistrarHijoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegistrarHijoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistrarHijoFragment newInstance(String param1, String param2) {
        RegistrarHijoFragment fragment = new RegistrarHijoFragment();
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
        View view = inflater.inflate(R.layout.fragment_registrar_hijo, container, false);

        createPadreFormView = view.findViewById(R.id.form_create_hijo);
        txtPrimerNombre = view.findViewById(R.id.inText_primer_nombre_hijo);
        txtSegundoNombre = view.findViewById(R.id.inText_segundo_nombre_hijo);
        txtPrimerApellido = view.findViewById(R.id.inText_primer_apellido_hijo);
        txtSegundoApellido = view.findViewById(R.id.inText_segundo_apellido_hijo);
        txtnumIdentificacion = view.findViewById(R.id.inText_num_identificacion_hijo);
        txtCurso = view.findViewById(R.id.inText_curso_hijo);

        spinnerTipoIdentificacion = view.findViewById(R.id.inSpinner_tipo_identificacion_hijo);
        btnCrearPadre = view.findViewById(R.id.btn_guardar_hijo);

        // action listener for botton create padre
        btnCrearPadre.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                boolean flagValidateCampos = false;
                boolean flagValidateServicesExecute = false;
                HijoDTO hijoDTO= null;
                // validacion de campos
                if(validateInField())
                {
                    flagValidateServicesExecute = true;
                    hijoDTO = new HijoDTO();
                    hijoDTO.setPrimerNombre(primerNombre);
                    hijoDTO.setSegundoNombre(segundoNombre);
                    hijoDTO.setPrimerApellido(primerApellido);
                    hijoDTO.setSegundoApellido(segundoApellido);
                    try {
                        Long identificacion = Long.parseLong(numIdentificacion);
                        hijoDTO.setNumIdentificacion(identificacion);
                    }catch (Exception e)
                    {
                        e.getMessage();
                    }
//                    Long identificacion = Long.parseLong(numIdentificacion);
//                    HijoDTO.setNumIdentificacion(Long.parseLong());
                    hijoDTO.setTipoIdentificacion(3);
//                    HijoDTO.setPassword();
                    hijoDTO.setRol(2);
                    hijoDTO.setUsuario("TAKURATOMI");
                    hijoDTO.setFecha(new java.util.Date());
//                    hijoDTO.setCurso();
//                    hijoDTO.setFechaNacimiento();
                    ServiceSaveHijo serviceSaveHijo = new ServiceSaveHijo();
                    serviceSaveHijo.setHijoDTO(hijoDTO);
                    serviceSaveHijo.setHijoDTO(hijoDTO);
                    //execute service save padre.
                    if(flagValidateServicesExecute)
                    {
//                        serviceSavePadre.execute();
//                        try {
//                            Thread.sleep(2500);
//                        }catch (Exception e)
//                        {
//
//                        }
//                        HijoDTO = serviceSavePadre.getHijoDTO();
//                        if(HijoDTO.getCodigoError() == 0)
//                        {
//                            AlertaServicio alertaServicio = new AlertaServicio();
//                            alertaServicio.setBarTitle("Venta De Comida");
//                            alertaServicio.setMessage("Se guardo Satisfactoriamente");
//                            alertaServicio.show(getFragmentManager(),"Alert1");
//                        }
//                        else
//                        {
//                            AlertaServicio alertaServicio = new AlertaServicio("Alerta Servicio",HijoDTO.getMensajeError());
//                            alertaServicio.show(getFragmentManager(),"AlertSer");
//                        }

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


    private boolean validateInField()
    {
        String mensajeError = "El campo $ es obligatorio";
        if(TextUtils.isEmpty(txtPrimerNombre.getText().toString()))
        {
            txtPrimerNombre.setError(mensajeError.replace("$","Primer Nombre"));
            txtPrimerNombre.requestFocus();
            return false;
        }
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

        // pendiente de validacion de los atributos del objeto hijo


        primerNombre = txtPrimerNombre.getText().toString().trim().toUpperCase();
        segundoNombre = txtSegundoNombre.getText().toString().trim().toUpperCase();
        primerApellido = txtPrimerApellido.getText().toString().trim().toUpperCase();
        segundoApellido = txtSegundoApellido.getText().toString().trim().toUpperCase();
        numIdentificacion = txtnumIdentificacion.getText().toString().trim();

        return true;
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

    public class ServiceSaveHijo extends AsyncTask<Boolean,Integer,Boolean> {

        // PROPIEDADES
        private HijoDTO hijoDTO;
        private boolean flagEstateService = false;
        private String url = "";
        private RestTemplate restTemplate;

        // COSNTRUCTOR
        public ServiceSaveHijo() {
            super();
        }

        public ServiceSaveHijo(HijoDTO hijoDTO) {
            this.hijoDTO = hijoDTO;
        }

        // GETTER & SETTER
        public HijoDTO getHijoDTO() {
            return hijoDTO;
        }

        public void setHijoDTO(HijoDTO hijoDTO) {
            this.hijoDTO = hijoDTO;
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
            HttpEntity<HijoDTO> request = new HttpEntity<HijoDTO>(hijoDTO);
            try {
                request = restTemplate.postForEntity(serviceRest.REGISTRARHIJO_POST_HIJODTO_HIJODTO, hijoDTO, HijoDTO.class);
                return true;
            } catch (Exception e) {
                hijoDTO = new HijoDTO();
                hijoDTO.setCodigoError(91);
                hijoDTO.setMensajeError("Error desconocido, consultar con el proveedor");
                return false;
            }
        }
    }
}
