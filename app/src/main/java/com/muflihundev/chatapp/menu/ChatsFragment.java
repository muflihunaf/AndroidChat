package com.muflihundev.chatapp.menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.muflihundev.chatapp.R;
import com.muflihundev.chatapp.adapter.ChatListAdapter;
import com.muflihundev.chatapp.model.ChatList;

import java.util.ArrayList;
import java.util.List;


public class ChatsFragment extends Fragment {



    public ChatsFragment() {
        // Required empty public constructor
    }

    private List<ChatList> list = new ArrayList<>();
    private RecyclerView recyclerView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getChatList();
    }

    private void getChatList() {
        list.add(new ChatList("1","Sayang","Hai Sayang","11/01/2021","https://uploads.disquscdn.com/images/dc368ebd907dfb3c40406ed0c842b10023f20651969cbd4bf77e524b3bf29ce7.jpg"));
        list.add(new ChatList("2","Bangsat","Wes Bayar Utang?","01/01/2021","https://s3-ap-southeast-1.amazonaws.com/ekrutassets/home/deploy/ekrut/releases/20200521050031/public/ckeditor_assets/pictures/3351/content_apa-itu-company-profile---EKRUT.jpg"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_chats, container, false);
        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(new ChatListAdapter(list,getContext()));
        return view;
    }
}