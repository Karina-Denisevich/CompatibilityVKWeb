package com.grsu.client;

import com.grsu.kursWork.VKScribe;
import com.grsu.user.Info;
import com.grsu.user.SexEnum;
import com.grsu.user.User;

import java.util.ArrayList;

public class Sex implements Filling<ArrayList<String>> {

    public void fill(ArrayList<User> usersArrayList, ArrayList<String> sex) {

        for (int i = 0; i < usersArrayList.size(); i++) {

            usersArrayList.get(i).setSex(sex.get(i));
        }

    }


    public ArrayList<String> getSex(ArrayList<User> usersArrayList, VKScribe vk, String accessToken) {

        Info info = new Info();

        ArrayList<String> sex = new ArrayList<String>();

        for (User anUsersArrayList : usersArrayList) {

            sex.add(info.getInfo(vk, accessToken, anUsersArrayList.getId(), "sex"));
        }

        return sex;
    }

    public boolean isTheSameSex(SexEnum sex1, SexEnum sex2) {

        return sex1.toString().equals("female") && sex2.toString().equals("female")
                || sex1.toString().equals("male") && sex2.toString().equals("male");
    }
}
