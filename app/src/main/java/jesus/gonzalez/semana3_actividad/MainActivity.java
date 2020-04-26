package jesus.gonzalez.semana3_actividad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascotas> mascotas;

    private RecyclerView recycler;
    private RecyclerView.Adapter mascotaAdaptador;
    private RecyclerView.LayoutManager layoutManagerMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Action bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);

        // Recycler view
        recycler = (RecyclerView) findViewById(R.id.rv_mascotas);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mascotas = new ArrayList<Mascotas>();
        mascotas.add(new Mascotas("Bruce Lee", 0, R.drawable.perro_1));
        mascotas.add(new Mascotas("Jackie Chan", 0, R.drawable.perro_2));
        mascotas.add(new Mascotas("Conor McGregor", 0, R.drawable.perro_3));
        mascotas.add(new Mascotas("Saenchai Pk", 0, R.drawable.perro_4));
        mascotas.add(new Mascotas("Royce Gracie", 0, R.drawable.perro_5));

        RecycleviewAdaptador adapter = new RecycleviewAdaptador(mascotas);
        recycler.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_favorite) {
            Intent intent = new Intent(MainActivity.this, MascotasMasRating.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
