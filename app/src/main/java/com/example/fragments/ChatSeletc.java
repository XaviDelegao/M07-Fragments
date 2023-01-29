package com.example.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ChatSeletc extends Fragment {

    private ListView mConversationList;
    private ArrayAdapter<String> mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat_seletc, container, false);
        mConversationList = view.findViewById(R.id.conversation_list);

        List<String> conversationNames = new ArrayList<>();
        conversationNames.add("John Doe");
        conversationNames.add("Jane Doe");
        conversationNames.add("Jim Smith");
        mAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, conversationNames);
        mConversationList.setAdapter(mAdapter);

        mConversationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int resolucion = getResources().getConfiguration().screenWidthDp;
                Bundle bundle = new Bundle();
                bundle.putString("nombre", mConversationList.getTransitionName());
                MensajesFragment mensajesFragment = new MensajesFragment();
                mensajesFragment.setArguments(bundle);


                if (resolucion < 600) {
                    getFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new MensajesFragment())
                            .addToBackStack(null)
                            .commit();

                }
            }
        });


        return view;
    }
}
