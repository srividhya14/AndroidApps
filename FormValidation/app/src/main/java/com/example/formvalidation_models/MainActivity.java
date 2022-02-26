package com.example.formvalidation_models;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText uname,upass;
Button login;
String u,p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname=(EditText)findViewById(R.id.etuid);
        upass=(EditText)findViewById(R.id.etpass);
        login=(Button)findViewById(R.id.button);
        u="divya";
        p="vaishu";
        uname.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence user, int i, int i1, int i2) {
                        if(user!=null && u.contentEquals(user))
                        {
                            String pass=upass.getText().toString();
                            if(p.contentEquals(pass))
                            {
                                login.setEnabled(true);
                            }
                            else
                            {
                                login.setEnabled(false);
                            }
                        }
                        else
                        {
                            login.setEnabled(false);
                        }

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                }
        );

        upass.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence pass, int i, int i1, int i2) {
                        if(pass!=null && p.contentEquals(pass))
                        {
                            String user=uname.getText().toString();
                            if(u.contentEquals(user))
                            {
                                login.setEnabled(true);
                            }
                            else
                            {
                                login.setEnabled(false);
                            }
                        }
                        else
                        {
                            login.setEnabled(false);
                        }

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                }
        );

    }
}