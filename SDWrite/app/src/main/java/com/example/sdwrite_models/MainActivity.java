package com.example.sdwrite_models;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button read,write;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=(EditText)findViewById(R.id.etdata);
        read=(Button)findViewById(R.id.readbtn);
        write=(Button)findViewById(R.id.writebtn);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }
        write.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String msg=et.getText().toString();
                        try{
                               File f=new File("/sdcard/myfile.txt");
                               f.createNewFile();
                               FileOutputStream fout=new FileOutputStream(f);
                               fout.write(msg.getBytes());
                               fout.close();
                            Toast.makeText(MainActivity.this,"Data written to external storage",Toast.LENGTH_LONG).show();
                        }
                        catch(Exception e)
                        {
                            Toast.makeText(MainActivity.this,"Data Not written to external storage",Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );

        read.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String msg;
                        String buffer="";
                        try{
                            File f=new File("/sdcard/myfile.txt");
                            FileInputStream ip=new FileInputStream(f);
                            BufferedReader br=new BufferedReader(new InputStreamReader(ip));
                            while((msg=br.readLine())!=null)
                            {
                                buffer+=msg;
                            }
                            et.setText(buffer);
                            br.close();
                            ip.close();
                            Toast.makeText(MainActivity.this,"Data Read from external storage",Toast.LENGTH_LONG).show();
                        }
                        catch(Exception e)
                        {
                            Toast.makeText(MainActivity.this,"Error Reading data from external storage",Toast.LENGTH_LONG).show();
                        }

                    }
                }
        );
    }

   
}