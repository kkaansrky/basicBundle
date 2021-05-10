package com.example.bundleclone.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bundleclone.R;


import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private final List<String> localDataSet;
    private Context mContext;


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            textView = view.findViewById(R.id.item);
            view.setOnClickListener(this);
        }

        public TextView getTextView() {
            return textView;
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


    public ItemAdapter(List<String> dataSet, Context context) {
        localDataSet = dataSet;
        mContext = context;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_kategori, viewGroup, false);


        return new ViewHolder(view);
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
