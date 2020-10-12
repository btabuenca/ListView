package es.upm.miw.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;

/**
 * @link https://developer.android.com/guide/topics/ui/declaring-layout#AdapterViews
 */
public class Adaptador extends ArrayAdapter {

    private Context contexto;
    private String[] datos;
    private int idRecursoLayout;

    /**
     * Constructor. This constructor will result in the underlying data collection being
     * immutable, so methods such as {@link #clear()} will throw an exception.
     *
     * @param context  The current context.
     * @param resource The resource ID for a layout file containing a TextView to use when
     *                 instantiating views.
     * @param objects  The objects to represent in the ListView.
     */
    public Adaptador(@NonNull Context context, int resource, @NonNull String[] objects) {
        super(context, resource, objects);
        this.contexto = context;
        this.idRecursoLayout = resource;
        this.datos = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LinearLayout vista;

        if (null != convertView) {
            vista = (LinearLayout) convertView;
        } else {
            LayoutInflater inflador = (LayoutInflater) contexto
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = (LinearLayout) inflador.inflate(idRecursoLayout, parent, false);
        }

        // Asignamos datos a los elementos de la vista
        TextView tvId = vista.findViewById(R.id.tvItemNumero); // acceso por nombre
        tvId.setText(String.format(Locale.getDefault(), "%2d", position));

        TextView tvTexto = (TextView) vista.getChildAt(2);  // acceso por posición
        tvTexto.setText(datos[position]);

        ImageView img = vista.findViewById(R.id.ivItemImagen);
        img.setImageResource(
                (position % 2 == 0)
                        ? R.mipmap.miw_launcher_rounded
                        : R.mipmap.miw_launcher
        );

        return vista;
    }

}
