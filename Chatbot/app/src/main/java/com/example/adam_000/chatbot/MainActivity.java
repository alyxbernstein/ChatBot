package com.example.adam_000.chatbot;

import android.content.ComponentName;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/*
TODO: chrome custom tabs
TODO: snarky responses
TODO: RecyclerView
TODO: responses
*/
public class MainActivity extends AppCompatActivity {
    private static final String CUSTOM_TAB_PACKAGE_NAME = "com.android.chrome";
    int count = 0;
    TextView userIn;
    TextView botOut;
    CustomTabsServiceConnection mCustomTabsServiceConnection;
    CustomTabsClient mClient;
    CustomTabsSession mCustomTabsSession;
    CustomTabsIntent customTabsIntent;
    String URL;
    String site;
    Color toolbarColor;
    ArrayList<String> userInput = new ArrayList<String>();
    ArrayList<String> botOutput = new ArrayList<String>();
    public String prepURL(ArrayList<String> search){
        String temp = "https://google.com/search?espv=2&q=site%3A" + site;
        for (String keyword : search){
            URL += "+" + keyword;
        }
        return temp;
    }

    public void goToWebpage(String temp){
        //go to webpage -
        URL = temp;
        Random random = new Random();
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        customTabsIntent = new CustomTabsIntent.Builder(mCustomTabsSession)
                .setToolbarColor(Color.rgb(r, g, b))
                .setShowTitle(true)
                .build();
        customTabsIntent.launchUrl(MainActivity.this, Uri.parse(URL));

    }
    public void chat(String in, int i, EditText e){
        String b = "User: ";
        String c = in + b;

        switch (i){
            case 0:
                userIn = (TextView)findViewById(R.id.userIn1);
                userIn.setText(c);
                e.setText("");
                c.toLowerCase();
                userInput.add(c);
                if (c.contains("hi") || c.contains("hello") || c.contains("hey")){
                    botOut = (TextView)findViewById(R.id.botOut1);
                    String d = "ShopBot: Hello, how are you?";
                    botOut.setText(d);
                    botOutput.add(d);
                    count++;
                    break;
                } else {
                    String d = "I'm sorry, I don't understand";
                    botOut = (TextView) findViewById(R.id.botOut1);
                    botOut.setText(d);
                    break;
                }
            case 1:
                userIn = (TextView)findViewById(R.id.userIn2);
                userIn.setText(c);
                e.setText("");
                c.toLowerCase();
                userInput.add(c);
                if (c.contains("fine") || c.contains("ok")){
                    TextView botOut = (TextView)findViewById(R.id.botOut2);
                    String f;
                    if (c.contains("fine")){
                        f = "fine";
                    } else {
                        f = "okay";
                    }
                    String d = "ShopBot: Just " + f + "?\nWould you like to buy something?";
                    botOut.setText(d);
                    botOutput.add(d);
                    count++;
                    break;
                } else if (c.contains("good") || c.contains("great")){
                    botOut = (TextView)findViewById(R.id.botOut2);
                    String f;
                    if (c.contains("great")){
                        f = "great";
                    } else {
                        f = "good";
                    } String d = "ShopBot: I'm glad you're feeling  " + f + "!\nWould you like to buy something?";
                    botOut.setText(d);
                    botOutput.add(d);
                    count++;
                    break;
                } else {
                    String d = "I'm sorry, I don't understand";
                    botOut = (TextView)findViewById(R.id.botOut2);
                    botOut.setText(d);
                    break;
                }
            case 2:
                userIn = (TextView)findViewById(R.id.userIn3);
                userIn.setText(c);
                e.setText("");
                c.toLowerCase();
                userInput.add(c);
                if (c.contains("shirt")){

                } else if (c.contains("pants")){

                } else if (c.contains("phone")){
                    //rant about how horrible the iPhone is, tell person to buy n5x or n6p
                    count = 3;
                    String d = "I'm going to assume you want an iPhone. I, however, was programmed in Android. Therefore, I mus compel you to purchase a Nexus Device. Would you like a nexus 6p or 5x?";
                    botOut.setText(d);
                    botOutput.add(d);
                    break;
                } else if (c.contains("laptop")){
                    //rant about how horrible the iPhone is, tell person to buy hp spectre x360
                    site = "bestbuy.com";
                } else if (c.contains("console")){

                } else if (c.contains("watch")){
                    //rant about how horrible apple watch is, tell person to buy moto 360
                } else {
                    String d = "I'm sorry, I don't understand";
                    botOut = (TextView)findViewById(R.id.botOut3);
                    botOut.setText(d);
                    break;
                }
            case 3:
                userIn = (TextView)findViewById(R.id.userIn4);
                userIn.setText(c);
                e.setText("");
                c.toLowerCase();
                userInput.add(c);
                if (c.contains("6p")){
                    String newURL = "https://store.google.com/product/nexus_6p";
                    goToWebpage(newURL);
                    break;
                } else if (c.contains("5x")){
                    String newURL = "https://store.google.com/product/nexus_5x";
                    goToWebpage(newURL);
                    break;
                } else {
                    String d = "I'm sorry, I don't understand";
                    botOut = (TextView)findViewById(R.id.botOut4);
                    botOut.setText(d);
                    break;
                }
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCustomTabsServiceConnection = new CustomTabsServiceConnection() {
            @Override
            public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
                //Pre-warming
                mClient = customTabsClient;
                mClient.warmup(0L);
                mCustomTabsSession = mClient.newSession(null);
                CustomTabsClient.bindCustomTabsService(MainActivity.this, CUSTOM_TAB_PACKAGE_NAME, mCustomTabsServiceConnection);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                mClient = null;
            }
        };
        Button enter = (Button)findViewById(R.id.enter);
        enter.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText input = (EditText)findViewById(R.id.input);
                String a = input.getText().toString();
                chat(a, count, input);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
