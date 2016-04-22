package com.grsu.audio;

import com.grsu.user.User;

import java.util.ArrayList;
import java.util.Map;

public class Compatibility {

    public ArrayList<String> getCompatibility(ArrayList<User> userArrayList) {

        int amountGenres = 0;
        int amountGenresCopy;
        for (Map.Entry<String, Integer> e : userArrayList.get(0).getGenresMap().entrySet()) {
            amountGenres += e.getValue();
        }

        ArrayList<String> compatibilities = new ArrayList<String>();

        if (userArrayList.get(0).getAudios().size() > 0) {

            for (int i = 1; i < userArrayList.size(); i++) {

                amountGenresCopy = amountGenres;
                Map<String, Integer> genresCopy = userArrayList.get(0).getGenresMap();

                double persentComp = -1;

                if (userArrayList.get(i).getAudios().size() > 1) {

                    for (Map.Entry<String, Integer> e : userArrayList.get(i).getGenresMap().entrySet()) {

                        if (genresCopy.containsKey(e.getKey())) {

                            int minAmountGen = Math.min(genresCopy.get(e.getKey()), e.getValue());

                            genresCopy.put(e.getKey(), minAmountGen);
                        }
                    }

                    for (Map.Entry<String, Integer> e : genresCopy.entrySet()) {
                        amountGenresCopy -= e.getValue();
                    }

                     persentComp = amountGenresCopy * 100 / amountGenres;
                }else{
                    persentComp = -1.0;
                }

                compatibilities.add(String.valueOf(persentComp));
            }
        }else{
            compatibilities.add(String.valueOf(-2.0));
        }

        return compatibilities;
    }
}
