package com.example.bundleclone.ui.home;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bundleclone.Haber;
import com.example.bundleclone.R;


import java.util.List;

public class HaberAdapter extends RecyclerView.Adapter<HaberAdapter.ViewHolder> {
    private final List<Haber> localDataSet;
    private Context mContext;


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView hood,summary;
        private final ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            hood = view.findViewById(R.id.hood);
            summary = view.findViewById(R.id.summary);
            imageView = view.findViewById(R.id.imageView);
            view.setOnClickListener(this);
        }

        public ImageView getImageView() {
            return imageView;
        }

        public TextView getHood() {
            return hood;
        }

        public TextView getSummary() {
            return summary;
        }

        @Override
        public void onClick(View v) {
//            TextView textView = (TextView) v.findViewById(R.id.filter);
//            Log.d("LOGTAG", "clicked : name " + textView.getText().toString());
//
//            Intent intent = new Intent(v.getContext(), QuestionActivity.class);
//            Bundle b = new Bundle();
//            String numberOfExam = textView.getText().toString().substring(0, 2);
//            if(textView.getText().toString().matches(".*Test")){
//                b.putString("filter", numberOfExam + "testsilahli");
//            }else if (textView.getText().toString().matches(".*Silahlı")) {
//                b.putString("filter", numberOfExam + "silahli");
//            } else {
//                b.putString("filter", numberOfExam + "silahsiz");
//            }
//            intent.putExtras(b);
//            v.getContext().startActivity(intent);
        }
    }


    public HaberAdapter(List<Haber> dataSet,Context context) {
        localDataSet = dataSet;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_haber, viewGroup, false);


        return new ViewHolder(view);
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {

        Haber tempHaber = localDataSet.get(position);

        Log.d("TAG", "onBindViewHolder: "+ tempHaber.getUrl());
        viewHolder.getHood().setText(tempHaber.getBaslik());
        viewHolder.getSummary().setText(tempHaber.getOzet());
        Glide.with(mContext).load(tempHaber.getResim()).into(viewHolder.getImageView());


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
