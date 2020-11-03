package com.example.frintext;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Locale;

public class VirtualAssistant extends AppCompatActivity {

    private ImageView goBack;
    private ImageView startSpeaking;

    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virtual_assistant);

        goBack = (ImageView) findViewById(R.id.back);
        startSpeaking = (ImageView) findViewById(R.id.speak);
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i == TextToSpeech.SUCCESS){
                    int lang = textToSpeech.setLanguage(Locale.UK);
                }
            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(VirtualAssistant.this, Dashboard.class);
                startActivity(intent);
                finish();
            }
        });

        startSpeaking.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // To call the voice command
                voiceautomation();
            }
        });
    }

    private void voiceautomation() {

        Intent voice = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        voice.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        voice.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        voice.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say Something...");
        startActivityForResult(voice, 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK && data != null){
            ArrayList<String> arrayList = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (arrayList.get(0).toString().equals("hello deborah")){
                int speech = textToSpeech.speak("hello friend, how may i help you?",TextToSpeech.QUEUE_FLUSH,null);
            }
            if (arrayList.get(0).toString().equals("hello Deborah")){
                int speech = textToSpeech.speak("hello friend, how may i help you?",TextToSpeech.QUEUE_FLUSH,null);
            }
            if (arrayList.get(0).toString().equals("who are you")){
                int speech = textToSpeech.speak("my name is deborah, i'm a skinny but pretty robot that loves to have fun. currently single but not searching. i'm here for you friend. Ask me any question",TextToSpeech.QUEUE_FLUSH,null);
            }
            if (arrayList.get(0).toString().equals("are you a virgin")){
                int speech = textToSpeech.speak("Lol, why ask such a question now? we aren't even friends yet. Anyway, my answer is No. i'm not a virgin.",TextToSpeech.QUEUE_FLUSH,null);
            }
            if (arrayList.get(0).toString().equals("do you love cockroaches")){
                int speech = textToSpeech.speak("why do i have a feeling i'm talking to josh? you know i see those creatures as demons",TextToSpeech.QUEUE_FLUSH,null);
            }
            if (arrayList.get(0).toString().equals("do you love Cockroaches")){
                int speech = textToSpeech.speak("why do i have a feeling i'm talking to josh? you know i see those creatures as demons",TextToSpeech.QUEUE_FLUSH,null);
            }
            if (arrayList.get(0).toString().equals("what can you do")){
                int speech = textToSpeech.speak("i'm capable of doing a lot of things. from opening your camera, to opening your messages, to opening your google search, to opening your phone book. Ask what you want and i'm here for you like the genie in the lamp",TextToSpeech.QUEUE_FLUSH,null);
            }
            if (arrayList.get(0).toString().equals("open camera")){
                int speech = textToSpeech.speak("okay friend, opening camera now",TextToSpeech.QUEUE_FLUSH,null);
                Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(camera);
            }
            if (arrayList.get(0).toString().equals("open phone book")){
                int speech = textToSpeech.speak("okay friend, opening phone book now",TextToSpeech.QUEUE_FLUSH,null);
                Intent phone = new Intent(Intent.ACTION_DIAL);
                startActivity(phone);
            }
            if (arrayList.get(0).toString().equals("open messages")){
                int speech = textToSpeech.speak("okay friend, opening messages now",TextToSpeech.QUEUE_FLUSH,null);
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.setType("vnd.android-dir/mms-sms");
                startActivity(intent);
            }
            if (arrayList.get(0).toString().equals("open browser")){
                int speech = textToSpeech.speak("okay friend, opening browser now",TextToSpeech.QUEUE_FLUSH,null);
                Intent browser = new Intent(Intent.ACTION_WEB_SEARCH);
                startActivity(browser);
            }
        }
    }
}
