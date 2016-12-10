package pe.gob.minem.deam;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class DenunciaFragment extends Fragment {

    private RecyclerView rvDenuncias;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_denuncia, container, false);
        rvDenuncias = (RecyclerView) view.findViewById(R.id.rv_denuncias);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_denuncia, menu);
        super.onCreateOptionsMenu(menu, inflater);
        List<DenunciaEntity> list = new ArrayList<>();
        list.add(new DenunciaEntity(1, "Denuncia 1", "Descripcion 1", "Marco", "Polo"));
        list.add(new DenunciaEntity(2, "Denuncia 2", "Descripcion 2", "Marco", "Polo"));
        list.add(new DenunciaEntity(3, "Denuncia 3", "Descripcion 3", "Marco", "Polo"));
        list.add(new DenunciaEntity(4, "Denuncia 4", "Descripcion 4", "Marco", "Polo"));
        list.add(new DenunciaEntity(5, "Denuncia 5", "Descripcion 5", "Marco", "Polo"));
        list.add(new DenunciaEntity(6, "Denuncia 6", "Descripcion 6", "Marco", "Polo"));
        list.add(new DenunciaEntity(7, "Denuncia 7", "Descripcion 7", "Marco", "Polo"));
        RVDenunciaAdapter adapter = new RVDenunciaAdapter(list);
        rvDenuncias.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rvDenuncias.setAdapter(adapter);

    }
}
