package co.edu.usbcali.ventacomida.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import co.edu.usbcali.ventacomida.R;
import co.edu.usbcali.ventacomida.dto.HijoDTO;
import co.edu.usbcali.ventacomida.dto.ProductoDTO;

/**
 * Created by takuratomi on 21/04/18.
 */

public class AdapterProductos extends BaseAdapter {

    private Context context;
    private List<ProductoDTO> listaProductos;
    private Map<String, ProductoDTO> listSelected;


    public AdapterProductos(Context context, List<ProductoDTO> listaProductos) {
        this.context = context;
        this.listaProductos = listaProductos;
    }

    public AdapterProductos(Context context, List<ProductoDTO> listaProductos, Map<String, ProductoDTO> listSelected) {
        this.context = context;
        this.listaProductos = listaProductos;
        this.listSelected = listSelected;
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

        final TextView txtView_id = (TextView) vista.findViewById(R.id.textView_id);
        TextView txtView_nombre = (TextView) vista.findViewById(R.id.textView_nombre);
        TextView txtView_descripcion = (TextView) vista.findViewById(R.id.textView_descripcion);
        TextView txtView_estado = (TextView) vista.findViewById(R.id.textView_estado);
        final CheckedTextView checkedTextView = (CheckedTextView) vista.findViewById(R.id.checkedtextview);

        checkedTextView.setId(i);
        final int position = i;

        checkedTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkedTextView.isChecked())
                {
                    checkedTextView.setChecked(true);
                    Log.d("selected","true");
                    listSelected.put(listaProductos.get(position).getId().toString(), listaProductos.get(position));
                }else{

                    checkedTextView.setChecked(false);
                    Log.d("selected","false");
                    listSelected.remove(listaProductos.get(position).getId().toString());
                }
            }

        });

        txtView_id.setText(listaProductos.get(i).getId().toString());
        txtView_nombre.setText(listaProductos.get(i).getNombre().toString());
        txtView_descripcion.setText(listaProductos.get(i).getDescripcion());
        txtView_estado.setText(listaProductos.get(i).getEstado());

        return vista;
    }

    public Map<String, ProductoDTO> getListSelected() {
        
        if(listSelected != null || listSelected.size() > 0 )
        {
            for (Map.Entry<String, ProductoDTO> entry : listSelected.entrySet()) {
                Log.d("selected", "Producto id :" + entry.getKey() + "  value " + entry.getValue());
            }
        }
        
        return listSelected;
    }

    public List<HijoDTO> getProductos()
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View vista = inflater.inflate(R.layout.list_consultar_producto,null);


        return null;
    }


    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
