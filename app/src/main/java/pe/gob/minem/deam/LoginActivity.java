package pe.gob.minem.deam;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    //    Declaracion de variables de vista
    public static final String NOMBRE = "usuario";
    public static final String PASSWORD = "password";
    private EditText etUsuario;
    private EditText etPassword;
    private TextView tvRecuperarPassword;
    private Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        Instanciar nuestros elementos de vista
        etUsuario = (EditText) findViewById(R.id.et_usuario);
        etPassword = (EditText) findViewById(R.id.et_password);
        tvRecuperarPassword = (TextView) findViewById(R.id.tv_recuperar_password);
        btnIngresar = (Button) findViewById(R.id.btn_ingresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarDatos();
            }
        });
    }

    private void validarDatos() {
        String usuario = etUsuario.getText().toString();
        String password = etPassword.getText().toString();

        if (usuario.equals("") || password.equals("")) {
            Toast.makeText(this, "Debe de rellenar todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            if (usuario.equals("pepito") && password.equals("12345")) {
                Toast.makeText(this, "Datos validados correctamente", Toast.LENGTH_SHORT).show();
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString(NOMBRE, usuario)
                        .putString(PASSWORD, password)
                        .apply();
                Intent varIntent = new Intent(this, MainActivity.class);
                varIntent.putExtra(MainActivity.USUARIO, usuario);
                startActivity(varIntent);
                finish();
            } else {
                Toast.makeText(this, "Usuario y/o contraseña incorrecto", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
