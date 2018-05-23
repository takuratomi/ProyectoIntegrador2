package co.edu.usbcali.ventacomida.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
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

        LayoutInflater inflater = LayoutInflater.from(context);
        View vista = inflater.inflate(R.layout.list_consultar_producto,null);

        TextView txtView_id = (TextView) vista.findViewById(R.id.textView_id);
        TextView txtView_nombre = (TextView) vista.findViewById(R.id.textView_nombre);
        TextView txtView_descripcion = (TextView) vista.findViewById(R.id.textView_descripcion);
        TextView txtView_estado = (TextView) vista.findViewById(R.id.textView_estado);
//        CheckBox checkBox_selected = (CheckBox) vista.findViewById(R.id.checkbox_estatus);

        txtView_id.setText(listaProductos.get(i).getId().toString());
        txtView_nombre.setText(listaProductos.get(i).getNombre().toString());
        txtView_descripcion.setText(listaProductos.get(i).getDescripcion());
        txtView_estado.setText(listaProductos.get(i).getEstado());
//        checkBox_selected.setChecked(true);

        return vista;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
