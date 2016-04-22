package com.grsu.client;

import com.grsu.user.User;

import java.util.ArrayList;

public class Name implements Filling<ArrayList<String>>{

    public void fill(ArrayList<User> user, ArrayList<String> names) {

        for (int i = 0; i < user.size(); i++) {

            user.get(i).setName(names.get(i));
        }
    }
}
