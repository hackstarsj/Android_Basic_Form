package com.example.androidbasicui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Progress_Seekbar_Activity extends AppCompatActivity {

    ProgressBar increase_progress;
    RatingBar ratingBar;
    Button increase_button;
    SeekBar seekBar;
    Button submit;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress__seekbar_);
        submit=findViewById(R.id.get_value);
        increase_button=findViewById(R.id.increase_value);
        ratingBar=findViewById(R.id.ratingbar);
        seekBar=findViewById(R.id.seekbar);
        increase_progress=findViewById(R.id.progress_increase);
        output=findViewById(R.id.output);
        ratingBar.setNumStars(5);

        increase_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(increase_progress.getProgress()!=100){
                    increase_progress.setProgress(increase_progress.getProgress()+10);
                }
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(Progress_Seekbar_Activity.this, "Rated : "+rating, Toast.LENGTH_SHORT).show();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(Progress_Seekbar_Activity.this, "Seekbar Value : "+progress, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output.setText("");
                output.append("Rating : "+ratingBar.getRating()+"\n");
                output.append("Seekbar : "+seekBar.getProgress());
                output.append("Progress : "+increase_progress.getProgress());
            }
        });
    }

}
