package com.grsu.client;

import com.grsu.dataBase.MusicGroups;
import com.grsu.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Genres implements Filling<ArrayList<MusicGroups>> {

    public void fill(ArrayList<User> usersArrayList, ArrayList<MusicGroups> musicGroups) {

        for (User anUsersArrayList : usersArrayList) {

            Map<String, Integer> gengesMap = new HashMap<String, Integer>();

            for (int j = 0; j < anUsersArrayList.getAudios().size(); j++) {

                for (MusicGroups musicGroup : musicGroups) {

                    if (musicGroup.getGroupName().equalsIgnoreCase(anUsersArrayList.getAudios().get(j))) {

                        for (int p = 0; p < musicGroup.getGenres().size(); p++) {

                            String key = musicGroup.getGenres().get(p);

                            if (gengesMap.containsKey(key)) {
                                gengesMap.put(key, gengesMap.get(key) + 1);
                            } else {
                                gengesMap.put(key, 1);
                            }
                        }

                    }
                }

            }
            anUsersArrayList.setGenresMap(gengesMap);
        }
    }
}
