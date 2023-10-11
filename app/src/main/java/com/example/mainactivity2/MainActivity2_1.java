package com.example.mainactivity2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main21);

        Button facebookButton = findViewById(R.id.Facebook);
        Button googleButton = findViewById(R.id.Google);
        Button callButton = findViewById(R.id.llamada);
        Button ajustesButton = findViewById(R.id.ajustes);
        Button cameraButton = findViewById(R.id.camara);
        Button youtubeButton = findViewById(R.id.youtube);
        Button spotifyButton = findViewById(R.id.spotify);
        Button mensajeButton = findViewById(R.id.Mensaje);

        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = getPackageManager().getLaunchIntentForPackage("com.facebook.katana");
                    if (intent != null) {
                        startActivity(intent);
                    } else {
                        Uri uri = Uri.parse("https://www.facebook.com");
                        Intent webIntent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(webIntent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Uri uri = Uri.parse("https://www.google.com");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:8713700725"));
                    startActivity(callIntent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        ajustesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent settingsIntent = new Intent(android.provider.Settings.ACTION_SETTINGS);
                    startActivity(settingsIntent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(cameraIntent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        youtubeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent youtubeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com"));
                    startActivity(youtubeIntent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        spotifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent spotifyIntent = getPackageManager().getLaunchIntentForPackage("com.spotify.music");
                    if (spotifyIntent != null) {
                        startActivity(spotifyIntent);
                    } else {
                        Uri uri = Uri.parse("https://www.spotify.com");
                        Intent webIntent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(webIntent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        mensajeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Asunto del mensaje (opcional)");
                    intent.putExtra(Intent.EXTRA_TEXT, "Este es mi mensaje de ejemplo.");

                    startActivity(Intent.createChooser(intent, "Enviar mensaje"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
