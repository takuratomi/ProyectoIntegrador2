package co.edu.usbcali.ventacomida.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import co.edu.usbcali.ventacomida.R;
import co.edu.usbcali.ventacomida.dto.ProductoDTO;

/**
 * Created by takuratomi on 21/04/18.
 */

public class AdapterProductos extends BaseAdapter {

    Context context;
    List<ProductoDTO> listaProductos;


    public AdapterProductos(Context context, List<ProductoDTO> listaProductos) {
        this.context = context;
        this.listaProductos = listaProductos;
    }

    @Override
    public int getCount() {
        return listaProductos.size();
    }

    @Override
    public Object getItem(int i) {
        return listaProductos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return Long.parseLong(listaProductos.get(i).getId().toString());
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vista ;
        LayoutInflater inflater = LayoutInflater.from(context);
        vista = inflater.inflate(R.layout.list_consultar_producto,null);

        TextView txtView_id = (TextView) vista.findViewById(R.id.textView_id);
        TextView txtView_nombre = (TextView) vista.findViewById(R.id.textView_nombre);

        int tamano = listaProductos.size();
        String id = listaProductos.get(i).getId().toString();
        String nombre = listaProductos.get(i).getNombre().toString();


        txtView_id.setText(id);
        txtView_nombre.setText(nombre);

        return vista;
//        return null;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
