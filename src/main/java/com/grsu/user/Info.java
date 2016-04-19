package com.grsu.user;

import com.grsu.kursWork.VKScribe;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Info {

    public String getInfo(VKScribe vk, String accessToken, String userID, String field) {

        JSONArray methodDataJson;

        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

        // nameValuePairs.add(new BasicNameValuePair("v", "5.50"));
        nameValuePairs.add(new BasicNameValuePair("user_ids", userID));
        nameValuePairs.add(new BasicNameValuePair("access_token", accessToken));
        nameValuePairs.add(new BasicNameValuePair("fields", field));

        methodDataJson = vk.getMethodUri("users.get", nameValuePairs);

        try {

            JSONObject unicPost = null;

            unicPost = (JSONObject) methodDataJson.get(0);
            return unicPost.get(field).toString();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<String> getAudios(VKScribe vk, String accessToken, String userID) {

        ArrayList<String> sons = new ArrayList<String>();

        JSONArray methodDataJson;

        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

        nameValuePairs.add(new BasicNameValuePair("owner_id", userID));
        nameValuePairs.add(new BasicNameValuePair("access_token", accessToken));
        nameValuePairs.add(new BasicNameValuePair("count", "400"));

        methodDataJson = vk.getMethodUri("audio.get", nameValuePairs);

        try {
            JSONObject unicPost = null;

            for (int i = 1; i < methodDataJson.size(); i++) {

                unicPost = (JSONObject) methodDataJson.get(i);
                sons.add(unicPost.get("artist").toString());
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
            return null;
        }

        return sons;
    }
}
