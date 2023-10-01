package com.example.tictactoe;

import static androidx.core.content.ContextCompat.startActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;

import org.w3c.dom.Text;

public class Results extends Dialog {

    private final String message;
    private final MainActivity mainActivity;

    public Results(@NonNull Context context, String message, MainActivity mainActivity) {
        super(context);
        this.message = message;
        this.mainActivity = mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        TextView messageText = findViewById(R.id.messageText);
        Button startAgainBut = findViewById(R.id.startAgain);
        Button exitGame = findViewById(R.id.exitResult);
        Button backMenu = findViewById(R.id.backMenu);

        messageText.setText(message);

        startAgainBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.restart();
                dismiss();
            }
        });

        exitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.finishAffinity();
            }
        });

        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Display.class);
                getContext().startActivity(intent);
            }
        });
    }
}