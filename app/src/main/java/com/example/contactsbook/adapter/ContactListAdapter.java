package com.example.contactsbook.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactsbook.R;
import com.example.contactsbook.callbacks.OnSwipeTouchListener;
import com.example.contactsbook.details.DetailsActivity;
import com.example.contactsbook.model.ContactListBean;

import java.util.ArrayList;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ViewHolder> {
    Context context;
    Activity activity;
    ArrayList<ContactListBean> alContactList;
    ViewHolder mHolder;

    public ContactListAdapter(Context context, Activity activity, ArrayList<ContactListBean> alContactList) {

        this.context = context;
        this.activity = activity;
        this.alContactList = alContactList;

    }

    @NonNull
    @Override
    public ContactListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_customer_list, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactListAdapter.ViewHolder holder, int position) {
        mHolder = holder;
        final ContactListBean conListBean = alContactList.get(position);
        holder.tv_aphabet.setText((String.valueOf(conListBean.getFirstName().trim().charAt(0))).toUpperCase());
        holder.tv_firstname.setText(conListBean.getFirstName());
        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent=new Intent(activity, DetailsActivity.class);
                detailIntent.putExtra("url",conListBean.getProfilePic());
                detailIntent.putExtra("first_name",conListBean.getFirstName());
                detailIntent.putExtra("last_name",conListBean.getLastName());
                detailIntent.putExtra("phone",conListBean.getPhoneNumber());
                detailIntent.putExtra("email",conListBean.getEmail());
                activity.startActivity(detailIntent);

            }
        });

        holder.tv_aphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", conListBean.getPhoneNumber(), null));
                context.startActivity(intent);
            }
        });

      /*  holder.card_view.setOnTouchListener(new OnSwipeTouchListener(context) {
            @Override
            public void onSwipeLeft() {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", conListBean.getPhoneNumber(), null));
                context.startActivity(intent);
                // Whatever
            }
        });*/



    }

    @Override
    public int getItemCount() {
        return alContactList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_aphabet, tv_firstname;
        CardView card_view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_aphabet = (TextView) itemView.findViewById(R.id.tvName);
            tv_firstname = (TextView) itemView.findViewById(R.id.tv_FirstName);
            card_view=(CardView)itemView.findViewById(R.id.card_view);

        }
    }
}
