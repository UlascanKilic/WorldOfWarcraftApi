package com.example.ulas_.worldofwarcraftapi;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Layout;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class BossDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boss_details);
        ArrayList<String> health = getIntent().getStringArrayListExtra("healthlist");
        ArrayList<String> name = getIntent().getStringArrayListExtra("namelist");
        ArrayList<String> level = getIntent().getStringArrayListExtra("levellist");
        ArrayList<String> desc = getIntent().getStringArrayListExtra("descriptionlist");

        ArrayList<String> HeroicHealth = getIntent().getStringArrayListExtra("heroicHealthList");
        ArrayList<String> HeroicLevel = getIntent().getStringArrayListExtra("heroicLevelList");
        ArrayList<String> NormalMode = getIntent().getStringArrayListExtra("NormalMode");
        ArrayList<String> HeroicMode = getIntent().getStringArrayListExtra("HeroicMode");

        Object nameObj = name.get(0);
        ArrayList<String> nameArray = (ArrayList<String>) nameObj;

        Object descObj = desc.get(0);
        ArrayList<String> descArray = (ArrayList<String>) descObj;

        Object levelObj = level.get(0);
        ArrayList<String> levelArray = (ArrayList<String>) levelObj;

        Object healthObj = health.get(0);
        ArrayList<String> healthArray = (ArrayList<String>) healthObj;

        Object heroicHealth = HeroicHealth.get(0);
        ArrayList<String> heroicHealthArray = (ArrayList<String>) heroicHealth;

        Object heroicLevelObj = HeroicLevel.get(0);
        ArrayList<String> heroicLevelArray = (ArrayList<String>) heroicLevelObj;

        Object NormalModeObj = NormalMode.get(0);
        ArrayList<String> NormalModeArray = (ArrayList<String>) NormalModeObj;

        Object HeroicModeObj = HeroicMode.get(0);
        ArrayList<String> HeroicModeArray = (ArrayList<String>) HeroicModeObj;

        LinearLayout root = findViewById(R.id.my_root);
        for(int i =0;i < nameArray.size(); i++){
            String tempUrl = nameArray.get(i);
            tempUrl = tempUrl.replace("'","%27");
            tempUrl = tempUrl.replace(" ","_");

            String dynamicUrl = "http://wowwiki.wikia.com/wiki/"+tempUrl;

            LinearLayout childLayout = new LinearLayout(this);
            childLayout.setOrientation(LinearLayout.VERTICAL);

            TextView tvLink = new TextView(this);
            TextView tvName = new TextView(this);
            TextView tvDesc = new TextView(this);
            TextView tvLevel = new TextView(this);
            TextView tvHealth = new TextView(this);
            TextView tvHeroicLevel = new TextView(this);
            TextView tvHeroicHealth = new TextView(this);
            TextView tvNormalMode = new TextView(this);
            TextView tvHeroicMode = new TextView(this);

            tvName.setTextColor(Color.BLACK);
            tvName.setGravity(Gravity.CENTER);
            tvName.setTextSize(20);
            tvName.setPadding(0,0,0,10);
            tvName.setTextColor(getResources().getColor(R.color.baslik));
            tvName.setTypeface(Typeface.DEFAULT_BOLD);
            tvHealth.setPadding(0,0,0,10);

            tvLink.setGravity(Gravity.CENTER);
            tvLink.setPadding(0,0,0,10);
            setTextViewProps(tvDesc);
            setTextViewProps(tvLevel);
            setTextViewProps(tvHealth);

            setTextViewProps(tvHeroicLevel);
            setTextViewProps(tvHeroicHealth);
            setTextViewProps(tvNormalMode);
            setTextViewProps(tvHeroicMode);

            tvHeroicMode.setTextColor(getResources().getColor(R.color.baslik));
            tvNormalMode.setTextColor(getResources().getColor(R.color.baslik));

          //  tvLevel.setCompoundDrawablesWithIntrinsicBounds( 0, R.drawable.zirh, 0, 0);
          //  tvHealth.setCompoundDrawablesWithIntrinsicBounds(0,  R.drawable.kalkan, 0, 0);

            tvName.setText(nameArray.get(i));
            tvDesc.setText(descArray.get(i));

            tvNormalMode.setText("Normal Mode is "+NormalModeArray.get(i));
            tvLevel.setText("Level : "+levelArray.get(i));
            tvHealth.setText("Health : "+healthArray.get(i));
            tvHeroicMode.setText("Heroic Mode is "+HeroicModeArray.get(i));

            if(HeroicModeArray.get(i).equals("Not Available")){
               tvHeroicHealth.setVisibility(View.INVISIBLE);
               tvHeroicLevel.setVisibility(View.INVISIBLE);
            }
            else{
                tvHeroicLevel.setText("Heroic Level : "+heroicLevelArray.get(i));
                tvHeroicHealth.setText("Heroic Health : "+heroicHealthArray.get(i));
            }

            tvLink.setText(
                    Html.fromHtml("<a href="+dynamicUrl+">Click here for more details!</a>"));
            tvLink.setMovementMethod(LinkMovementMethod.getInstance());
            tvLink.setLinksClickable(true);
            childLayout.addView(tvName);
            childLayout.addView(tvDesc);

            childLayout.addView(tvNormalMode);
            childLayout.addView(tvLevel);
            childLayout.addView(tvHealth);

            childLayout.addView(tvHeroicMode);
            childLayout.addView(tvHeroicLevel);
            childLayout.addView(tvHeroicHealth);
            childLayout.addView(tvLink);
            root.addView(childLayout);
        }
    }
    public void setTextViewProps(TextView tv){
        tv.setTextColor(Color.BLACK);
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(15);
        tv.setPadding(0,0,0,10);
        tv.setTextColor(Color.BLACK);
        tv.setTypeface(Typeface.DEFAULT_BOLD);
    }
}
