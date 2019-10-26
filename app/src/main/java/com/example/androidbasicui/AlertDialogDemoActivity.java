package com.example.androidbasicui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class AlertDialogDemoActivity extends AppCompatActivity {

    Button alert_simple;
    Button alert_custom_view;
    Button bottom_sheet_dialog;
    Button alert_with_custom_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_demo);

        alert_simple=findViewById(R.id.alert_simple);
        alert_custom_view=findViewById(R.id.alert_custom_view);
        bottom_sheet_dialog=findViewById(R.id.bottom_sheet);
        alert_with_custom_button=findViewById(R.id.alert_with_custom_button);

        alert_simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSimpleAlertDialog();
            }
        });

        alert_custom_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomViewDialog();
            }
        });

        bottom_sheet_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheet();
            }
        });

        alert_with_custom_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogWithCustomButton();
            }
        });

    }

    private void showDialogWithCustomButton() {

        AlertDialog.Builder alert=new AlertDialog.Builder(AlertDialogDemoActivity.this);
        View view=getLayoutInflater().inflate(R.layout.alert_dialog_with_button,null);
        final EditText editText=view.findViewById(R.id.input_data);
        Button show_data=view.findViewById(R.id.show_data);
        Button hideBtn=view.findViewById(R.id.close_dialog);

        show_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AlertDialogDemoActivity.this, " Value : "+editText.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        alert.setView(view);
        final AlertDialog alertDialog=alert.create();

        hideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
       alertDialog.show();
    }

    private void showBottomSheet() {
        BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(AlertDialogDemoActivity.this);
        //accessing layout

        View view=getLayoutInflater().inflate(R.layout.bottom_sheet_dialog,null);
        final EditText editText=view.findViewById(R.id.input_data);
        Button show_data=view.findViewById(R.id.show_data);
        show_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AlertDialogDemoActivity.this, "value : "+editText.getText().toString(), Toast.LENGTH_SHORT).show();
                editText.setError("");
            }
        });

        //adding layout to bottomsheet
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.show();

    }

    private void showCustomViewDialog() {
        //create a layout first
        AlertDialog.Builder alert=new AlertDialog.Builder(AlertDialogDemoActivity.this);
        //accessing layout file
        View view=getLayoutInflater().inflate(R.layout.custom_dialog,null);
        final EditText input=view.findViewById(R.id.input_data);
        Button show_data=view.findViewById(R.id.show_data);

        show_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().isEmpty()){
                    input.setError("Please Enter value");
                    input.requestFocus();
                    return;
                }
                Toast.makeText(AlertDialogDemoActivity.this, "Value : "+input.getText().toString(), Toast.LENGTH_SHORT).show();
                input.setText("");
            }
        });

        alert.setView(view);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alert.show();


    }

    private void showSimpleAlertDialog() {
        AlertDialog.Builder alert=new AlertDialog.Builder(AlertDialogDemoActivity.this);
        alert.setTitle("Simple Alert Dialog");
        alert.setMessage("This is a simple Alert Dialog");
        //cancel not working now
        //if you want back button not on work on back press to hide dialog just add this
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(AlertDialogDemoActivity.this, "You Pressed Cancel", Toast.LENGTH_SHORT).show();
            }
        });

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(AlertDialogDemoActivity.this, "You Pressed OK", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();
    }
}
