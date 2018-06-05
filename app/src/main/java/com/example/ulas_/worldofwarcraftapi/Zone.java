package com.example.ulas_.worldofwarcraftapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Zone extends ClassLoader implements Parcelable {
    String name;
    String description;
    String location;
    String advisedMinLevel;
    String advisedMaxLevel;
    String advisedGearMin;
    String bosses;
    String bossHealth;
    String bossLevel;
    String expansionID;
    ArrayList<String> bossHealthList,bossNameList,bossDescList,bossLevelList,heroicLeveLlist,heroicHealthList,NormalModeList,HeroicModeList;
    int expansionLogo;



    public Zone(String name, String description, String location, String advisedMinLevel, String advisedMaxLevel, String bosses, String bosshealth, String bosslevel, String expansionid, int expansionlogo,String advisedgearmin, ArrayList<String> healthlist, ArrayList<String> namelist, ArrayList<String> levellist,ArrayList<String> desclist,ArrayList<String> heroiclevel,ArrayList<String> heroichealth,ArrayList<String> normalmode,ArrayList<String> heroicmode){
        this.name = name;
        this.description = description;
        this.location = location;
        this.advisedMaxLevel = advisedMaxLevel;
        this.advisedMinLevel = advisedMinLevel;
        this.bosses = bosses;
        this.bossHealth = bosshealth;
        this.bossLevel = bosslevel;
        this.expansionID = expansionid;
        this.expansionLogo = expansionlogo;
        this.advisedGearMin = advisedgearmin;
        this.bossHealthList = healthlist;
        this.bossLevelList = levellist;
        this.bossNameList = namelist;
        this.bossDescList = desclist;
        this.heroicLeveLlist = heroiclevel;
        this.heroicHealthList = heroichealth;
        this.NormalModeList = normalmode;
        this.HeroicModeList = heroicmode;
    }

    protected Zone(Parcel in) {
        name = in.readString();
        description = in.readString();
        location = in.readString();
        advisedMinLevel = in.readString();
        advisedMaxLevel = in.readString();
        bosses = in.readString();
        bossHealth = in.readString();
        bossLevel = in.readString();
        expansionID = in.readString();
        expansionLogo = in.readInt();
        advisedGearMin = in.readString();

        bossHealthList = in.readArrayList(this);
        bossLevelList = in.readArrayList(this);
        bossNameList = in.readArrayList(this);
        bossDescList = in.readArrayList(this);

        heroicLeveLlist = in.readArrayList(this);
        heroicHealthList = in.readArrayList(this);
        NormalModeList = in.readArrayList(this);
        HeroicModeList = in.readArrayList(this);

    }

    public ArrayList<String> getHeroicLeveLlist() {
        return heroicLeveLlist;
    }

    public void setHeroicLeveLlist(ArrayList<String> heroicLeveLlist) {
        this.heroicLeveLlist = heroicLeveLlist;
    }

    public ArrayList<String> getHeroicHealthList() {
        return heroicHealthList;
    }

    public void setHeroicHealthList(ArrayList<String> heroicHealthList) {
        this.heroicHealthList = heroicHealthList;
    }

    public ArrayList<String> getNormalModeList() {
        return NormalModeList;
    }

    public void setNormalModeList(ArrayList<String> normalModeList) {
        NormalModeList = normalModeList;
    }

    public ArrayList<String> getHeroicModeList() {
        return HeroicModeList;
    }

    public void setHeroicModeList(ArrayList<String> heroicModeList) {
        HeroicModeList = heroicModeList;
    }

    public ArrayList<String> getBossHealthList() {
        return bossHealthList;
    }

    public void setBossHealthList(ArrayList<String> bossHealthList) {
        this.bossHealthList = bossHealthList;
    }

    public ArrayList<String> getBossNameList() {
        return bossNameList;
    }

    public void setBossNameList(ArrayList<String> bossNameList) {
        this.bossNameList = bossNameList;
    }

    public ArrayList<String> getBossDescList() {
        return bossDescList;
    }

    public void setBossDescList(ArrayList<String> bossDescList) {
        this.bossDescList = bossDescList;
    }

    public ArrayList<String> getBossLevelList() {
        return bossLevelList;
    }

    public void setBossLevelList(ArrayList<String> bossLevelList) {
        this.bossLevelList = bossLevelList;
    }

    public String getAdvisedGearMin() {
        return advisedGearMin;
    }

    public void setAdvisedGearMin(String advisedGearMin) {
        this.advisedGearMin = advisedGearMin;
    }

    public int getExpansionLogo() {
        return expansionLogo;
    }

    public void setExpansionLogo(int expansionLogo) {
        this.expansionLogo = expansionLogo;
    }

    public String getExpansionID() {
        return expansionID;
    }

    public void setExpansionID(String expansionID) {
        this.expansionID = expansionID;
    }

    public String getBosses() {
        return bosses;
    }

    public void setBosses(String bosses) {
        this.bosses = bosses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAdvisedMinLevel() {
        return advisedMinLevel;
    }

    public void setAdvisedMinLevel(String advisedMinLevel) {
        this.advisedMinLevel = advisedMinLevel;
    }

    public String getAdvisedMaxLevel() {
        return advisedMaxLevel;
    }

    public void setAdvisedMaxLevel(String advisedMaxLevel) {
        this.advisedMaxLevel = advisedMaxLevel;
    }

    public String getBossHealth() {
        return bossHealth;
    }

    public void setBossHealth(String bossHealth) {
        this.bossHealth = bossHealth;
    }

    public String getBossLevel() {
        return bossLevel;
    }

    public void setBossLevel(String bossLevel) {
        this.bossLevel = bossLevel;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(location);
        parcel.writeString(advisedMaxLevel);
        parcel.writeString(advisedMinLevel);
        parcel.writeString(bosses);
        parcel.writeString(bossHealth);
        parcel.writeString(bossLevel);
        parcel.writeString(expansionID);
        parcel.writeInt(expansionLogo);
        parcel.writeString(advisedGearMin);

        parcel.writeArray(new ArrayList[]{bossHealthList});
        parcel.writeArray(new ArrayList[]{bossLevelList});
        parcel.writeArray(new ArrayList[]{bossNameList});
        parcel.writeArray(new ArrayList[]{bossDescList});

        parcel.writeArray(new ArrayList[]{heroicLeveLlist});
        parcel.writeArray(new ArrayList[]{heroicHealthList});
        parcel.writeArray(new ArrayList[]{NormalModeList});
        parcel.writeArray(new ArrayList[]{HeroicModeList});

    }
    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Zone> CREATOR = new Parcelable.Creator<Zone>() {
        @Override
        public Zone createFromParcel(Parcel in) {
            return new Zone(in);
        }

        @Override
        public Zone[] newArray(int size) {
            return new Zone[size];
        }
    };


}
