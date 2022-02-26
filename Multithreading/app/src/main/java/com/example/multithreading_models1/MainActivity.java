package com.example.multithreading_models1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int t=0;
    Thread workerthread;
    Button start,end;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=(Button)findViewById(R.id.button);
        end=(Button)findViewById(R.id.button2);
        tv=(TextView)findViewById(R.id.textView);
        start.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tv.append("Timer Started\n");
                        workerthread=new Thread(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        while(!Thread.currentThread().isInterrupted())
                                        {
                                            try{
                                                Thread.sleep(1000);
                                            }
                                            catch (InterruptedException e)
                                            {
                                                e.printStackTrace();
                                                return;
                                            }
                                            t+=1;
                                            runOnUiThread(
                                                    new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            tv.append("\nTime elapsed:"+t+"sec.");
                                                        }
                                                    }
                                            );
                                        }
                                    }
                                }
                        );
                        workerthread.start();
                    }
                }
        );
        end.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        workerthread.interrupt();
                        t=0;
                        tv.append("\nTimer Stopped");
                    }
                }
        );

        

    }
}