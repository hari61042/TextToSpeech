package com.example.charitha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText input;
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.et1);

        textToSpeech= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status==TextToSpeech.SUCCESS){
                    int lang=textToSpeech.setLanguage(Locale.ENGLISH);

                }
            }
        });
    }

    public void convert(View view) {

        String str=input.getText().toString();
        int speech=textToSpeech.speak(str,TextToSpeech.QUEUE_FLUSH,null);
    }

    public void clear(View view) {
        input.setText("");
    }
}
