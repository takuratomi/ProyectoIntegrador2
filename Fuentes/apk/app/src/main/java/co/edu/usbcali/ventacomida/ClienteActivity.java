package co.edu.usbcali.ventacomida;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class ClienteActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        RegistrarHijoFragment.OnFragmentInteractionListener,
        ConsultarMisHijosFragment.OnFragmentInteractionListener,
        AboutFragment.OnFragmentInteractionListener,
        CrearPedido.OnFragmentInteractionListener
        {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.cliente, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        boolean fragmentSelection = false;

        //Seleccion de fragment
        if (id == R.id.nav_registrar_hijo) {

            fragment =  new RegistrarHijoFragment();
            fragmentSelection = true;

        }
        else if(id == R.id.nav_about_cliente)
        {
            fragment =  new AboutFragment();
            fragment.setArguments(getIntent().getBundleExtra("_bundleUsuario"));
            fragmentSelection = true;
        }
        else if(id == R.id.nav_consultar_hijo)
        {
            fragment =  new ConsultarMisHijosFragment();
            fragment.setArguments(getIntent().getBundleExtra("_bundleUsuario"));
            fragmentSelection = true;
        }
        else if(id == R.id.nav_crear_pedido_hijo)
        {
            fragment =  new CrearPedido();
            fragment.setArguments(getIntent().getBundleExtra("_bundleUsuario"));
            fragmentSelection = true;
        }
        else if (id == R.id.nav_salir) {

            Intent intent = new Intent(ClienteActivity.this,LoginActivity.class);
            startActivity(intent);
            fragmentSelection = false;
            finish();
        }

        // se remplaza el fragmant que se encuentra abierto por el seleccionado
        if(fragmentSelection)
        {

            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_cliente,fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
