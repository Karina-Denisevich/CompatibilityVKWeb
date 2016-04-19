package com.grsu.client;

import com.grsu.kursWork.VKScribe;
import com.grsu.user.Info;
import com.grsu.user.User;

import java.util.ArrayList;

public class IDs implements Filling<ArrayList<String>> {

    public void fill(ArrayList<User> usersArrayList, ArrayList<String> ids) {

        for (String id : ids) {

            User user = new User();

            user.setId(id);
            usersArrayList.add(user);
        }
    }

    public ArrayList<String> getIDs(VKScribe vk, String accessToken, ArrayList<String> ids) {

        Info info = new Info();

        ArrayList<String> goodIds = new ArrayList<String>();

        for (String id : ids) {

            goodIds.add(info.getInfo(vk, accessToken, id, "uid"));
        }

        return goodIds;
    }
}
