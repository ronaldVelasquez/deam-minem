package pe.gob.minem.deam.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

import pe.gob.minem.deam.R;

public class MapaActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        SupportMapFragment mapFragment = SupportMapFragment.newInstance(createGoogleMapOption());
        mapFragment.getMapAsync(this);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_mapa, mapFragment)
                .commit();
    }

    private GoogleMapOptions createGoogleMapOption() {
        GoogleMapOptions options = new GoogleMapOptions();
        options.zoomControlsEnabled(true);
//        options.maxZoomPreference(17.0f);
//        options.minZoomPreference(10.0f);
        options.rotateGesturesEnabled(false);
        return options;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.setMyLocationEnabled(true);
        LatLngBounds.Builder builder = new LatLngBounds.Builder();

        LatLng posicion = new LatLng(-12.075081, -77.000818);
        LatLng posicion2 = new LatLng(-12.1626434, -76.9932373);
        LatLng posicion3= new LatLng(-12.156576, -76.6545645);
        LatLng posicion4= new LatLng(-12.14576756, -76.4564564);

        googleMap.addMarker(new MarkerOptions().title("Mi posición").position(posicion));
        googleMap.addMarker(new MarkerOptions().title("Posición de la vecina").position(posicion2));
        builder.include(posicion);
        builder.include(posicion2);
        builder.include(posicion3);
        builder.include(posicion4);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 100));

        Polyline polyline = googleMap.addPolyline(new PolylineOptions()
        .add(posicion, posicion2, posicion3, posicion4)
        .width(4)
        .color(Color.BLUE));
    }
}
