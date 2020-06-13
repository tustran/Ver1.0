package com.example.ver10.ui.notify;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ver10.R;
import com.example.ver10.ui.area.AreaViewModel;

public class NotifyFragment extends Fragment {

    private NotifyViewModel notifyViewModel;

//    public static NotifyFragment newInstance() {
//        return new NotifyFragment();
//    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        notifyViewModel =
                ViewModelProviders.of(this).get(NotifyViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notify, container, false);
        final TextView textView = root.findViewById(R.id.text_notify);
        notifyViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
//        return inflater.inflate(R.layout.fragment_notify, container, false);
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        notifyViewModel = ViewModelProviders.of(this).get(NotifyViewModel.class);
//        // TODO: Use the ViewModel
//    }

}