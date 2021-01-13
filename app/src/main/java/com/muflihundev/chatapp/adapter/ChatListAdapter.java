package com.muflihundev.chatapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.muflihundev.chatapp.R;
import com.muflihundev.chatapp.model.ChatList;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.Holder> {

    private List<ChatList> list;
    private Context context;

    public ChatListAdapter(List<ChatList> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ChatListAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_chat_list,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatListAdapter.Holder holder, int position) {
        ChatList chatList = list.get(position);
        holder.tvName.setText(chatList.getUserName());
        holder.tvDescription.setText(chatList.getDescription());
        holder.tvDate.setText(chatList.getDate());

        // Gambar
        Glide.with(context).load(chatList.getUrlProfileImage()).into(holder.profileImage);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private CircleImageView profileImage;
        private TextView tvName,tvDescription,tvDate;

        public Holder(@NonNull View itemView) {
            super(itemView);
            profileImage = itemView.findViewById(R.id.image_profile);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDescription = itemView.findViewById(R.id.tv_desc);
            tvDate = itemView.findViewById(R.id.tv_date);

        }
    }
}
