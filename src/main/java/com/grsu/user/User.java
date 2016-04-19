package com.grsu.user;

import com.grsu.zodiac.Zodiac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User {

    private String id;
    private String bDay = "";
    private Zodiac zodiac = null;
    private SexEnum sex = null;
    private ArrayList<String> audios = new ArrayList<String>();
    private Map<String, Integer> genresMap = new HashMap<String, Integer>();

    public Map<String, Integer> getGenresMap() {
        return genresMap;
    }

    public void setGenresMap(Map<String, Integer> genresMap) {
        this.genresMap = genresMap;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public ArrayList<String> getAudios() {
        return audios;
    }

    public void setAudios(ArrayList<String> audios) {
        this.audios = audios;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = SexEnum.values()[Integer.valueOf(sex)];
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getbDay() {
        return bDay;
    }

    public void setbDay(String bDay) {
        this.bDay = bDay;
    }

    public Zodiac getZodiac() {
        return zodiac;
    }

    public void setZodiac(Zodiac zodiac) {
        this.zodiac = zodiac;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", bDay='" + bDay + '\'' +
                ", zodiac=" + zodiac +
                ", sex='" + sex + '\'' +
                '}';
    }
}
