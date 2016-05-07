package com.grsu.client;

import com.grsu.user.User;
import com.grsu.zodiac.Zodiac;

import java.util.ArrayList;

public class Zodiacs implements Filling<ArrayList<Zodiac>> {

    public void fill(ArrayList<User> usersArrayList, ArrayList<Zodiac> zodiacs) {

        for (int i = 0; i < usersArrayList.size(); i++) {

            usersArrayList.get(i).setZodiac(zodiacs.get(i));
        }
    }

    public ArrayList<Zodiac> getZodiacs(ArrayList<User> usersArrayList) {

        ArrayList<Zodiac> userZodiacs = new ArrayList<Zodiac>();

        for (User anUsersArrayList : usersArrayList) {

            userZodiacs.add(Zodiac.getZodiac(anUsersArrayList.getbDay()));
        }

        return userZodiacs;
    }
}
