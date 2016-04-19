package com.grsu.fileUtils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class Reading {

    public JSONArray readJson(String fileName, String object){

        try {

            JSONParser parser = new JSONParser();

            JSONObject jsonObject  = (JSONObject) parser.parse(new FileReader(fileName));

            return (JSONArray) jsonObject.get("zodiacs");

        }catch (Exception ex){

            System.out.println(ex.getMessage());
            return null;
        }
    }
}
