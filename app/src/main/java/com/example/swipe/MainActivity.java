package com.example.swipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ebanx.swipebtn.OnStateChangeListener;
import com.ebanx.swipebtn.SwipeButton;

public class MainActivity extends AppCompatActivity {
    private SwipeButton swipe;
    private Button move;
    int s=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        move=findViewById(R.id.move);
        swipe=findViewById(R.id.swipe);

        swipe.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {
               s=s+1;
               if(s%2==0)
               {
                   Toast.makeText(MainActivity.this,"Button Unlocked",Toast.LENGTH_SHORT).show();
               }
               else
               {
                   Toast.makeText(MainActivity.this,"Button Locked",Toast.LENGTH_SHORT).show();
               }
            }
        });

        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(s%2==0)
                {
                    move();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"First Unlock The Button",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    public void  move ()
    {
        Intent intent =new Intent(MainActivity.this,Second.class);
        startActivity(intent);

    }



}