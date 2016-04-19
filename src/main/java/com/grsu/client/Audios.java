package com.grsu.client;

import com.grsu.kursWork.VKScribe;
import com.grsu.user.Info;
import com.grsu.user.User;

import java.util.ArrayList;

public class Audios implements Filling<ArrayList<ArrayList<String>>> {

    public void fill(ArrayList<User> usersArrayList, ArrayList<ArrayList<String>> audios) {

        for (int i = 0; i < usersArrayList.size(); i++) {

            if (audios.get(i) != null) {

                usersArrayList.get(i).setAudios(audios.get(i));
            }
        }
    }


    public ArrayList<ArrayList<String>> getAudios(ArrayList<User> usersArrayList, VKScribe vk, String accessToken) {

        Info info = new Info();

        ArrayList<ArrayList<String>> allAudios = new ArrayList<ArrayList<String>>();

        for (User anUsersArrayList : usersArrayList) {

            allAudios.add(info.getAudios(vk, accessToken, anUsersArrayList.getId()));
        }

        return allAudios;
    }
}
