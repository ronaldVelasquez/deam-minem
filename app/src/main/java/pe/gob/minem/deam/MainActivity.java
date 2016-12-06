package pe.gob.minem.deam;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String USUARIO = "usuario";
    private TextView tvTitulo;
    private DrawerLayout dlDrawer;
    private Toolbar tbToolbar;
    private NavigationView nvNavigation;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTitulo = (TextView) findViewById(R.id.tv_titulo);
        dlDrawer = (DrawerLayout) findViewById(R.id.dl_drawer);
        tbToolbar = (Toolbar) findViewById(R.id.tb_toolbar);
        nvNavigation = (NavigationView) findViewById(R.id.nv_navigation);
        if (getIntent().getExtras() != null) {
            String usuario = getIntent().getStringExtra(USUARIO);
            tvTitulo.setText(usuario);
        }
        setupToolbar();
        setupNavigation();
//        Sirve para seleccionar el primer  elemento del menu
        if (savedInstanceState == null) {
            nvNavigation.getMenu().performIdentifierAction(R.id.nav_home, 0);
        }
    }

    private void setupToolbar() {
        tbToolbar.setTitle("Main");
        tbToolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.varColorBlanco));
        setSupportActionBar(tbToolbar);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setHomeAsUpIndicator(ContextCompat.getDrawable(this, R.drawable.ic_menu));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (dlDrawer.isDrawerOpen(GravityCompat.START)) {
                dlDrawer.closeDrawers();
            } else {
                dlDrawer.openDrawer(GravityCompat.START);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupNavigation() {
//        tvTitulo.setVisibility(View.VISIBLE);
        nvNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment varFragment = null;
                switch (item.getItemId()) {
                    case R.id.nav_home:
//                        tvTitulo.setText("Estoy en el home");
                        varFragment = new HomeFragment();
                        actionBar.setTitle("Inicio");
                        break;
//                   Agregar sus menus;
                    case R.id.nav_denuncia:
//                        tvTitulo.setText("Estoy en denuncias");
                        varFragment = new DenunciaFragment();
                        actionBar.setTitle("Denuncias");
                        break;
                    case R.id.nav_registro:
//                        tvTitulo.setText("Estoy en registro");
                        varFragment = new RegisterFragment();
                        actionBar.setTitle("Registro");
                        break;
                }
                MainActivity.this.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl_container, varFragment)
                        .commit();
                nvNavigation.setCheckedItem(item.getItemId());
                dlDrawer.closeDrawers();
                return true;
            }
        });
    }
}
