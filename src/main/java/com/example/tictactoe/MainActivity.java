package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 0 -Yellow
    // 1 -Red
    // 2 -unplaced
    boolean isGameActive = true;
    boolean isActive = false;
    int [] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    public void dropIn(View view) {

        ImageView counter = (ImageView) view;
//        System.out.println(counter.getTag().toString());
        if(gameState[Integer.parseInt(counter.getTag().toString())] == 2 && isGameActive) {

            counter.setTranslationY(-1000f);
            if (isActive) {
                gameState[Integer.parseInt(counter.getTag().toString())] = 1;
                isActive = false;
                counter.setImageResource(R.drawable.red);
            } else {
                gameState[Integer.parseInt(counter.getTag().toString())] = 0;
                isActive = true;
                counter.setImageResource(R.drawable.yellow);
            }


            counter.animate().translationYBy(1000f).rotation(360f).setDuration(300);
            LinearLayout playAgainLayout = (LinearLayout) findViewById(R.id.playAgainLayout);
            TextView textView = (TextView) findViewById(R.id.textView);
            if((gameState[0] == gameState[1] && gameState[1] == gameState[2] && gameState[0] != 2)) {
                isGameActive = false;
                textView.setText((gameState[0] == 0)?"Yellow Wins!":"Red Wins!");
                playAgainLayout.animate().alphaBy(1f).translationXBy(-1000).setDuration(100);
            } else if((gameState[3] == gameState[4] && gameState[4] == gameState[5] && gameState[3] != 2)) {
                isGameActive = false;
                textView.setText((gameState[3] == 0)? "Yellow Wins!" : "Red Wins!");
                playAgainLayout.animate().alphaBy(1f).translationXBy(-1000).setDuration(100);

            } else if((gameState[6] == gameState[7] && gameState[7] == gameState[8] && gameState[6] != 2)) {
                isGameActive = false;
                textView.setText((gameState[6] == 0)? "Yellow Wins!" : "Red Wins!");
                playAgainLayout.animate().alphaBy(1f).translationXBy(-1000).setDuration(100);

            } else if((gameState[0] == gameState[3] && gameState[3] == gameState[6] && gameState[0] != 2)) {
                isGameActive = false;
                textView.setText((gameState[0] == 0)? "Yellow Wins!" : "Red Wins!");
                playAgainLayout.animate().alphaBy(1f).translationXBy(-1000).setDuration(100);
            } else if((gameState[1] == gameState[4] && gameState[4] == gameState[7] && gameState[1] != 2)) {
                isGameActive = false;
                textView.setText((gameState[1] == 0)? "Yellow Wins!" : "Red Wins!");
                playAgainLayout.animate().alphaBy(1f).translationXBy(-1000).setDuration(100);
            } else if((gameState[2] == gameState[5] && gameState[5] == gameState[8] && gameState[2] != 2)) {
                isGameActive = false;
                textView.setText((gameState[2] == 0)? "Yellow Wins!" : "Red Wins!");
                playAgainLayout.animate().alphaBy(1f).translationXBy(-1000).setDuration(100);
            } else if((gameState[0] == gameState[4] && gameState[4] == gameState[8] && gameState[0] != 2)) {
                isGameActive = false;
                textView.setText((gameState[0] == 0)? "Yellow Wins!" : "Red Wins!");
                playAgainLayout.animate().alphaBy(1f).translationXBy(-1000).setDuration(100);
            } else if((gameState[2] == gameState[4] && gameState[4] == gameState[6] && gameState[2] != 2)) {
                isGameActive = false;
                textView.setText((gameState[2] == 0)? "Yellow Wins!" : "Red Wins!");
                playAgainLayout.animate().alphaBy(1f).translationXBy(-1000).setDuration(100);
            } else {
                boolean f = false;
                for(int i = 0; i < 9; ++i) {
                    if(gameState[i] == 2) {
                        f = true;
                        break;
                    }
                }
                if(f == false) {
                    isGameActive = false;
                    textView.setText("It's a Draw!");
                    playAgainLayout.animate().alphaBy(1f).translationXBy(-1000).setDuration(100);
                }
            }
        }
    }

    public void playAgain(View view) {
        for(int i = 0; i < 9; ++i) {
            gameState[i] = 2;
        }
        isActive = false;
        ImageView img = (ImageView) findViewById(R.id.imageView0);
        img.setImageResource(0);
        img = (ImageView) findViewById(R.id.imageView1);
        img.setImageResource(0);
        img = (ImageView) findViewById(R.id.imageView2);
        img.setImageResource(0);
        img = (ImageView) findViewById(R.id.imageView3);
        img.setImageResource(0);
        img = (ImageView) findViewById(R.id.imageView4);
        img.setImageResource(0);
        img = (ImageView) findViewById(R.id.imageView5);
        img.setImageResource(0);
        img = (ImageView) findViewById(R.id.imageView6);
        img.setImageResource(0);
        img = (ImageView) findViewById(R.id.imageView7);
        img.setImageResource(0);
        img = (ImageView) findViewById(R.id.imageView8);
        img.setImageResource(0);
        isGameActive = true;
        LinearLayout playAgainLayout = (LinearLayout) findViewById(R.id.playAgainLayout);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("");
        playAgainLayout.setAlpha(0);
        playAgainLayout.animate().translationXBy(1000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout playAgainLayout = (LinearLayout) findViewById(R.id.playAgainLayout);
        playAgainLayout.setTranslationX(1000);
    }
}
