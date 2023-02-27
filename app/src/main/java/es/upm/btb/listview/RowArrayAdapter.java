package es.upm.btb.listview;

import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RowArrayAdapter extends ArrayAdapter<RowItem> {
    Context context;

    public RowArrayAdapter(Context context, int resourceId, List<RowItem> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    private class RowItemHolder {
        ImageView imageView;
        TextView txtName;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        RowItemHolder holder = null;
        RowItem rowItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.row_item, null);
            holder = new RowItemHolder();

            holder.txtName = (TextView) convertView.findViewById(R.id.textView);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
        } else
            holder = (RowItemHolder) convertView.getTag();


        holder.txtName.setText(rowItem.getName());
        holder.imageView.setImageResource(rowItem.getImageId());

        return convertView;
    }
}
