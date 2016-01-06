package com.example.adam_000.chatbot;

import android.content.ComponentName;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    int conversationState = 0;
    private TextView userIn;
    private TextView botOut;
    private EditText input;
    private CustomTabsServiceConnection mCustomTabsServiceConnection;
    private CustomTabsClient mClient;
    private CustomTabsSession mCustomTabsSession;

    private String site;
    private ArrayList<String> userInput = new ArrayList<String>();
    private ArrayList<String> botOutput = new ArrayList<String>();
    private ArrayList<String> keywords = new ArrayList<String>();


    private void goToWebpage(String URL){
        //go to webpage -
        Random random = new Random();
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder(mCustomTabsSession)
                .setToolbarColor(Color.rgb(r,g,b))
                .setShowTitle(true)
                .build();
        customTabsIntent.launchUrl(MainActivity.this, Uri.parse(URL));

    }

    public void chat(){
        String in = input.getText().toString();
        String b = "User: ";
        String userInputText = b + in;

        switch (conversationState) {
            case 0:
                userIn = (TextView)findViewById(R.id.userIn1);
                userIn.setText(userInputText);
                input.setText("");
                userInputText = userInputText.toLowerCase();
                userInput.add(userInputText);
                if (userInputText.contains("hi") || userInputText.contains("hello") || userInputText.contains("hey")){
                    botOut = (TextView)findViewById(R.id.botOut1);
                    String d = "ShopBot: Hello, how are you?";
                    botOut.setText(d);
                    botOutput.add(d);
                    conversationState++;
                } else {
                    String d = "I'm sorry, I don't understand";
                    botOut = (TextView) findViewById(R.id.botOut1);
                    botOut.setText(d);
                }
                break;
            case 1:
                userIn = (TextView)findViewById(R.id.userIn2);
                userIn.setText(userInputText);
                input.setText("");
                userInputText = userInputText.toLowerCase();
                userInput.add(userInputText);
                if (userInputText.contains("fine") || userInputText.contains("ok")){
                    TextView botOut = (TextView)findViewById(R.id.botOut2);
                    String f;
                    if (userInputText.contains("fine")){
                        f = "fine";
                    } else {
                        f = "okay";
                    }
                    String d = "ShopBot: Just " + f + "?\nWould you like to buy something?";
                    botOut.setText(d);
                    botOutput.add(d);
                    conversationState++;
                } else if (userInputText.contains("good") || userInputText.contains("great")||userInputText.contains("dandy")){
                    botOut = (TextView)findViewById(R.id.botOut2);
                    String f;
                    if (userInputText.contains("great")){
                        f = "great";
                    } else if (userInputText.contains("dandy")){
                        f = "dandy";
                    } else {
                        f = "good";
                    } String d = "ShopBot: I'm glad you're feeling " + f + "!\nWould you like to buy a phone or a laptop?";
                    botOut.setText(d);
                    botOutput.add(d);
                    conversationState++;
                } else {
                    String d = "I'm sorry, I don't understand";
                    botOut = (TextView)findViewById(R.id.botOut2);
                    botOut.setText(d);
                }
                break;
            case 2:
                userIn = (TextView)findViewById(R.id.userIn3);
                userIn.setText(userInputText);
                input.setText("");
                userInputText = userInputText.toLowerCase();
                userInput.add(userInputText);
                botOut = (TextView)findViewById(R.id.botOut3);
                String d = "ShopBot: OKay, phone it is! Would you like Android or iPhone?";
                botOut.setText(d);
                conversationState++;
                break;
            case 3:
                userIn = (TextView)findViewById(R.id.userIn4);
                userIn.setText(userInputText);
                input.setText("");
                userInputText = userInputText.toLowerCase();
                userInput.add(userInputText);
                botOut = (TextView)findViewById(R.id.botOut4);
                d = "ShopBot: That's great, you want an iPhone. Would you like a 5s, 6, or 6s?";
                botOut.setText(d);
                conversationState++;
                break;
            case 4:
                userIn = (TextView)findViewById(R.id.userIn5);
                userIn.setText(userInputText);
                input.setText("");
                userInputText = userInputText.toLowerCase();
                userInput.add(userInputText);
                botOut = (TextView)findViewById(R.id.botOut5);
                d = "ShopBot: Give me a second to find your result.";
                botOut.setText(d);
                goToWebpage("http://www.apple.com/shop/buy-iphone/iphone6s");
        }
    }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText)findViewById(R.id.input);
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
                chat();
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
