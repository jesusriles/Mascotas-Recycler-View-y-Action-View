package jesus.gonzalez.semana3_actividad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MascotasMasRating extends AppCompatActivity {

    ArrayList<Mascotas> mascotas;

    private RecyclerView recycler;
    private RecyclerView.Adapter mascotaAdaptador;
    private RecyclerView.LayoutManager layoutManagerMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_mas_rating);

        // Action bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Recycler view
        recycler = (RecyclerView) findViewById(R.id.rv_mascotas_rating);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mascotas = new ArrayList<Mascotas>();
        mascotas.add(new Mascotas("Royce Gracie", 5, R.drawable.perro_5));
        mascotas.add(new Mascotas("Saenchai Pk", 5, R.drawable.perro_4));
        mascotas.add(new Mascotas("Conor McGregor", 3, R.drawable.perro_3));
        mascotas.add(new Mascotas("Jackie Chan", 2, R.drawable.perro_2));
        mascotas.add(new Mascotas("Bruce Lee", 2, R.drawable.perro_1));

        RecycleviewAdaptador adapter = new RecycleviewAdaptador(mascotas);
        recycler.setAdapter(adapter);
    }
}
