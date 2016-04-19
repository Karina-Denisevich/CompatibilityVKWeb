package com.grsu.kursWork;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;


public class VKScribe {

    private String appId;
    URIBuilder uriBuilder;

    private static final String AUTH_URL = "https://oauth.vk.com/authorize?client_id={APP_ID}&" +
            "scope={PERMISSIONS}" +
            "&redirect_uri={REDIRECT_URI}&display={DISPLAY}&v={API_VERSION}&response_type=token";


    private void auth() throws IOException {
        String reqUrl = AUTH_URL
                .replace("{APP_ID}", appId)
                .replace("{PERMISSIONS}", "friends,audio,groups")
                .replace("{REDIRECT_URI}", "https://oauth.vk.com/blank.html")
                .replace("{DISPLAY}", "page")
                .replace("{API_VERSION}", "5.50");
        try {
            Desktop.getDesktop().browse(new URL(reqUrl).toURI());
        } catch (URISyntaxException ex) {
            System.out.println("Get token!");
            throw new IOException(ex);
        }
    }

    public JSONArray getMethodUri(String methodName, ArrayList<NameValuePair> parametrs) {

        uriBuilder.setScheme("https").setHost("api.vk.com")
                .setPath("/method/" + methodName)
                .addParameters(parametrs);
        try {
            return getJsonArray(isCreateUri());
        } catch (Exception e) {
            return null;
        }

    }

    public VKScribe(String appId, String accessToken) throws IOException {

        this.appId = appId;
        // this.accessToken = accessToken;

        if (accessToken.equals(null) || accessToken.isEmpty()) {
            auth();
        }

        uriBuilder = new URIBuilder();
    }


    private StringWriter isCreateUri() {

        HttpResponse response = HttpConnectionAgent.connectResponse(uriBuilder);
        Integer status = response.getStatusLine().getStatusCode();

        if (status == 200) {
            StringWriter content = new StringWriter();

            try {
                IOUtils.copy(response.getEntity().getContent(), content);
                return content;
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        return null;
    }


    private JSONArray getJsonArray(StringWriter content) {

        JSONParser parser = new JSONParser();

        try {

            JSONObject jsonResp = (JSONObject) parser.parse(content.toString());
            JSONArray postsList = (JSONArray) jsonResp.get("response");

            return postsList;

        } catch (ParseException e) {
            e.printStackTrace();
            System.exit(-1);
            return null;
        }
    }
}

