package com.example.androidbasicui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SharePrefenceDemo extends AppCompatActivity {

    EditText input;
    Button save_data;
    Button SHow_value;
    TextView show_data;
    Button remove_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_prefence_demo);

        input=findViewById(R.id.input);
        save_data=findViewById(R.id.save_value);
        show_data=findViewById(R.id.show_value_text);
        SHow_value=findViewById(R.id.show_value);
        remove_data=findViewById(R.id.remove_value);

        save_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().isEmpty()){
                    Toast.makeText(SharePrefenceDemo.this, "Please Enter Data", Toast.LENGTH_SHORT).show();
                    input.setError("Please input");
                    input.requestFocus();
                    return;
                }
                saveData("key_1",input.getText().toString());
                input.setText("");
            }
        });

        SHow_value.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=getData("key_1");

                if(data==null){
                    show_data.setText("No Value Set");
                }
                else{
                    show_data.setText(data);
                }
            }
        });

        remove_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeData("key_1");
            }
        });
    }

    private void removeData(String key) {
        SharedPreferences sharedPreferences=getSharedPreferences("MyPref",0);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }

    private void saveData(String key,String value) {
        SharedPreferences sharedPreferences=getSharedPreferences("MyPref",0);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        editor.putString(key,value);
        editor.apply();
    }

    private String getData(String key){
        SharedPreferences sharedPreferences=getSharedPreferences("MyPref",0);
        if(sharedPreferences.contains(key)){
            String data=sharedPreferences.getString(key,null);
            return data;
        }
        else{
            return null;
        }
    }
}
