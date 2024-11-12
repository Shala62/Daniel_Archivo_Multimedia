package com.example.daniel_archivo_multimedia;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        VideoView video = findViewById(R.id.videoView);

        String videoURL = "https://drive.google.com/uc?export=download&id=1yoaEDgUuhDiVgQI3dp_zs8ysa9qfZ8R4";
        //Configurar MediaControler para proporcionar controles de reproduccion
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(video);
        video.setMediaController(mediaController);
        //Asignamos la fuente de datos para el vide
        video.setVideoURI(Uri.parse(videoURL));
        //Iniciamos la reproducción
        video.start();

        /*
        //Crear cadena de la ubicacion del video
        String videoCha = "android.resource://" + getPackageName() + "/" + R.raw.chacarron;

        //Crear el objeto URI a partir de la cadena
        Uri uri = Uri.parse(videoCha);

        //Establecer la fuente del video
        video.setVideoURI(uri);

        //Crear un objeto para proporcionar los controles de reproducción
        MediaController mediaController = new MediaController(this);
        //Asignar la visibilidad de los controles
        video.setMediaController(mediaController);
        //Especificar la vista en la cual se anclarán los controles
        mediaController.setAnchorView(video); */
    }
}