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

    public String fill(ArrayList<User> userList, ArrayList<String> ids) {

       // User user = new User();
        int k=0;
        for (int i = 0; i < ids.size(); i++) {

            User user = new User();
            user.setId(ids.get(i));
            userList.add(user);

            // usersArrayList.add(user);
k++;

           // return "karina";
        }

        return String.valueOf(k);
    }
}
