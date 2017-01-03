package pe.gob.minem.deam.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pe.gob.minem.deam.R;
import pe.gob.minem.deam.model.DenunciaEntity;

/**
 * Created by ronaldvelasquez on 10/12/16.
 */

public class RVDenunciaAdapter extends RecyclerView.Adapter<RVDenunciaAdapter.RVViewHolder> {
    private List<DenunciaEntity> list;

    public RVDenunciaAdapter() {
        this.list = new ArrayList<>();
    }

    public void addDenuncias(List<DenunciaEntity> denuncias) {
        list.clear();  // limpia la lista
        list.addAll(denuncias); // añade all el parametro a la lista
        notifyDataSetChanged(); // notifca al adaptador que ha habido cambios en la data y que tiene que refrescarse
    }

    @Override
    public RVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RVViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_denuncia, parent, false));
    }

    @Override
    public void onBindViewHolder(RVViewHolder holder, int position) {
        DenunciaEntity denuncia = list.get(position);
        holder.tvDenuncia.setText(denuncia.getTitulo());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RVViewHolder extends RecyclerView.ViewHolder {
        private TextView tvDenuncia;
        public RVViewHolder(View itemView) {
            super(itemView);
            tvDenuncia = (TextView) itemView.findViewById(R.id.tv_denuncia);
        }
    }
}
