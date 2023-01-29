package com.example.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MensajesFragment extends Fragment {
    private TextView mSubject;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mensajes, container, false);
        mSubject = view.findViewById(R.id.subject);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String nombre = bundle.getString("nombre");
            mSubject.setText(nombre);
        }

        return view;
    }
}

