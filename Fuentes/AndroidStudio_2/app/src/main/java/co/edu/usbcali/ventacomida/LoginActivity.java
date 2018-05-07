package co.edu.usbcali.ventacomida;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import co.edu.usbcali.dto.UsuarioDTO;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements LoaderCallbacks<Cursor> {

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;
    private static final String  ip= "192.168.1.16";

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };

    private UsuarioDTO usuarioDTO;

    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    private UserLoginTask mAuthTask = null;

    // UI references.
    private AutoCompleteTextView mIdentificacionlView;
    //private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mIdentificacionlView = (AutoCompleteTextView) findViewById(R.id.identificacion);
//        populateAutoComplete();

        Button mIdentificacionlSignInButton = (Button) findViewById(R.id.identificacion_sign_in_button);
        mIdentificacionlSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    /*
    * cambio de activity
    * */
    public void gotoActivity(int rol )
    {
        // admi
        if(rol == 1)
        {
//            Intent intent = new Intent(LoginActivity.this,VendedorActivity.class);
//            startActivity(intent);
        }
        // cliente
        else if(rol == 2)
        {
//            Intent intent = new Intent(LoginActivity.this,ClienteActivity.class);
//            startActivity(intent);
        }
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {

        // Reset errors.
        mIdentificacionlView.setError(null);
//        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mIdentificacionlView.getText().toString();
        //String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        /*if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }*/

        //Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mIdentificacionlView.setError(getString(R.string.error_field_required));
            focusView = mIdentificacionlView;
            cancel = true;
        }
        /*else if (!isEmailValid(email)) {
            mIdentificacionlView.setError(getString(R.string.error_invalid_email));
            focusView = mIdentificacionlView;
            cancel = true;
        }*/

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
//            servicesFabrica = new ServiceFabrica(ip);
            String url = "http://localhost:8080/ServicesVentaComida/controller/PadreRest/verificarDatosUsuario/".replace("localhost",ip);
//            VerificarDatosGetUsuario verificarDatosGetUsuario = new VerificarDatosGetUsuario(url);
//            Long id = Long.parseLong(email.toString().trim());
//            verificarDatosGetUsuario.execute(id);
//            UsuarioDTO usuarioDTO = verificarDatosGetUsuario.getResponse();
//            String temporal = "";
            mAuthTask = new UserLoginTask(email);
            //mAuthTask.execute((Void) null);
//            mAuthTask.doInBackground();
//            usuarioDTO = mAuthTask.getUsuarioDTO();
            if(usuarioDTO != null )
            {
                gotoActivity(usuarioDTO.getRol());
            }
            else
            {
                gotoActivity(1);
            }
        }
    }

    // validar si es correo
    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }
    // validar si es password con mas de 4 caractres
    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

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

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
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
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
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

    // validacion del consumo de servicio
//    public class VerificarDatosGetUsuario extends AsyncTask<Long,Integer,UsuarioDTO> {
//
//        String url;
//        UsuarioDTO response;
//
//        public VerificarDatosGetUsuario(String url) {
//            this.url = url;
//        }
//
//        @Override
//        protected UsuarioDTO doInBackground(Long... id) {
//            try {
//                String temporal = url+id[0].toString();
//
//                RestTemplate restTemplate = new RestTemplate();
//                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//                response= restTemplate.getForObject(url+id.toString(), UsuarioDTO.class);
//                return response;
//            } catch (Exception e) {
//                Log.e("MainActivity", e.getMessage(), e);
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(final Boolean success) {
//             = null;
//            showProgress(false);
//
//            if (success) {
//                finish();
//            } else {
//                mPasswordView.setError(getString(R.string.error_incorrect_password));
//                mPasswordView.requestFocus();
//            }
//        }
//
//
//        public UsuarioDTO getResponse() {
//            return response;
//        }
//
//        public void setResponse(UsuarioDTO response) {
//            this.response = response;
//        }
//    }


    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private UsuarioDTO usuarioDTO;

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
            // TODO: attempt authentication against a network service.

            String url = "http://192.168.1.16:8080/ServicesVentaComida/controller/PadreRest/verificarDatosUsuario/"+mEmail.trim();
            int rol = 0;
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            usuarioDTO = restTemplate.getForObject(url,UsuarioDTO.class);

            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

           /* for (String credential : DUMMY_CREDENTIALS) {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(mEmail)) {
                    // Account exists, return true if the password matches.
                    return pieces[1].equals(mPassword);
                }
            }*/

            // TODO: register the new account here.
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            //mAuthTask = null;
            showProgress(false);

            if (success) {
//               finish();
                gotoActivity(usuarioDTO.getRol());
            } else {
                mIdentificacionlView.setError(getString(R.string.error_invalid_identificacion));
                mIdentificacionlView.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }
}

