package es.upm.btb.listview;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemClickListener {

    public static final String[] names = new String[] { "Alonso Quijano",
            "Dulcinea del Toboso", "Sancho Panza", "Rocinante", "Clavileño" };
    public static final Integer[] images = { R.drawable.q1,
            R.drawable.q2, R.drawable.q3, R.drawable.q4, R.drawable.q5 };

    private ListView listView;
    List<RowItem> rowItems;
    private ArrayAdapter<RowItem> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < names.length; i++) {
            RowItem item = new RowItem(names[i], images[i]);
            rowItems.add(item);
        }

        listView = (ListView) findViewById(R.id.listView);
        RowArrayAdapter adapter = new RowArrayAdapter(this,
                R.layout.row_item, rowItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Item " + (position + 1) + ": " + rowItems.get(position),
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }
}