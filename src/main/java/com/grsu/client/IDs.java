package com.grsu.client;

import com.grsu.user.User;

import java.util.ArrayList;


public class IDs implements Filling<ArrayList<String>>{

    public void fill(ArrayList<User> userList, ArrayList<String> ids) {

        for (String id : ids) {

            User user = new User();

            user.setId(id);
            userList.add(user);
        }
    }
}
