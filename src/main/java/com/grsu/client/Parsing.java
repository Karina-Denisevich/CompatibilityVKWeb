package com.grsu.client;

import java.util.ArrayList;

public class Parsing {

    public ArrayList<String> parse(String str) {

        ArrayList<String> arr = new ArrayList<String>();

        String data;

        if(str.length() == 0){
            arr.add("");
        }

        for (int i = 0; i < str.length(); ) {

            if (str.indexOf(",") != i) {

                int end = (str.indexOf(",", i) != -1) ? str.indexOf(",", i) : str.length();
                data = str.substring(i, end);
                i += data.length() + 1;

            } else {
                data = "";
                i++;
            }

            arr.add(data);
            data = "";

        }

        return arr;
    }
}
