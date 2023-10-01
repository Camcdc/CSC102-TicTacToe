package com.example.tictactoe;

import static com.example.tictactoe.R.id.play;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Display extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        Button play = findViewById(R.id.play);
        Button demo = findViewById(R.id.demo);
        Button exit = findViewById(R.id.exit);

        play.setOnClickListener(this);
        demo.setOnClickListener(this);
        exit.setOnClickListener(this);
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view){
        int viewId = view.getId();
        if (viewId == R.id.play) {
            Intent intent = new Intent(getApplicationContext(),AddPlayers.class);

            startActivity(intent);
            //Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();
        } else if (viewId == R.id.demo) {
            Intent intent = new Intent(getApplicationContext(), Demo.class);

            startActivity(intent);
            //Toast.makeText(getApplicationContext(), "CHICHI", Toast.LENGTH_LONG).show();
        } else if (viewId == R.id.exit) {
            //Toast.makeText(getApplicationContext(), "thando", Toast.LENGTH_LONG).show();
            finish();
        }

    }

}
