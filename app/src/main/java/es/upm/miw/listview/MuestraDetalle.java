package es.upm.miw.listview;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Locale;

public class MuestraDetalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_item);

        // Recupero el recurso asociado en la vista
        TextView tvIdentificador = findViewById(R.id.tvMostrarId);
        TextView tvTexto = findViewById(R.id.tvMostrarTexto);

        // Recupero el bundle con los datos
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            int idRecibido        = bundle.getInt(MainActivity.CLAVE_ID);
            String opcionRecibida = bundle.getString(MainActivity.CLAVE_OPCION);

            // Asignar datos en la vista
            tvIdentificador.setText(String.format(Locale.getDefault(), "%2d", idRecibido));
            tvTexto.setText(opcionRecibida);
        }

        // Mostrar el icono back en la ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        setResult(RESULT_OK);
        // finish();
    }
}
