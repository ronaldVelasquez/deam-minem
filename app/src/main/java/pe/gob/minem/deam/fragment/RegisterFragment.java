package pe.gob.minem.deam.fragment;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pe.gob.minem.deam.R;
import pe.gob.minem.deam.adapter.OpcionAdapter;
import pe.gob.minem.deam.db.DenunciaContract;
import pe.gob.minem.deam.db.DenunciasHelper;
import pe.gob.minem.deam.model.OpcionEntity;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {
    private EditText etName, etLastName;
    private Button btnRegistar;
    private RadioGroup rgrpDenuncia;
    private CheckBox chbxMotivo1, chbxMotivo2, chbxMotivo3;
    private Spinner spOpcion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        etName = (EditText) view.findViewById(R.id.et_name);
        etLastName = (EditText) view.findViewById(R.id.et_last_name);
        btnRegistar = (Button) view.findViewById(R.id.btn_registrar);
        rgrpDenuncia = (RadioGroup) view.findViewById(R.id.rgrp_denuncia);
        chbxMotivo1 = (CheckBox) view.findViewById(R.id.chbx_motivo_1);
        chbxMotivo2 = (CheckBox) view.findViewById(R.id.chbx_motivo_2);
        chbxMotivo3 = (CheckBox) view.findViewById(R.id.chbx_motivo_3);
        spOpcion = (Spinner) view.findViewById(R.id.spn_opcion);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<OpcionEntity> list = new ArrayList<>();
        list.add(new OpcionEntity(1, "Opcion 1", "Descripción de la opción 1"));
        list.add(new OpcionEntity(2, "Opcion 2", "Descripción de la opción 2"));
        list.add(new OpcionEntity(3, "Opcion 3", "Descripción de la opción 3"));
        list.add(new OpcionEntity(4, "Opcion 4", "Descripción de la opción 4"));
        list.add(new OpcionEntity(5, "Opcion 5", "Descripción de la opción 5"));
        OpcionAdapter opcionAdapter = new OpcionAdapter(list, getActivity());
        spOpcion.setAdapter(opcionAdapter);
        btnRegistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String radioSeleccionado = getOpcionSeleccionada2();
                if (radioSeleccionado == null) {
                    Toast.makeText(getActivity(),
                            "Selecciona una opcion",
                            Toast.LENGTH_SHORT).show();
                } else {
                    DenunciasHelper denunciasHelper = new DenunciasHelper(getActivity());
                    SQLiteDatabase db = denunciasHelper.getWritableDatabase();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(DenunciaContract.DenunciaEntry.COLUMN_NAME_TITLE, radioSeleccionado);
                    contentValues.put(DenunciaContract.DenunciaEntry.COLUMN_NAME_DESCRIPTION, radioSeleccionado + " descripcion");

                    long id = db.insert(DenunciaContract.DenunciaEntry.TABLE_NAME, null, contentValues);
                    if (id != 0) {
                        Toast.makeText(getActivity(),
                                "Se agrego un nuevo elemento en la tabla con id :  " + id,
                                Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_register, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private String getOpcionSeleccionada() {
        String respuesta = null;
        switch (rgrpDenuncia.getCheckedRadioButtonId()) {
            case R.id.rbtn_denuncia_ambiental:
                respuesta = "denuncia ambiental";
                break;
            case R.id.rbtn_denuncia_autoridad:
                respuesta = "denuncia autoridad";
                break;
            case R.id.rbtn_denuncia_territorial:
                respuesta = "denuncia territorial";
                break;
        }
        return respuesta;
    }

    private String getOpcionSeleccionada2() {
        String resultado = null;
        for (int i = 0; i < rgrpDenuncia.getChildCount(); i++) {
            if (rgrpDenuncia.getCheckedRadioButtonId() == rgrpDenuncia.getChildAt(i).getId()) {
                resultado = ((RadioButton) rgrpDenuncia.getChildAt(i)).getText().toString();
                return resultado;
            }
        }
        return null;
    }
}
