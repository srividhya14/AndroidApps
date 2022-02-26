package com.example.calculator_models1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etnum;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnc,btnbs,btnadd,btnsub,btnmul,btndiv,btneql;
    TextView tvres;
    Float v1,v2,ans;
    Boolean add=false,sub=false,mul=false,div=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etnum=(EditText)findViewById(R.id.etnum);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn0=(Button)findViewById(R.id.btn0);
        btn4=(Button)findViewById(R.id.btn4);
        btn5=(Button)findViewById(R.id.btn5);
        btn6=(Button)findViewById(R.id.btn6);
        btn7=(Button)findViewById(R.id.btn7);
        btn8=(Button)findViewById(R.id.btn8);
        btn9=(Button)findViewById(R.id.btn9);
        btnc=(Button)findViewById(R.id.btnc);
        btnbs=(Button)findViewById(R.id.btnbc);
        btnadd=(Button)findViewById(R.id.btnadd);
        btnsub=(Button)findViewById(R.id.btnsub);
        btnmul=(Button)findViewById(R.id.btnmul);
        btndiv=(Button)findViewById(R.id.btndiv);
        btneql=(Button)findViewById(R.id.btneq);
        tvres=(TextView)findViewById(R.id.tvres);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etnum.setText(etnum.getText()+"1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etnum.setText(etnum.getText()+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etnum.setText(etnum.getText()+"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etnum.setText(etnum.getText()+"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etnum.setText(etnum.getText()+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etnum.setText(etnum.getText()+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etnum.setText(etnum.getText()+"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etnum.setText(etnum.getText()+"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etnum.setText(etnum.getText()+"9");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etnum.setText(etnum.getText()+"0");
            }
        });
        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etnum.setText(" ");
                tvres.setText(" ");
            }
        });

        btnbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t=etnum.getText().toString();
                if(t.length()>1)
                {
                    int l=t.length();
                    t=t.substring(0,l-1);
                    etnum.setText(t);
                }
                else
                {
                    etnum.setText(" ");
                }
            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v1=Float.parseFloat(etnum.getText()+"");
                add=true;
                etnum.setText(" ");

            }
        });

        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v1=Float.parseFloat(etnum.getText()+"");
                sub=true;
                etnum.setText(" ");

            }
        });

        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v1=Float.parseFloat(etnum.getText()+"");
                mul=true;
                etnum.setText(" ");

            }
        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v1=Float.parseFloat(etnum.getText()+"");
                div=true;
                etnum.setText(" ");

            }
        });

        btneql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v2=Float.parseFloat(etnum.getText()+"");
                if(add==true)
                {

                    ans=v1+v2;
                    add=false;
                }
                else if(sub==true)
                {

                    ans=v1-v2;
                    sub=false;
                }
                else if(mul==true)
                {

                    ans=v1*v2;
                    mul=false;
                }
                else if(div==true)
                {

                    ans=v1/v2;
                    div=false;

                }
                tvres.setText(String.valueOf(ans));

            }
        });
    }



}