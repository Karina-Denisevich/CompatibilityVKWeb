package com.grsu.fileUtils;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class Reading {

    public JSONArray readJson(String fileName, String object) {

        try {

            JSONParser parser = new JSONParser();

            
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(fileName));

            return (JSONArray) jsonObject.get(object);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
