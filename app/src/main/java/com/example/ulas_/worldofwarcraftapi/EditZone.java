package com.example.ulas_.worldofwarcraftapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class EditZone extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edit_zone);
        final Zone uobj = getIntent().getParcelableExtra("datasent");

        TextView txtTittle=findViewById(R.id.txtTittle);
        TextView txtDescription=findViewById(R.id.txtDescription);
        TextView txtLocation=findViewById(R.id.txtLocation);
        TextView txtMaxLevel=findViewById(R.id.txtMaxLevel);
        TextView txtMinLevel=findViewById(R.id.txtMinLevel);
        TextView txtBossName=findViewById(R.id.txtBossName);
        TextView bossHealth=findViewById(R.id.bossHealth);
        TextView bossLevel=findViewById(R.id.bossLevel);
        TextView txtExpansion=findViewById(R.id.txtExpansion);
        TextView txtMinGearLevel = findViewById(R.id.txtMinGearLevel);
        ImageView expansionLogo = findViewById(R.id.imageView7);
        LinearLayout layout_bosses = findViewById(R.id.layout_bosses);
        int logoIndex = uobj.getExpansionLogo();

        switch (logoIndex){
            case 0:
                expansionLogo.setImageResource(R.drawable.vanilla64);
                break;
            case 1:
                expansionLogo.setImageResource(R.drawable.burning64);
                break;
            case 2:
                expansionLogo.setImageResource(R.drawable.lich64);
                break;
            case 3:
                expansionLogo.setImageResource(R.drawable.catacly64);
                break;
            case 4:
                expansionLogo.setImageResource(R.drawable.pandaria64);
                break;
            case 5:
                expansionLogo.setImageResource(R.drawable.warlords64);
                break;
            case 6:
                expansionLogo.setImageResource(R.drawable.legion64);
                break;
            case 7:
                expansionLogo.setImageResource(R.drawable.battleof64);
                break;
        }
        txtTittle.setText(uobj.getName());
        txtDescription.setText(uobj.getDescription());
        txtLocation.setText(uobj.getLocation());
        txtMaxLevel.setText(uobj.getAdvisedMinLevel());
        txtMinLevel.setText(uobj.getAdvisedMaxLevel());
        txtBossName.setText(uobj.getBosses());
        bossHealth.setText(uobj.getBossHealth());
        bossLevel.setText(uobj.getBossLevel());
        txtExpansion.setText(uobj.getExpansionID());
        txtMinGearLevel.setText(uobj.getAdvisedGearMin());

        layout_bosses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(EditZone.this, BossDetails.class);

               intent.putExtra("healthlist",uobj.getBossHealthList());
               intent.putExtra("namelist",uobj.getBossNameList());
               intent.putExtra("levellist",uobj.getBossLevelList());
               intent.putExtra("descriptionlist",uobj.getBossDescList());

                intent.putExtra("heroicHealthList",uobj.getHeroicHealthList());
                intent.putExtra("heroicLevelList",uobj.getHeroicLeveLlist());
                intent.putExtra("NormalMode",uobj.getNormalModeList());
                intent.putExtra("HeroicMode",uobj.getHeroicModeList());

               startActivity(intent);
            }

        });

    }
}
