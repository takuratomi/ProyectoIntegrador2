package co.edu.usbcali.ventacomida;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import co.edu.usbcali.ventacomida.alertas.AlertaServicio;
import co.edu.usbcali.ventacomida.dto.UsuarioDTO;
import co.edu.usbcali.ventacomida.services.ServiceRest;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements LoaderCallbacks<Cursor> {

    // UI REFERENCES
    private AutoCompleteTextView mIdentificacionlView;
    private View mProgressView;
    private View mLoginFormView;
    private AlertaServicio alertaServicio;
    private boolean responseService = false;

    // VARS
    private UserLoginTask mAuthTask = null;
    private UsuarioDTO usuarioDTO = null;

    // CONSTRUCTORS

    // PUBLIC

    // IMPLEMENTS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mIdentificacionlView = (AutoCompleteTextView) findViewById(R.id.identificacion);
        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);

        Button mIdentificacionlSignInButton = (Button) findViewById(R.id.identificacion_sign_in_button);
        mIdentificacionlSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.

        if(show)
        {
            mProgressView.setVisibility(View.VISIBLE);
            mLoginFormView.setVisibility(View.GONE);
        }
        else
        {
            mProgressView.setVisibility(View.GONE);
            mLoginFormView.setVisibility(View.VISIBLE);
        }

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
//            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
//
//            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
//            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
//                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
//                @Override
//                public void onAnimationEnd(Animator animation) {
//                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
//                }
//            });
//
//            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
//            mProgressView.animate().setDuration(shortAnimTime).alpha(
//                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
//                @Override
//                public void onAnimationEnd(Animator animation) {
//                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
//                }
//            });
//        } else {
//            // The ViewPropertyAnimator APIs are not available, so simply show
//            // and hide the relevant UI components.
//            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
//            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
//        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this,
                // Retrieve data rows for the device user's 'profile' contact.
                Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI,
                        ContactsContract.Contacts.Data.CONTENT_DIRECTORY), ProfileQuery.PROJECTION,

                // Select only email addresses.
                ContactsContract.Contacts.Data.MIMETYPE +
                        " = ?", new String[]{ContactsContract.CommonDataKinds.Email
                .CONTENT_ITEM_TYPE},

                // Show primary email addresses first. Note that there won't be
                // a primary email address if the user hasn't specified one.
                ContactsContract.Contacts.Data.IS_PRIMARY + " DESC");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        List<String> emails = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            emails.add(cursor.getString(ProfileQuery.ADDRESS));
            cursor.moveToNext();
        }
        addEmailsToAutoComplete(emails);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {

    }

    //UTILS METHODS

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {

        // vars
        boolean cancel = false;
        View focusView = null;

        // Reset errors.
        mIdentificacionlView.setError(null);

        // Store values at the time of the login attempt.
        String email = mIdentificacionlView.getText().toString();

        // VALIDATIONS
        //Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mIdentificacionlView.setError(getString(R.string.error_field_required));
            focusView = mIdentificacionlView;
            cancel = true;
        } else if (!TextUtils.isDigitsOnly(email)) {
            mIdentificacionlView.setError("Solo se aceptan valores numericos");
            focusView = mIdentificacionlView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            mAuthTask = new UserLoginTask(email);
            mAuthTask.execute((Void) null);

//            Log.d("temporal", "Salida del bucle del servicio");
//
//            showProgress(true);
//            try {
//                Thread.sleep(4000);
//
//            } catch (InterruptedException e) {
//            }

//            usuarioDTO = mAuthTask.getUsuarioDTO();
//
//
//            // servicio funciono de forma satisfactoria
//            if (mAuthTask.statusServices) {
//                usuarioDTO = mAuthTask.getUsuarioDTO();
//                mAuthTask = null;
//
//                // para pruebas
//                if (email.equals("1")) {
//                    gotoActivity(1);
//                } else if (email.equals("2")) {
//                    gotoActivity(2);
//                } else if (usuarioDTO == null) {
//                    mIdentificacionlView.findFocus();
//                    showProgress(false);
//                    Toast toast = Toast.makeText(getApplicationContext(), "Ocurrio un error en la conexión", Toast.LENGTH_SHORT);
//                    toast.show();
//                }
//                //  inicio de activity correspondiente segun el rol
//                else if (usuarioDTO != null && usuarioDTO.getCodigoError() == 0) {
//                    gotoActivity(usuarioDTO.getRol());
//                } else if (usuarioDTO != null && usuarioDTO.getCodigoError() == 91) {
//                    mIdentificacionlView.findFocus();
//                    showProgress(false);
//                    Toast toast = Toast.makeText(getApplicationContext(), usuarioDTO.getMensajeError(), Toast.LENGTH_SHORT);
//                    toast.show();
//                }
//            } else // servicio fallo
//            {
//                usuarioDTO = mAuthTask.getUsuarioDTO();
//                mAuthTask = null;
//                showProgress(false);
//
//                alertaServicio = new AlertaServicio("Alerta De Servicio", "Ocurrio Un error en conexion volver a intentarlo");
//                alertaServicio.show(getSupportFragmentManager(), "tagAlerta");
//            }
        }
    }

    /**
     *
     *
     *
     * @param
     */
    public void  selectedUser(String email){
    // servicio funciono de forma satisfactoria
            if(mAuthTask.statusServices)

    {
        usuarioDTO = mAuthTask.getUsuarioDTO();
        mAuthTask = null;

        // para pruebas
        if (email.equals("1")) {
            gotoActivity(1);
        } else if (email.equals("2")) {
            gotoActivity(2);
        } else if (usuarioDTO == null) {
            mIdentificacionlView.findFocus();
            showProgress(false);
            Toast toast = Toast.makeText(getApplicationContext(), "Ocurrio un error en la conexión", Toast.LENGTH_SHORT);
            toast.show();
        }
        //  inicio de activity correspondiente segun el rol
        else if (usuarioDTO != null && usuarioDTO.getCodigoError() == 0) {
            gotoActivity(usuarioDTO.getRol());
        } else if (usuarioDTO != null && usuarioDTO.getCodigoError() == 91) {
            mIdentificacionlView.findFocus();
            showProgress(false);
            Toast toast = Toast.makeText(getApplicationContext(), usuarioDTO.getMensajeError(), Toast.LENGTH_SHORT);
            toast.show();
        }
    }
            else // servicio fallo

    {
        usuarioDTO = mAuthTask.getUsuarioDTO();
        mAuthTask = null;
        showProgress(false);

        alertaServicio = new AlertaServicio("Alerta De Servicio", "Ocurrio Un error en conexion volver a intentarlo");
        alertaServicio.show(getSupportFragmentManager(), "tagAlerta");
    }
}

    /**
     *
     * Function para validar el proceso del servicio
     * @param
     */


    /*
     * cambio de activity
     * */
    public void gotoActivity(int rol )
    {
        // admi
        if(rol == 1)
        {
            Intent intent = new Intent(LoginActivity.this,AdminActivity.class);
            startActivity(intent);
            finish();
        }
        // cliente
        else if(rol == 2)
        {
            Intent intent = new Intent(LoginActivity.this,ClienteActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void addEmailsToAutoComplete(List<String> emailAddressCollection) {
        //Create adapter to tell the AutoCompleteTextView what to show in its dropdown list.
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(LoginActivity.this,
                        android.R.layout.simple_dropdown_item_1line, emailAddressCollection);

        mIdentificacionlView.setAdapter(adapter);
    }


    private interface ProfileQuery {
        String[] PROJECTION = {
                ContactsContract.CommonDataKinds.Email.ADDRESS,
                ContactsContract.CommonDataKinds.Email.IS_PRIMARY,
        };

        int ADDRESS = 0;
        int IS_PRIMARY = 1;
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private UsuarioDTO usuarioDTO;
        ServiceRest serviceRest;
        int time = 0;

        public boolean statusServices = false;

        UserLoginTask(String email) {
            mEmail = email;
        }

        public UsuarioDTO getUsuarioDTO() {
            return usuarioDTO;
        }

        public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
            this.usuarioDTO = usuarioDTO;
        }


        @Override
        protected Boolean doInBackground(Void... params) {

            serviceRest = new ServiceRest();
            String url = serviceRest.VERIFICARDATOSUSUARIO_GET_LONG_USUARIODTO+mEmail.trim();
            RestTemplate restTemplate = new RestTemplate();

            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            try {


                if(mEmail.equals("1") || mEmail.equals("2"))
                {
                    statusServices = true;
                }
                else {
                    usuarioDTO = restTemplate.getForObject(url, UsuarioDTO.class);

                    if(usuarioDTO != null && usuarioDTO.getCodigoError() != 0)
                    {
                        statusServices = false;
                    }
                    else if(usuarioDTO != null && usuarioDTO.getCodigoError() == 0)
                    {
                        statusServices = true;
                    }
                }


            }catch (Exception e)
            {
                statusServices = false;
                serviceRest = null;
            }
            return statusServices;
        }

        @Override
        protected void onPostExecute(final Boolean success) {

            if(success)
            {
                nn(mEmail);
            }
            else{
                showProgress(false);
                if(usuarioDTO != null && usuarioDTO.getMensajeError() != null && !usuarioDTO.getMensajeError().equals(""))
                {
                    alertaServicio = new AlertaServicio("Alerta De Servicio", ""+usuarioDTO.getMensajeError());
                    alertaServicio.show(getSupportFragmentManager(), "tagAlerta");
                }
                else
                {
                    alertaServicio = new AlertaServicio("Alerta De Servicio", "Ocurrio Un error en conexion volver a intentarlo. ");
                    alertaServicio.show(getSupportFragmentManager(), "tagAlerta");
                }
            }

        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }


        public void nn(String email)
        {
            // para pruebas
            if (email.equals("1")) {
                gotoActivity(1);
            } else if (email.equals("2")) {
                gotoActivity(2);
            } else if (usuarioDTO == null) {
                mIdentificacionlView.findFocus();
                showProgress(false);
                Toast toast = Toast.makeText(getApplicationContext(), "Ocurrio un error en la conexión", Toast.LENGTH_SHORT);
                toast.show();
            }
            //  inicio de activity correspondiente segun el rol
            else if (usuarioDTO.getCodigoError() == 91) {
                mIdentificacionlView.findFocus();
                showProgress(false);
                Toast toast = Toast.makeText(getApplicationContext(),""+usuarioDTO.getMensajeError(), Toast.LENGTH_SHORT);
                toast.show();
            }
            else if (usuarioDTO != null && usuarioDTO.getCodigoError() == 0) {
                gotoActivity(usuarioDTO.getRol());
            }
        }

    }
}

