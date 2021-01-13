package com.muflihundev.chatapp.menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.muflihundev.chatapp.R;
import com.muflihundev.chatapp.adapter.CallListAdapter;
import com.muflihundev.chatapp.model.CallList;

import java.util.ArrayList;
import java.util.List;


public class ContactFragment extends Fragment {


    public ContactFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_contact, container, false);

        List<CallList> list = new ArrayList<>();
        RecyclerView recyclerView;
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        list.add(new CallList("1","Sayang","10/01/2021, 9:30 pm","https://uploads.disquscdn.com/images/dc368ebd907dfb3c40406ed0c842b10023f20651969cbd4bf77e524b3bf29ce7.jpg","income"));

        recyclerView.setAdapter(new CallListAdapter(list,getContext()));

        return view;
    }
}