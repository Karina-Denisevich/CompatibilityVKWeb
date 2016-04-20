package com.grsu.client;

import com.grsu.user.User;

import java.util.ArrayList;



public class BDays  {

    public void fill(ArrayList<User> user, ArrayList<String> bdates) {

        for (int i = 0; i < user.size(); i++) {

            user.get(i).setbDay(bdates.get(i));
        }
    }
}





//public class BDays implements Filling<ArrayList<String>> {
//
//    public void fill(ArrayList<User> usersArrayList, ArrayList<String> bdates) {
//
//        for (int i = 0; i < usersArrayList.size(); i++) {
//
//            if (bdates.get(i) != null) {
//
//                usersArrayList.get(i).setbDay(bdates.get(i));
//            }
//        }
//    }
//}
