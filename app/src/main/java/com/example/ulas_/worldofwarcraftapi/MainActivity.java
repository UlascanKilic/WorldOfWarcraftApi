package com.example.ulas_.worldofwarcraftapi;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ZoneAdapter zAdapter;
    TextView txtZone;
    ArrayList<Zone> listofZones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void searchZones(View view){
        listofZones = new ArrayList<Zone>();
        EditText e=findViewById(R.id.plain_text_input);
        String search=e.getText().toString();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        new FetchZone(zAdapter,mRecyclerView,this,search).execute(search);
    }
}
