package pe.gob.minem.deam.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import pe.gob.minem.deam.R;
import pe.gob.minem.deam.activity.MapaActivity;
import pe.gob.minem.deam.rest.ApiClient;
import pe.gob.minem.deam.rest.response.BaseResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private EditText etNombre;
    private EditText etTitulo;
    private EditText etDescripcion;
    private Button btnEnviar;
    private Button btnMapa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_home, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void initView(View view) {
        etNombre = (EditText) view.findViewById(R.id.et_nombre);
        etTitulo = (EditText) view.findViewById(R.id.et_titulo);
        etDescripcion = (EditText) view.findViewById(R.id.et_descripcion);
        btnEnviar = (Button) view.findViewById(R.id.btn_enviar);
        btnMapa = (Button) view.findViewById(R.id.btn_mapa);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = etNombre.getText().toString().trim();
                String titulo = etTitulo.getText().toString().trim();
                String descripcion = etDescripcion.getText().toString().trim();
                if (TextUtils.isEmpty(nombre) || TextUtils.isEmpty(titulo) || TextUtils.isEmpty(descripcion)) {
                    Toast.makeText(getContext(), "Falta llenar campos", Toast.LENGTH_SHORT).show();
                } else {
                    HashMap<String, Object> params = new HashMap<String, Object>();
                    params.put("titulo", titulo);
                    params.put("nombre", nombre);
                    params.put("descripcion", descripcion);
                    Call<BaseResponse<Object>> call = ApiClient.getServiceApiClient().sendDenuncia(params);
                    call.enqueue(new Callback<BaseResponse<Object>>() {
                        @Override
                        public void onResponse(Call<BaseResponse<Object>> call, Response<BaseResponse<Object>> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(getContext(), "Se guardo el registro correctamente", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<BaseResponse<Object>> call, Throwable t) {
                            Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), MapaActivity.class));
            }
        });
    }
}
