package com.example.ver10.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ver10.AreaDetailFragment;
import com.example.ver10.R;

public class AreaFragment extends Fragment {

    private AreaViewModel areaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        areaViewModel =
                ViewModelProviders.of(this).get(AreaViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_area, container, false);
//        final TextView textView = root.findViewById(R.id.text_area);
//        areaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        final Button testButton = (Button) root.findViewById(R.id.button1);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenta = new Intent(this, );
                startActivity(intenta);
            }
        });
        return root;
    }
}
