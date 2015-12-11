package com.example.adam_000.chatbot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    ArrayList<String> userInput = new ArrayList<String>();
    ArrayList<String> botOutput = new ArrayList<String>();
    public void chat(String in, int i, EditText e){
        String b = "User: ";
        String c = in + b;
        if (i == 0){
            TextView userIn = (TextView)findViewById(R.id.userIn1);
            userIn.setText(c);
            e.setText("");
            c.toLowerCase();
            userInput.add(c);
            if (c.contains("hi") || c.contains("hello") || c.contains("hey")){
                TextView botOut = (TextView)findViewById(R.id.botOut1);
                String d = "ShopBot: Hello, how are you?";
                botOut.setText(d);
                botOutput.add(d);
            } else {
                String d = "I'm sorry, I don't understand";
                TextView botOut = (TextView)findViewById(R.id.botOut1);
                botOut.setText(d);
                count = 1;
            }
        } else if (i == 1){
            TextView userIn = (TextView)findViewById(R.id.userIn2);
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
            } else if (c.contains("good") || c.contains("great")){

            } else if (c.contains("bad")){
                
            }
        } else if (i == 2){

        } else if (i == 3){

        } else if(i == 4){

        } else {
            String a = e.getText().toString();
            count = 0;
            chat(a, count, e);
        }
        i++;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button enter = (Button)findViewById(R.id.enter);
        enter.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText input = (EditText)findViewById(R.id.input);
                String a = input.getText().toString();
                chat(a, count, input);
                count++;
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
