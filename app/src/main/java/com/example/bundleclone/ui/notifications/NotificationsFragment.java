package com.example.bundleclone.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bundleclone.Haber;
import com.example.bundleclone.R;
import com.example.bundleclone.ui.dashboard.ItemAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private RecyclerView recyclerView;

    private DatabaseReference mDatabase;
    List<String> tempKaynak = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        recyclerView = root.findViewById(R.id.recycler_view);
        mDatabase = FirebaseDatabase.getInstance().getReference("Haberler");

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot haberSnapshot : snapshot.getChildren()) {
                    Haber haber = haberSnapshot.getValue(Haber.class);
                    if(!tempKaynak.contains(haber.getKaynak())){
                        tempKaynak.add(haber.getKaynak());
                    }
                }
                ItemAdapter adapter = new ItemAdapter(tempKaynak,NotificationsFragment.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        };
        mDatabase.addValueEventListener(postListener);
        return root;
    }
}