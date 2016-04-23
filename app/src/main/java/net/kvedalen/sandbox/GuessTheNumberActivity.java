package net.kvedalen.sandbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import java.util.Random;

public class GuessTheNumberActivity extends AppCompatActivity {

    private Random randGen;
    private int myNumber;
    private boolean gameActive;
    private LinearLayout gameOverLayout;

    public void gtn_checkNumber(View view) {

        ImageView myBubble = (ImageView) view;

        int number = Integer.parseInt(view.getTag().toString());

        if (gameActive) {

            myBubble.animate().alpha(0).setDuration(3000);

            if (number == myNumber) {
                myBubble.setImageResource(R.drawable.greenbubble);
                myBubble.animate().alpha(1).setDuration(3000);
                gameActive = false;
                gameOverLayout = (LinearLayout) findViewById(R.id.gtn_gameOverLayout);
                gameOverLayout.setVisibility(View.VISIBLE);
            } else if (number > myNumber) {
                myBubble.setImageResource(R.drawable.redbubble);
                myBubble.animate().alpha(1).setDuration(3000);
            } else {
                myBubble.setImageResource(R.drawable.bluebubble);
                myBubble.animate().alpha(1).setDuration(3000);
            }
        }
    }

    public void playAgain(View view){

        resetBubbles();
        setNewRandomNumber();
        gameOverLayout = (LinearLayout) findViewById(R.id.gtn_gameOverLayout);
        gameOverLayout.setVisibility(View.INVISIBLE);

    }

    public void resetBubbles(){

        for (int i=1 ; i < 21 ; i++){
            String resName = "bubble" + i;
            int res = this.getResources().getIdentifier(resName, "id", this.getPackageName());
            ImageView iv = (ImageView) findViewById(res);
            iv.setImageResource(R.drawable.yellowbubble);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_number);

        randGen = new Random();
        setNewRandomNumber();
    }

    public void setNewRandomNumber(){
        myNumber = 1 + randGen.nextInt(19);
        gameActive = true;
    }
}
