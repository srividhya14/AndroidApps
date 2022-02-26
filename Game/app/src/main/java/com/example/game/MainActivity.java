package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    TextView user,comp,display,score;
    Button rock,paper,scissors,reset;
    int userscore=0,compscore=0;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaPlayer music = MediaPlayer.create(MainActivity.this, R.raw.rock);
        music.start();
        music.setLooping(true);
        score=(TextView)findViewById(R.id.textView2);
        comp=(TextView)findViewById(R.id.textView3);
        user=(TextView)findViewById(R.id.textView4);
        display=(TextView)findViewById(R.id.textView5);
        rock=(Button)findViewById(R.id.button);
        paper=(Button)findViewById(R.id.button2);
        scissors=(Button)findViewById(R.id.button3);
        reset=(Button)findViewById(R.id.button4);

        random=new Random();
        user.setText(" ");
        comp.setText(" ");
        display.setText(" ");

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setText(" ");
                comp.setText(" ");
                display.setText(" ");
                setscore(0,0);

            }
        });



    }
    public void rpsButtonSelected(View view)
    {
       int userSelection=Integer.parseInt(view.getTag().toString());
       match(userSelection);
    }

    public void match(int userSelection)
    {
        int low=1;
        int high=3;
        int compSelection=random.nextInt(high)+low;
        if(userSelection==compSelection)
        {
            display.setText("Its a Tie!!");

        }
        else if((userSelection-compSelection)%3==1)
        {
            userscore++;
            display.setText("You Won!!");

        }
        else
        {
            compscore++;
            display.setText("You lost!!");

        }
        setscore(userscore,compscore);
        switch(compSelection)
        {
            case 1:comp.setText("Rock");break;
            case 2:comp.setText("Paper");break;
            case 3:comp.setText("Scissors");break;
            default:comp.setText(" ");

        }

        switch(userSelection)
        {
            case 1:user.setText("Rock");break;
            case 2:user.setText("Paper");break;
            case 3:user.setText("Scissors");break;
            default:user.setText(" ");

        }
        setscore(userscore,compscore);

    }

    public void setscore(int userscore,int compscore)
    {
        String res=String.valueOf(userscore)+":"+String.valueOf(compscore);
        score.setText(res);
    }
}