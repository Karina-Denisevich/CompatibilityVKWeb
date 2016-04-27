package com.grsu.fileUtils;


//import com.sun.java.util.jar.pack.Package;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Reading {

    private JSONParser parser;

    public JSONArray readJson(String fileName, String object) {

        try {

            JSONParser parser = new JSONParser();

            String text = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);

            JSONObject jsonObject = (JSONObject) parser.parse(text);

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
