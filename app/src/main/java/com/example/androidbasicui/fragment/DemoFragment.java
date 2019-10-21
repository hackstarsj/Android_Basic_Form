package com.example.androidbasicui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidbasicui.R;
import com.example.androidbasicui.interfaces.PassDataInterface;


public class DemoFragment extends Fragment {

    PassDataInterface passDataInterface;
    public DemoFragment(PassDataInterface passDataInterface) {
        this.passDataInterface=passDataInterface;
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_demo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView output=view.findViewById(R.id.output);
        Bundle bundle=getArguments();
        String data=bundle.getString("output_data_fragment");
        output.setText(data);

        final Button pass_data=view.findViewById(R.id.pass_data);
        pass_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passDataInterface.onDataReceived("Demo Data Sending By Fragment\n");
            }
        });

    }
}
