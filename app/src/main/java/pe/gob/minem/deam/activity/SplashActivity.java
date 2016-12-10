package pe.gob.minem.deam.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import pe.gob.minem.deam.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Class varClass = null;
                String varNombre = PreferenceManager
                        .getDefaultSharedPreferences(SplashActivity.this)
                        .getString(LoginActivity.NOMBRE, null);
                varClass = TextUtils.isEmpty(varNombre) ? LoginActivity.class : MainActivity.class;
                Intent varIntent = new Intent(SplashActivity.this, varClass);
                if (!TextUtils.isEmpty(varNombre)) {
                    varIntent.putExtra(MainActivity.USUARIO, varNombre);
                }
                startActivity(varIntent);
                finish();
            }
        }, 2000);
    }
}
