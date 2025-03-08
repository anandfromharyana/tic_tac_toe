package com.example.tic_tac_toe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, reset;
    String sb1, sb2, sb3, sb4, sb5, sb6, sb7, sb8, sb9 = "";
    int flag = 0;
    int moves = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        reset = findViewById(R.id.reset_button);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newgame();
                Toast.makeText(MainActivity.this, "Game Reset!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void check(View view) {
        Button btncurr = (Button) view;

        if (btncurr.getText().equals("")) {
            if (flag == 0) {
                btncurr.setText("X");
                flag = 1;
            } else {
                btncurr.setText("O");
                flag = 0;
            }
            moves++;

            if (moves > 4) {
                sb1 = b1.getText().toString();
                sb2 = b2.getText().toString();
                sb3 = b3.getText().toString();
                sb4 = b4.getText().toString();
                sb5 = b5.getText().toString();
                sb6 = b6.getText().toString();
                sb7 = b7.getText().toString();
                sb8 = b8.getText().toString();
                sb9 = b9.getText().toString();

                if (checkWinner(sb1, sb2, sb3)) showWinner(sb1);
                else if (checkWinner(sb4, sb5, sb6)) showWinner(sb4);
                else if (checkWinner(sb7, sb8, sb9)) showWinner(sb7);
                else if (checkWinner(sb1, sb4, sb7)) showWinner(sb1);
                else if (checkWinner(sb2, sb5, sb8)) showWinner(sb2);
                else if (checkWinner(sb3, sb6, sb9)) showWinner(sb3);
                else if (checkWinner(sb1, sb5, sb9)) showWinner(sb1);
                else if (checkWinner(sb3, sb5, sb7)) showWinner(sb3);
                else if (moves == 9) {
                    Toast.makeText(this, "The Game is Draw", Toast.LENGTH_LONG).show();
                    newgame();
                }
            }
        }
    }

    private boolean checkWinner(String a, String b, String c) {
        return a.equals(b) && b.equals(c) && !a.isEmpty();
    }

    private void showWinner(String winner) {
        Toast.makeText(this, "Winner is: " + winner, Toast.LENGTH_LONG).show();
        newgame();
    }

    public void newgame() {
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");

        moves = 0;
        flag = 0;
    }
}
