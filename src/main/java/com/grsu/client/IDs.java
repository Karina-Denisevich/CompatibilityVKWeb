package com.grsu.client;

import com.grsu.user.User;

import java.util.ArrayList;

//public class IDs implements Filling<ArrayList<String>> {
//
//    public void fill(ArrayList<User> usersArrayList, ArrayList<String> ids) {
//
//        for (String id : ids) {
//            User user = new User();
//
//            user.setId(id);
//            usersArrayList.add(user);
//        }
//    }
//}


public class IDs {

    public void fill(ArrayList<User> userList, ArrayList<String> ids) {

        for (int i = 0; i < ids.size(); i++) {

            User user = new User();

            user.setId(ids.get(i));
            userList.add(user);
        }
    }
}
