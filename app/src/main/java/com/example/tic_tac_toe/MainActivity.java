package com.example.tic_tac_toe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9;
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

    }

    public void newgame(){

        b1.setText(sb1) ;
        b2.setText(sb2);
        b3.setText(sb3);
        b4.setText(sb4);
        b5.setText(sb5);
        b6.setText(sb6);
        b7.setText(sb7);
        b8.setText(sb8) ;
        b9.setText(sb9) ;
        moves = 0 ;
        flag = 0 ;
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

                if (sb1.equals(sb2) && sb2.equals(sb3) && !sb1.isEmpty()) {

                    Toast.makeText(this, "Winner is : " + sb1, Toast.LENGTH_LONG).show();
                    newgame();
                } else if (sb4.equals(sb5) && sb5.equals(sb6) && !sb4.isEmpty()) {

                    Toast.makeText(this, "Winner is : " + sb4, Toast.LENGTH_LONG).show();
                    newgame();
                } else if (sb7.equals(sb8) && sb8.equals(sb9) && !sb7.isEmpty()) {

                    Toast.makeText(this, "Winner is : " + sb7, Toast.LENGTH_LONG).show();
                    newgame();
                } else if (sb1.equals(sb4) && sb4.equals(sb7) && !sb1.isEmpty()) {

                    Toast.makeText(this, "Winner is : "+sb1, Toast.LENGTH_LONG).show();
                    newgame();
                } else if (sb2.equals(sb5) && sb5.equals(sb8) && !sb2.isEmpty()) {

                    Toast.makeText(this, "Winner is : "+sb2, Toast.LENGTH_LONG).show();
                    newgame();
                } else if (sb3.equals(sb6) && sb6.equals(sb9) && !sb3.isEmpty()) {

                    Toast.makeText(this, "Winner is : "+sb3, Toast.LENGTH_LONG).show();
                    newgame();
                } else if (sb1.equals(sb5) && sb5.equals(sb9) && !sb1.isEmpty()) {

                    Toast.makeText(this, "Winner is : "+sb1, Toast.LENGTH_LONG).show();
                    newgame();
                } else if (sb3.equals(sb5) && sb5.equals(sb7) && !sb3.isEmpty()) {

                    Toast.makeText(this, "Winner is : "+sb3, Toast.LENGTH_LONG).show();
                    newgame();
                }

            }
            if (moves == 9 ){
                Toast.makeText(this,"The Game is draw",Toast.LENGTH_LONG).show();
                newgame();
            }
        }

    }

}