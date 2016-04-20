package com.grsu.client;

import com.grsu.user.SexEnum;
import com.grsu.user.User;

import java.util.ArrayList;

public class Sex  {



    public void fill(ArrayList<User> user, ArrayList<String> sex) {

        for (int i = 0; i < user.size(); i++) {

            user.get(i).setSex(sex.get(i));
        }

    }


//    public void fill(ArrayList<User> usersArrayList, ArrayList<String> sex) {
//
//        for (int i = 0; i < usersArrayList.size(); i++) {
//
//            usersArrayList.get(i).setSex(sex.get(i));
//        }
//
//    }

    public boolean isTheSameSex(SexEnum sex1, SexEnum sex2) {

        return sex1.toString().equals("female") && sex2.toString().equals("female")
                || sex1.toString().equals("male") && sex2.toString().equals("male");
    }
}
