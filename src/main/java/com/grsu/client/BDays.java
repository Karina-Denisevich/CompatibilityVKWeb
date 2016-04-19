package com.grsu.client;

import com.grsu.kursWork.VKScribe;
import com.grsu.user.Info;
import com.grsu.user.User;

import java.util.ArrayList;

public class BDays implements Filling<ArrayList<String>> {

    public void fill(ArrayList<User> usersArrayList, ArrayList<String> bdates) {

        for (int i = 0; i < usersArrayList.size(); i++) {

            if (bdates.get(i) != null) {

                usersArrayList.get(i).setbDay(bdates.get(i));
            }
        }
    }


    public ArrayList<String> getBDays(ArrayList<User> usersArrayList, VKScribe vk, String accessToken) {

        Info info = new Info();

        ArrayList<String> bdates = new ArrayList<String>();

        for (User anUsersArrayList : usersArrayList) {

            bdates.add(info.getInfo(vk, accessToken, anUsersArrayList.getId(), "bdate"));
        }

        return bdates;
    }
}
