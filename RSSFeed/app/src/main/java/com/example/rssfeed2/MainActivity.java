package com.example.rssfeed2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvRSS;
    ArrayList<String>titles;
    ArrayList<String>links;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvRSS=(ListView)findViewById(R.id.lvRSS);
        titles=new ArrayList<String>();
        links=new ArrayList<String>();

        lvRSS.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Uri uri=Uri.parse(links.get(i));
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);

            }
        });
        new ProcessInBackground().execute();

    }

    public InputStream getInputStream(URL url)
    {
        try{
            return url.openConnection().getInputStream();

        }catch(Exception e)
        {
            return null;
        }
    }

    public class ProcessInBackground extends AsyncTask<Integer,Void,Exception>
    {
        ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
        Exception exception=null;
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            progressDialog.setMessage("Busy Loading RSS Feed!!.......Please Wait!");
            progressDialog.show();

        }

        @Override
        protected Exception doInBackground(Integer... integers) {
            try{
                URL url=new URL("https://timesofindia.indiatimes.com/rssfeedstopstories.cms");
                XmlPullParserFactory factory=XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(false);
                XmlPullParser xpp=factory.newPullParser();
                xpp.setInput(getInputStream(url),"UTF_8");
                boolean insideItem=false;
                int eventType=xpp.getEventType();
                while(eventType!=XmlPullParser.END_DOCUMENT)
                {
                    if(eventType==XmlPullParser.START_TAG)
                    {
                        if(xpp.getName().equalsIgnoreCase("item"))
                        {
                            insideItem=true;

                        }
                        else if(xpp.getName().equalsIgnoreCase("title"))
                        {
                            if(insideItem)
                            {
                                titles.add(xpp.nextText());
                            }
                        }
                        else if(xpp.getName().equalsIgnoreCase("link"))
                        {
                            if(insideItem)
                            {
                                links.add(xpp.nextText());
                            }
                        }
                    }
                    else if(eventType==XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase(("item")))
                    {
                        insideItem=false;
                    }
                    eventType=xpp.next();
                }

            }catch(MalformedURLException e)
            {
                exception=e;
            }
            catch(XmlPullParserException e)
            {
                exception=e;
            }
            catch(IOException e)
            {
                exception=e;
            }



            return exception;
        }

        @Override
        protected void onPostExecute(Exception s)
        {
            super.onPostExecute(s);
            ArrayAdapter<String>adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,titles);
            lvRSS.setAdapter(adapter);
            progressDialog.dismiss();
        }
    }

}