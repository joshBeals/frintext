package com.example.frintext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class Dashboard extends AppCompatActivity {

    private CardView wifiBtn;
    private CardView hotspotBtn;
    private ImageView va;
    private ImageView conn;
    private ImageView chat;
    private CardView aboutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        va = (ImageView) findViewById(R.id.vaImg);
        conn = (ImageView) findViewById(R.id.speak);
        chat = (ImageView) findViewById(R.id.chat);

        va.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, VirtualAssistant.class);
                startActivity(intent);
                finish();
            }
        });

        conn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, WifiConn.class);
                startActivity(intent);
                finish();
            }
        });

        chat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, WifiConn.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
