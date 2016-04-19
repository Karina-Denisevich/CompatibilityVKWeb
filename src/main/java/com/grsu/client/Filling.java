package com.grsu.client;

import com.grsu.user.User;

import java.util.ArrayList;

public interface Filling<T> {

    void fill(ArrayList<User> usersArrayList, T t);
}
