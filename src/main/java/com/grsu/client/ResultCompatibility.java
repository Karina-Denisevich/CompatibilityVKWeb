package com.grsu.client;

import java.util.ArrayList;

public class ResultCompatibility {

    public ArrayList<String> getResultComparibility(ArrayList<String> audioComp
            , ArrayList<String> zodiacComp) {


        ArrayList<String> result = new ArrayList<String>();

        for (int i = 0; i < audioComp.size(); i++) {
            Double audio = Double.valueOf(audioComp.get(i));
            Double zodiac = Double.valueOf(zodiacComp.get(i));

            if (audio >= 0 && zodiac >= 0) {
                result.add(String.valueOf((audio + zodiac) / 2));
            } else if (zodiac < 0 && audio < 0) {
                result.add("-");
                zodiacComp.set(i, "-");
                audioComp.set(i, "-");
            } else if (zodiac < 0) {
                result.add(String.valueOf(audio));
                zodiacComp.set(i, "-");
            } else {
                result.add(String.valueOf(zodiac));
                audioComp.set(i, "-");
            }
        }

        return result;
    }
}
