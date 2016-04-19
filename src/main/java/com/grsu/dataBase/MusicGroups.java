package com.grsu.dataBase;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MusicGroups {

    private String groupName;
    private ArrayList<String> genres = new ArrayList<String>();

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(String genres) {

        Pattern p = Pattern.compile("[A-z]+((\\s|\\-)[A-z]*)*");
        Matcher m = p.matcher(genres);

        while (m.find()) {

            this.genres.add(m.group());
        }
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
