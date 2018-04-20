package co.edu.usbcali.ventacomida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ConsultarProductosActivity extends AppCompatActivity {

    ListView losProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_productos);

        losProductos = findViewById(R.id.losProductos);

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,R.array.lstProductos, android.R.layout.simple_list_item_1);
        losProductos.setAdapter(adaptador);
    }
}
