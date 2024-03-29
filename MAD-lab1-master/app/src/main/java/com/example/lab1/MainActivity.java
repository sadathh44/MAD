package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button customButton = findViewById(R.id.custom_button);
        @SuppressLint("UseSwitchCompatOrMaterialCode")
        Switch buttonEnabler = findViewById(R.id.button_switch);
        CalendarView calenderView = findViewById(R.id.calender);

        customButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button Pressed", Toast.LENGTH_SHORT).show();
                if(calenderView.isEnabled()) {
                    calenderView.setVisibility(View.INVISIBLE);
                    calenderView.setEnabled(false);
                }else{
                    calenderView.setVisibility(View.VISIBLE);
                    calenderView.setEnabled(true);
                }
            }
        });

        buttonEnabler.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                customButton.setEnabled(isChecked);
            }
        });
    }
}