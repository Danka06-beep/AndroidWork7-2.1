package com.example.androidwork7_21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText text;
Button searchbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
        searchbtn = findViewById(R.id.searchbtn);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean temp = false;
                String input = text.getText().toString();
                for(int i = 0 ; i < input.length(); i++){
                    if(Character.isLetter(input.charAt(i))){
                        temp =true;
                        break;
                    }
                }
                if (input.equals("")){
                    Toast.makeText(MainActivity.this, "Поле ввода пустое", Toast.LENGTH_LONG).show();
                }else if(temp){
                    String geo = "geo:?q=" + input;
                    Uri uri = Uri.parse(geo);
                    intent.setData(uri);
                }else{
                    String geo = "geo:" + input;
                    Uri uri = Uri.parse(geo);
                    intent.setData(uri);
                }
                startActivity(intent);
            }
        });
    }
}