package es.upm.miw.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    static final String TAG_MIW = "MiW";

    private ListView lvListado;

    final static String CLAVE_ID = "CLAVE_ID";
    final static String CLAVE_OPCION = "CLAVE_OPCIÓN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // asociar recurso a la vista
        lvListado = findViewById(R.id.lvListadoElementos);

        // Crear adaptador a partir de datos
        Adaptador adaptador = new Adaptador(
                this,
                R.layout.item_lista,
                getResources().getStringArray(R.array.misDatos)
        );

        lvListado.setAdapter(adaptador);
        lvListado.setOnItemClickListener(this);
    }

    /**
     * Callback method to be invoked when an item in this AdapterView has
     * been clicked.
     * <p>
     * Implementers can call getItemAtPosition(position) if they need
     * to access the data associated with the selected item.
     *
     * @param parent   The AdapterView where the click happened.
     * @param view     The view within the AdapterView that was clicked (this
     *                 will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id       The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String texto = "Opción elegida (" +
                position +
                "): " +
                parent.getItemAtPosition(position).toString();
        Log.i(TAG_MIW, texto);

        Bundle bundle = new Bundle();
        bundle.putInt(CLAVE_ID, position);
        bundle.putString(CLAVE_OPCION, parent.getItemAtPosition(position).toString());

        Intent intent = new Intent(getApplicationContext(), MuestraDetalleActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
