package pe.gob.minem.deam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import pe.gob.minem.deam.R;
import pe.gob.minem.deam.model.OpcionEntity;

/**
 * Created by ronaldvelasquez on 10/12/16.
 */

public class OpcionAdapter extends BaseAdapter {
    private List<OpcionEntity> list;
    private LayoutInflater layoutInflater;
    public OpcionAdapter(List<OpcionEntity> list, Context context) {
        this.list = list;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public OpcionEntity getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_opcion, null);
            viewHolder = new ViewHolder();
            viewHolder.tvTitulo = (TextView) view.findViewById(R.id.tv_titulo);
            viewHolder.tvDescripcion = (TextView) view.findViewById(R.id.tv_descripcion);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.tvTitulo.setText(list.get(i).getTitulo());
        viewHolder.tvDescripcion.setText(list.get(i).getDesripcion());
        return view;
    }

    public static class ViewHolder {
        TextView tvTitulo;
        TextView tvDescripcion;
    }
}
