package com.example.barry.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Game game;
    int[] buttonids = new int[9];
    int row;
    int column;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();
        buttonids[0] = findViewById(R.id.button1).getId();
        buttonids[1] = findViewById(R.id.button2).getId();
        buttonids[2] = findViewById(R.id.button3).getId();
        buttonids[3] = findViewById(R.id.button4).getId();
        buttonids[4] = findViewById(R.id.button5).getId();
        buttonids[5] = findViewById(R.id.button6).getId();
        buttonids[6] = findViewById(R.id.button7).getId();
        buttonids[7] = findViewById(R.id.button8).getId();
        buttonids[8] = findViewById(R.id.button9).getId();
    }

    public void tileClicked(View view) {

        int id = view.getId();
        for (int i = 0; i < 9; i++){
            if(buttonids[i] == id) {
                column = i % 3;
                row = (i - column) / 3;
                break;
            }
        }

        Tile tile = game.draw(row, column);

        switch(tile) {
            case CROSS:
                Button abutton = findViewById(buttonids[column + (3 * row)]);
                abutton.setText("X");
                break;
            case CIRCLE:
                Button bbutton = findViewById(buttonids[column + (3 * row)]);
                bbutton.setText("O");
                break;
        }


    }

    public void resetClicked(View view) {
        game = new Game();
        for (int i = 0; i < 9; i++) {
            Button abutton = findViewById(buttonids[i]);
            abutton.setText("");
        }

    }
}
    