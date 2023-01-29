package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            // Usar un fragmento único para móvil
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new ChatSeletc())
                    .commit();
        } else {
            // Usar dos fragmentos para tablet
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_left, new ChatSeletc())
                    .replace(R.id.fragment_right, new MensajesFragment())
                    .commit();
        }


    }
}