package com.grsu.client;

import com.grsu.user.User;

import java.util.ArrayList;

public class Audio implements Filling<ArrayList<ArrayList<String>>>{

    public void fill(ArrayList<User> usersArrayList, ArrayList<ArrayList<String>> audios) {

        for (int i = 0; i < usersArrayList.size(); i++) {

            if (audios.get(i) != null) {

                usersArrayList.get(i).setAudios(audios.get(i));
            }
        }
    }
}
