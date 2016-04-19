package com.grsu.zodiac;

import com.grsu.fileUtils.Reading;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ZodiacLoading {

    public HashMap<String, ArrayList<ZodiacsPairs>> getCompatibilities() {

        HashMap<String, ArrayList<ZodiacsPairs>> zodiacsMap = new HashMap<String, ArrayList<ZodiacsPairs>>();


        JSONArray arr = new Reading().readJson("zodiac.json", "zodiacs");

        for (int i = 0; i < arr.size(); i++) {

            JSONObject objects = (JSONObject) arr.get(i);


            JSONArray zodiacToCompareArray = (JSONArray) objects.get("zodiacsToCompare");

            ArrayList<ZodiacsPairs> parametrsList = new ArrayList<ZodiacsPairs>();
                for (int j = 0; j < zodiacToCompareArray.size(); j++){

                    JSONObject objectsToCompare = (JSONObject) zodiacToCompareArray.get(j);

                    parametrsList.add(new ZodiacsPairs(objectsToCompare.get("zodiacName").toString(),
                            objectsToCompare.get("compatibilityDescription").toString(),
                            (objectsToCompare.get("compatibilityDescriptionLove").toString()),
                            Integer.valueOf(objectsToCompare.get("interestCompatibilityFriends").toString()),
                            Integer.valueOf(objectsToCompare.get("interestCompatibilityLove").toString())
                    ));

                }

            zodiacsMap.put(objects.get("mainZodiac").toString(), parametrsList);
        }

        return zodiacsMap;
    }
}
