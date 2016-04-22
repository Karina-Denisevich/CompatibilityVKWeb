package com.grsu.client;

import com.grsu.user.User;

import java.util.ArrayList;

public class BDays implements Filling<ArrayList<String>> {

    public void fill(ArrayList<User> user, ArrayList<String> bdates) {

        for (int i = 0; i < user.size(); i++) {

            user.get(i).setbDay(bdates.get(i));
        }
    }
}
