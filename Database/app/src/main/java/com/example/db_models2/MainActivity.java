package com.example.db_models2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,mob,id;
    Button add,view,delete,update;
    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.etname);
        id=(EditText)findViewById(R.id.etid);
        mob=(EditText)findViewById(R.id.etmob);
        add=(Button)findViewById(R.id.Add);
        view=(Button)findViewById(R.id.View);
        delete=(Button)findViewById(R.id.delete);
        update=(Button)findViewById(R.id.update);
        mydb=new DatabaseHelper(this);
        insert();
        viewdata();
        updatedata();
        deletedata();
    }

    public void insert()
    {
        add.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean res=mydb.insert_data(name.getText().toString(),mob.getText().toString());
                        if(res==true)
                        {
                            Toast.makeText(MainActivity.this,"Data inserted successfully",Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this,"Data Not inserted",Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );


    }

    public void viewdata()
    {
        view.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor res=mydb.view();
                        if(res.getCount()==0)
                        {
                            showalldata("Error","No Data Exists");
                            return;
                        }
                        StringBuffer buffer=new StringBuffer();
                        while(res.moveToNext())
                        {
                            buffer.append("ID:"+res.getString(0)+"\n");
                            buffer.append("Name:"+res.getString(1)+"\n");
                            buffer.append("Mob:"+res.getString(2)+"\n");
                        }
                        showalldata("Data",buffer.toString());
                    }
                }
        );


    }

    public void showalldata(String title,String msg)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setCancelable(true);
        builder.show();
    }

    public void updatedata()
    {
        update.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int res=mydb.update(id.getText().toString(),name.getText().toString(),mob.getText().toString());
                        if(res>0)
                        {
                            Toast.makeText(MainActivity.this,"Data Updated successfully",Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this,"Data Not updated successfully",Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );

    }

    public void deletedata()
    {
        delete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int res=mydb.delete(id.getText().toString());
                        if(res>0)
                        {
                            Toast.makeText(MainActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this,"Data Not Deleted",Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }



}