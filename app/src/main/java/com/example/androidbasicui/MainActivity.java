package com.example.androidbasicui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button submit;
    EditText first_name,last_name,email,phone;
    Spinner age;
    CheckBox php,java,csharp;
    RadioGroup sex;
    Switch want_notification;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first_name=findViewById(R.id.first_name);
        last_name=findViewById(R.id.last_name);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);
        age=findViewById(R.id.age);
        php=findViewById(R.id.php);
        output=findViewById(R.id.output);
        java=findViewById(R.id.java);
        csharp=findViewById(R.id.csharp);
        sex=findViewById(R.id.sex);
        want_notification=findViewById(R.id.notification);
        submit=findViewById(R.id.submit);

        String[] age_list={"10","11","12","13","14","15","16","17","18"};
        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,age_list);
        age.setAdapter(adapter);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder output=new StringBuilder();
                output.append("First name : "+first_name.getText().toString()+"\n");
                output.append("Last name : "+last_name.getText().toString()+"\n");
                output.append("Email : "+email.getText().toString()+"\n");
                output.append("phone : "+phone.getText().toString()+"\n");
                int sex_id=sex.getCheckedRadioButtonId();
                if(sex_id==R.id.male){
                    output.append("Sex : Male \n");
                }
                else{
                    output.append("Sex : Female \n");

                }

                output.append("Skills : ");
                if(php.isChecked()){
                    output.append("PHP,");
                }
                if(java.isChecked()){
                    output.append("JAVA,");
                }
                if(csharp.isChecked()){
                    output.append("C#,");
                }

                output.append("\n");

                output.append("Age :"+age.getSelectedItem()+" \n");

                if(want_notification.isChecked()){
                    output.append("Want Notification : Yes");
                }
                else{
                    output.append("Want Notification : No");
                }

                Intent intent=new Intent(MainActivity.this,OutPutActivity.class);
                // Now let's Pass data using Bundle
                Bundle bundle=new Bundle();
                bundle.putString("output_data",output.toString());
                intent.putExtras(bundle);
                //intent.putExtra("output_data",output.toString());
                startActivity(intent);

            }
        });



    }
}
