package com.example.ulas_.worldofwarcraftapi;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class FetchZone extends AsyncTask<String, Void, String> {
    private ArrayList<Zone> lZones;
    private RecyclerView aRecyclerView;
    private RecyclerView.Adapter aAdapter;
    Context c;
    private String filter;
    public static  ArrayList<String> bossHealthList,bossLevelList,bossDescList,bossNameList,heroicLevelList,heroicHealthList,NormalMode,HeroicMode;
    public FetchZone(ArrayList<Zone> listofZones) {
        lZones = listofZones;
    }

    public FetchZone(ZoneAdapter mAdapter, RecyclerView mRecyclerView, Context con, String filter) {
        aAdapter = mAdapter;
        aRecyclerView = mRecyclerView;
        c = con;

        this.filter = filter;
    }

    @Override
    protected String doInBackground(String... strings) {
        return NetworkUtils.getZoneInfo(strings[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        lZones = new ArrayList<Zone>();
        super.onPostExecute(s);

        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray itemsArray = jsonObject.getJSONArray("zones");

           // Log.d("num2", String.valueOf(itemsArray.length()));
            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject zone = itemsArray.getJSONObject(i);
                String name = null;
                String description = null;
                String location = null;
                String advisedMinLevel = null;
                String advisedMaxLevel = null;
                String bosses = "";
                String bossHealth = "";
                String bossLevel = "";
                int expansionID = 0 ;
                int expansionLogo = 0;
                String expansionText = "";
                String advisedGearMin = null;
                bossHealthList = new ArrayList<String>();
                bossLevelList = new ArrayList<String>();
                bossDescList = new ArrayList<String>();
                bossNameList = new ArrayList<String>();

                heroicLevelList = new ArrayList<String>();
                heroicHealthList = new ArrayList<String>();
                NormalMode = new ArrayList<String>();
                HeroicMode = new ArrayList<String>();

                try {
                    try {
                        JSONArray bossArray = zone.getJSONArray("bosses");
                        for (int k = 0; k < bossArray.length(); k++) {
                            JSONObject boss = bossArray.getJSONObject(k);
                            //Log.d("boss",  boss.getString("name"));
                            bosses += boss.getString("name") +"\n" ;
                            bossHealth +="HP " + boss.getString("health")+"\n";
                            bossLevel += boss.getString("level")+" lvl.\n";

                            bossHealthList.add(boss.getString("health"));
                            bossLevelList.add(boss.getString("level"));
                            bossNameList.add(boss.getString("name"));

                            if(boss.has("description")){
                                bossDescList.add(boss.getString("description"));
                            }
                            else{
                                bossDescList.add("No Description");
                            }
                            if(boss.getString("availableInNormalMode").equals("true")){
                                NormalMode.add("Available");
                            }
                            else{
                                NormalMode.add("Not Available");
                            }
                            if(boss.getString("availableInHeroicMode").equals("true")){
                                HeroicMode.add("Available");
                            }
                            else{
                                HeroicMode.add("Not Available");
                            }

                            heroicLevelList.add(boss.getString("heroicLevel"));
                            heroicHealthList.add(boss.getString("heroicHealth"));
                        }
                    } catch (Exception e) {
                       bosses = "No boss in this floor";
                    }
                    try {
                        expansionID = zone.getInt("expansionId");
                        switch (expansionID){
                            case 0:
                                expansionText = "Vanilla";
                                expansionLogo = 0;
                                break;
                            case 1:
                                expansionText = "The Burning Crusade";
                                expansionLogo = 1;
                                break;
                            case 2:
                                expansionText = "Wrath of the Lich King";
                                expansionLogo = 2;
                                break;
                            case 3:
                                expansionText = "Cataclysm";
                                expansionLogo = 3;
                                break;
                            case 4:
                                expansionText = "Mists of Pandaria";
                                expansionLogo = 4;
                                break;
                            case 5:
                                expansionText = "Warlords of Draenor";
                                expansionLogo = 5;
                                break;
                            case 6:
                                expansionText = "Legion";
                                expansionLogo = 6;
                                break;
                            case 7:
                                expansionText = "Battle for Azeroth";
                                expansionLogo = 7;
                                break;
                            default:
                                expansionText = "Vanilla";
                                expansionLogo = 0;
                                break;
                        }
                    } catch (Exception e) {
                        expansionText = "unkown";
                    }

                    try {
                        name = zone.getString("name");
                    } catch (Exception e) {
                        name = "unknown";
                    }
                    try {
                        description = zone.getString("description");
                        if(description.equals("")){
                            description = "No Description";
                        }
                    } catch (Exception e) {
                        description = "No Description";
                    }
                    try {
                         location = zone.getJSONObject("location").getString("name");
                    } catch (Exception e) {
                        location = "unknown";
                    }
                    try {
                        advisedMinLevel = "Min Level : " + zone.getString("advisedMinLevel");
                    } catch (Exception e) {
                        advisedMinLevel = "unknown";
                    }
                    try {
                        advisedMaxLevel = "Max Level : " +zone.getString("advisedMaxLevel");
                    } catch (Exception e) {
                        advisedMaxLevel = "unknown";
                    }
                    try {
                        advisedGearMin = "Minimum Gear Level : " +zone.getString("lfgNormalMinGearLevel");
                    } catch (Exception e) {
                        advisedGearMin = "unknown";
                    }

                    if(name.toLowerCase().contains(filter.toLowerCase())){
                        Zone dummy = new Zone(name, description, location, advisedMinLevel, advisedMaxLevel,bosses,bossHealth,bossLevel,expansionText,expansionLogo,advisedGearMin,bossHealthList,bossNameList,bossLevelList,bossDescList,heroicLevelList,heroicHealthList,NormalMode,HeroicMode);
                        lZones.add(dummy);
                    }

                   // Log.d("neoluyo", lZones.get(0).getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                aAdapter = new ZoneAdapter(c, lZones);
                aRecyclerView.setAdapter(aAdapter);
                //Log.d("num", String.valueOf(lZones.size()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
