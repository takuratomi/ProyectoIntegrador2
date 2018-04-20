package co.edu.usbcali.ventacomida;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {

    Spinner spinnerCategoryProducto;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        spinnerCategoryProducto = findViewById(R.id.spinner_category_producto);

        ArrayList<String> losProductos = new ArrayList<>();
        losProductos = rellenarListaProductos(losProductos);
        // colocar lista en vista de elementos
        ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_list_item_1,losProductos);

        spinnerCategoryProducto.setAdapter(adaptador);


//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);


    }


    public ArrayList<String> rellenarListaProductos(ArrayList<String> lista)
    {
        if(lista != null)
        {
            lista = new ArrayList<String>();
            lista.add("SOPA");
            lista.add("PRINCIPIO");
            lista.add("PROTEINA");
            lista.add("BEBIDA");
        }

        return lista;
    }

}
