package pe.gob.minem.deam.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import pe.gob.minem.deam.R;
import pe.gob.minem.deam.adapter.RVDenunciaAdapter;
import pe.gob.minem.deam.rest.ApiClient;
import pe.gob.minem.deam.rest.response.ListDenunciaResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DenunciaFragment extends Fragment {

    private RecyclerView rvDenuncias;
    private RVDenunciaAdapter adapter;
    private ProgressBar progress;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_denuncia, container, false);
        rvDenuncias = (RecyclerView) view.findViewById(R.id.rv_denuncias);
        progress = (ProgressBar) view.findViewById(R.id.progress) ;
        adapter = new RVDenunciaAdapter();
        rvDenuncias.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rvDenuncias.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Call<ListDenunciaResponse> call = ApiClient.getServiceApiClient().getDenuncias();
        call.enqueue(new Callback<ListDenunciaResponse>() {
            @Override
            public void onResponse(Call<ListDenunciaResponse> call, Response<ListDenunciaResponse> response) {
                progress.setVisibility(View.GONE);
                rvDenuncias.setVisibility(View.VISIBLE);
                if (response.isSuccessful()) {
                    adapter.addDenuncias(response.body().getListDenuncia());
                } else {
                    Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ListDenunciaResponse> call, Throwable t) {
                progress.setVisibility(View.GONE);
                rvDenuncias.setVisibility(View.VISIBLE);
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_denuncia, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
