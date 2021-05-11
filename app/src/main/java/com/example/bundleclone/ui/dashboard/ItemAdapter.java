package com.example.bundleclone.ui.dashboard;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bundleclone.Firebase;
import com.example.bundleclone.MainActivity;
import com.example.bundleclone.R;
import com.example.bundleclone.StartActivity;
import com.example.bundleclone.ui.notifications.NotificationsFragment;


import java.util.List;

import static android.content.ContentValues.TAG;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private final List<String> localDataSet;
    private Fragment mFragment;


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView textView;
        private final Fragment mFragment;

        public ViewHolder(View view,Fragment fragment) {
            super(view);
            // Define click listener for the ViewHolder's View
            textView = view.findViewById(R.id.item);
            this.mFragment = fragment;
            view.setOnClickListener(this);
        }

        public TextView getTextView() {
            return textView;
        }

        @Override
        public void onClick(View v) {
            TextView textView = (TextView) v.findViewById(R.id.item);
            Firebase firebase = new Firebase();
            String item = textView.getText().toString();
            Log.d("FRAGMENT", "onClick: "+mFragment);
            if(mFragment instanceof DashboardFragment){

                firebase.setKategori(item);
            }else if (mFragment instanceof NotificationsFragment){
                firebase.setKaynak(item);
            }


        }
    }


    public ItemAdapter(List<String> dataSet, Fragment fragment) {
        localDataSet = dataSet;
        mFragment = fragment;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_kategori, viewGroup, false);


        return new ViewHolder(view,mFragment);
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {

        String tempItem = localDataSet.get(position);


        viewHolder.getTextView().setText(tempItem);


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
