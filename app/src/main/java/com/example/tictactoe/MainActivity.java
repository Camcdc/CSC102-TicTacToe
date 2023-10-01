package com.example.tictactoe;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.tictactoe.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //ActivityMainBinding binding;
    private final List<int[]> winList = new ArrayList<>();
    private int[] boxPos = {0,0,0,0,0,0,0,0,0};
    private int playerTurn = 1;
    private int totalSelectBoxes = 1;

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        winList.add(new int[] {0,1,2});
        winList.add(new int[] {3,4,5});
        winList.add(new int[] {6,7,8});
        winList.add(new int[] {0,3,6});
        winList.add(new int[] {1,4,7});
        winList.add(new int[] {2,5,8});
        winList.add(new int[] {2,4,6});
        winList.add(new int[] {0,4,8});

        String getPlayerOneName = getIntent().getStringExtra("playerOne");
        String getPlayerTwoName = getIntent().getStringExtra("playerTwo");

        binding.playerOneName.setText(getPlayerOneName);
        binding.playerTwoName.setText(getPlayerTwoName);

        binding.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxAvailable(0)){
                    performAct((ImageView) view, 0);
                }
            }
        });

        binding.image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxAvailable(1)){
                    performAct((ImageView) view, 1);
                }
            }
        });

        binding.image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxAvailable(2)){
                    performAct((ImageView) view, 2);
                }
            }
        });

        binding.image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxAvailable(3)){
                    performAct((ImageView) view, 3);
                }
            }
        });

        binding.image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxAvailable(4)){
                    performAct((ImageView) view, 4);
                }
            }
        });

        binding.image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxAvailable(5)){
                    performAct((ImageView) view, 5);
                }
            }
        });

        binding.image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxAvailable(6)){
                    performAct((ImageView) view, 6);
                }
            }
        });

        binding.image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxAvailable(7)){
                    performAct((ImageView) view, 7);
                }
            }
        });

        binding.image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxAvailable(8)){
                    performAct((ImageView) view, 8);
                }
            }
        });
    }

    private void performAct(ImageView imageView, int selectedBoxPos){
        boxPos[selectedBoxPos] = playerTurn;

        if(playerTurn == 1){
            imageView.setImageResource((R.drawable.ximage)); //changes the image to an x
            if(checkResult()){
                Results resultDia = new Results(MainActivity.this,binding.playerOneName.getText().toString()
                 + " is a Winner!", MainActivity.this);
                resultDia.setCancelable(false);
                resultDia.show();
            }else if (totalSelectBoxes == 9){
                Results resultDia = new Results(MainActivity.this, "Match Draw", MainActivity.this);
                resultDia.setCancelable(false);
                resultDia.show();
            }else{
                changePlayerTurn(2);
                totalSelectBoxes++;
            }
        }else{
            imageView.setImageResource((R.drawable.oimage)); //changes the image to an 0
            if(checkResult()){
                Results resultDia = new Results(MainActivity.this,binding.playerTwoName.getText().toString()
                        + " is a Winner!", MainActivity.this);
                resultDia.setCancelable(false);
                resultDia.show();
            }else if (totalSelectBoxes == 9){
                Results resultDia = new Results(MainActivity.this, "Match Draw", MainActivity.this);
                resultDia.setCancelable(false);
                resultDia.show();
            }else{
                changePlayerTurn(1);
                totalSelectBoxes++;
            }
        }
    }

    private void changePlayerTurn(int currentPlayerTurn){ //this method is for tracking whos turn it is using borders that change in the grid layout
        playerTurn = currentPlayerTurn;
        if (playerTurn == 1){
            binding.playerOneLayout.setBackgroundResource(R.drawable.black_border);
            binding.playerTwoLayout.setBackgroundResource(R.drawable.white_box);
        }else{
            binding.playerTwoLayout.setBackgroundResource(R.drawable.black_border);
            binding.playerOneLayout.setBackgroundResource(R.drawable.white_box);
        }
    }

    private boolean checkResult(){
        boolean response = false;
        for (int i = 0; i < winList.size(); i++){
            final int[] combination = winList.get(i);

            if (boxPos[combination[0]] == playerTurn && boxPos[combination[1]] == playerTurn &&
            boxPos[combination[2]] == playerTurn){
                response = true;
            }
        }
        return response;
    }

    private boolean isBoxAvailable(int boxPosition){
        boolean response = false;

        if (boxPos[boxPosition] == 0){
            response = true;
        }
        return response;
    }

    public void restart(){
        boxPos = new int[] {0,0,0,0,0,0,0,0,0};
        playerTurn = 1;
        totalSelectBoxes = 1;

        binding.image1.setImageResource(R.drawable.white_box);
        binding.image2.setImageResource(R.drawable.white_box);
        binding.image3.setImageResource(R.drawable.white_box);
        binding.image4.setImageResource(R.drawable.white_box);
        binding.image5.setImageResource(R.drawable.white_box);
        binding.image6.setImageResource(R.drawable.white_box);
        binding.image7.setImageResource(R.drawable.white_box);
        binding.image8.setImageResource(R.drawable.white_box);
        binding.image9.setImageResource(R.drawable.white_box);

    }
}
