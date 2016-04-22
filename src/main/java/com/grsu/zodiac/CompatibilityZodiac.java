package com.grsu.zodiac;

import com.grsu.client.Sex;
import com.grsu.user.User;

import java.util.ArrayList;
import java.util.HashMap;

public class CompatibilityZodiac {

    public ArrayList<ZodiacsPairs> getCompatibility(ArrayList<User> usersArrayList,
                                                    HashMap<String, ArrayList<ZodiacsPairs>> zodiacsCompatibilities) {


        ArrayList<ZodiacsPairs> zodiacsPairses = new ArrayList<ZodiacsPairs>();


        if (!usersArrayList.get(0).getZodiac().name().equals("Unknown")) {

            ArrayList<ZodiacsPairs> zodiacPairs = zodiacsCompatibilities.get(usersArrayList.get(0).getZodiac().name());

            for (int i = 1; i < usersArrayList.size(); i++) {

                ZodiacsPairs oneZodPair = new ZodiacsPairs();

                int amountZod = 0;
                for (ZodiacsPairs pair : zodiacPairs) {

                    amountZod++;
                    if (pair.getZodiacName().equals(usersArrayList.get(i).getZodiac().name())) {

                        if (!new Sex().isTheSameSex(usersArrayList.get(0).getSex(),
                                usersArrayList.get(i).getSex())) {


                            oneZodPair.setCompatibilityDescription(pair.getCompatibilityDescriptionLove());
                            oneZodPair.setInterestCompatibility(String.valueOf(pair.getInterestCompatibilityLove()));
                        } else {

                            oneZodPair.setCompatibilityDescription(pair.getCompatibilityDescription());
                            oneZodPair.setInterestCompatibility(String.valueOf(pair.getInterestCompatibility()));
                        }
                    }
                }
                if (amountZod == 12) {
                    oneZodPair.setCompatibilityDescription("-");
                    oneZodPair.setInterestCompatibility("0");
                }

                zodiacsPairses.add(oneZodPair);
            }
        }


        return zodiacsPairses;
    }
}
