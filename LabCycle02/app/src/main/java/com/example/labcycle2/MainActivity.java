package com.example.labcycle2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    ProgressBar progressBar;

    TextView text;

    int progressStatus;

    Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        text = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Alert");
        builder.setMessage("Are you sure want to exit");
        builder.setIcon(R.drawable.warning);

        builder.setPositiveButton("Accept",(dialog, which) ->
        {
            finish();
        });

        builder.setNegativeButton("Decline",(dialog, which) ->
        {
            dialog.cancel();
        });

        builder.setNeutralButton("Cancel",(dialog, which) ->
        {
            dialog.cancel();
        });

        builder.setCancelable(false);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
            }
        });


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressStatus < 100)
                {
                    progressStatus += 1;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progressStatus);
                            text.setText(progressStatus + "%");

                        }
                    });
                    try{
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }

            }
        }).start();




    }
}