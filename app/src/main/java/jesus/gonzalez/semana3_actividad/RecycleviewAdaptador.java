package jesus.gonzalez.semana3_actividad;

import android.app.Activity;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecycleviewAdaptador extends RecyclerView.Adapter<RecycleviewAdaptador.ViewHolderDatos> {

    ArrayList<Mascotas> mascotasArray;

    public RecycleviewAdaptador(ArrayList<Mascotas> mascotasArray) {
        this.mascotasArray = mascotasArray;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mascotas_layout, null, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.asignarDatos(mascotasArray.get(position));
        final TextView tv_likes_counter = holder.tv_likes_counter.findViewById(R.id.tv_likes_counter);

        holder.imgv_bone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String get_text = tv_likes_counter.getText().toString();
                int text_to_integer = Integer.parseInt(get_text);

                // Max rating can be 5
                if(text_to_integer < 5) {
                    text_to_integer += 1;
                    tv_likes_counter.setText(String.valueOf(text_to_integer));
                } else {
                    tv_likes_counter.setText(String.valueOf(text_to_integer));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotasArray.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        private ImageView imgv_dog;
        private TextView tv_dog_name;
        private TextView tv_likes_counter;
        private ImageView imgv_bone;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            imgv_dog = itemView.findViewById(R.id.imgv_dog);
            tv_dog_name = itemView.findViewById(R.id.tv_dog_name);
            tv_likes_counter = itemView.findViewById(R.id.tv_likes_counter);
            imgv_bone = itemView.findViewById(R.id.imgv_bone);
        }

        public void asignarDatos(Mascotas mascotas) {
            imgv_dog.setImageResource(mascotas.getImagen());
            tv_dog_name.setText(mascotas.getNombre());
            tv_likes_counter.setText(String.valueOf(mascotas.getRating()));
        }
    }
}
