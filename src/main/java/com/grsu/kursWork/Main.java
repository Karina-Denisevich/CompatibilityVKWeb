package com.grsu.kursWork;

import com.grsu.audio.Compatibility;
import com.grsu.client.*;
import com.grsu.dataBase.DBWorker;
import com.grsu.dataBase.MusicGroups;
import com.grsu.fileUtils.Reading;
import com.grsu.user.User;
import com.grsu.zodiac.Zodiac;
import com.grsu.zodiac.ZodiacLoading;
import com.grsu.zodiac.ZodiacsPairs;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.convert.BooleanConverter;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;


@ManagedBean(name = "main")
@SessionScoped
public class Main {

    private ArrayList<User> usersArrayList = new ArrayList<User>();


    private String zod;

    public String getZod() {
        return zod;
    }

    public void setZod(String zod) {
        this.zod = zod;
    }

    public String getUsersArrayList() {
        return String.valueOf(usersArrayList.size());
    }

    public void setUsersArrayList(ArrayList<User> usersArrayList) {
        this.usersArrayList = usersArrayList;
    }

    private ArrayList<String> compatibilityStr = new ArrayList<String>();
    private ArrayList<String> compatibilityNumb = new ArrayList<String>();
    private ArrayList<String> compatibilityAudio = new ArrayList<String>();


    public String getCompatibilityStr() {
        return String.valueOf(compatibilityStr.size());
    }

    public ArrayList<String> getCompatibilityNumb() {
        return compatibilityNumb;
    }


    public ArrayList<String> getCompatibilityAudio() {
        return compatibilityAudio;
    }


    private ArrayList<String> ids = new ArrayList<String>();
    private ArrayList<String> bDates = new ArrayList<String>();
    private ArrayList<String> sexes = new ArrayList<String>();
    private ArrayList<ArrayList<String>> artists = new ArrayList<ArrayList<String>>();


    public ArrayList<ArrayList<String>> getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists.add(new Parsing().parse(artists));
    }


    public ArrayList<String> getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = new Parsing().parse(ids);
    }


    public ArrayList<String> getbDates() {
//        if(bDates.size()>0)
//        return bDates.get(2);
//        else
//            return String.valueOf(bDates.size());
        return bDates;
    }

    public void setbDates(String bDates) {
        this.bDates = new Parsing().parse(bDates);
    }


    public ArrayList<String> getSexes() {
        return sexes;
    }

    public void setSexes(String sexes) {
        this.sexes = new Parsing().parse(sexes);
    }


    private String firstId = "f";
    private String secondId = "s";


    public String getFirstId() {
        return firstId;
    }

    public void setFirstId(String firstId) {
        this.firstId = firstId;
    }

    public String getSecondId() {
        return secondId;
    }

    public void setSecondId(String secondId) {
        this.secondId = secondId;
    }

    private String per = "k";

    public String getPer() {
        return per;
    }


    public void mainClass() throws IOException {

//       compatibilityStr.add("kkf");
//

        ArrayList<User> userList = new ArrayList<User>();

        //IDs fillID = new IDs();
        if(getbDates().size()>0)
        per=getbDates().get(0);
        else  per ="karina";
       // per=fillID.fill(userList, getIds());
//
//        BDays bDays = new BDays();
//        bDays.fill(userList, getbDates());
//
//        Sex sex = new Sex();
//        sex.fill(userList, getSexes());

       // per = getbDates().get(0);
//
//
//
//
        usersArrayList = userList;

//        for (int i = 0; i < userList.size(); i++) {
//            usersArrayList.add(userList.get(i));
//        }


//        IDs fillID = new IDs();
//        fillID.fill(usersArrayList, ids);
//
//        BDays bDays = new BDays();
//        bDays.fill(usersArrayList, bDates);
//
//        Sex sex = new Sex();
//        sex.fill(usersArrayList, sexes);

//
//        HashMap<String, ArrayList<ZodiacsPairs>> zodiacsCompatibilities =
//                new ZodiacLoading().getCompatibilities();
//
//
//        Zodiacs zodiacs = new Zodiacs();
//        ArrayList<Zodiac> userZodiacs;
//        userZodiacs = zodiacs.getZodiacs(usersArrayList);
//        zod = userZodiacs.get(0).name();
//
//        zodiacs.fill(usersArrayList, userZodiacs);
//
//        if (!usersArrayList.get(0).getZodiac().name().equals("Unknown")) {
//
//            ArrayList<ZodiacsPairs> zodiacPairs = zodiacsCompatibilities.get(usersArrayList.get(0).getZodiac().name());
//
//            for (int i = 1; i < usersArrayList.size(); i++) {
//
//                for (ZodiacsPairs pair : zodiacPairs) {
//
//                    if (pair.getZodiacName().equals(usersArrayList.get(i).getZodiac().name())) {
//
//                        if (!sex.isTheSameSex(usersArrayList.get(0).getSex(),
//                                usersArrayList.get(i).getSex())) {
//
//                            compatibilityStr.add(pair.getCompatibilityDescriptionLove());
//                            compatibilityNumb.add(String.valueOf(pair.getInterestCompatibilityLove()));
//                        } else {
//
//                            compatibilityStr.add(pair.getCompatibilityDescription());
//                            compatibilityNumb.add(String.valueOf(pair.getInterestCompatibilityFriends()));
//                        }
//                    }
//                }
//            }
//        }

//return null;
        // audios

//        Audios audios = new Audios();
//        ArrayList<ArrayList<String>> usersAudios = audios.getAudios(usersArrayList, vk, accessToken);
//        audios.fill(usersArrayList, usersAudios);
//
//
//
//        //database
//
//        DBWorker dbWorker = new DBWorker();
//
//        ArrayList<MusicGroups> groupsDatabase = new ArrayList<MusicGroups>();
//
//        String query = "select * from groups";
//
//        try {
//            Statement statement = dbWorker.getConnection().createStatement();
//            ResultSet resultSet = statement.executeQuery(query);
//
//            while (resultSet.next()) {
//
//                MusicGroups musicGroups = new MusicGroups();
//
//                musicGroups.setGroupName(resultSet.getString(2));
//                musicGroups.setGenres(resultSet.getString(3));
//
//                groupsDatabase.add(musicGroups);
//
////                for(String s : musicGroups.getGenres()){
////                    System.out.println(s);
////                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//
//        Genres genres = new Genres();
//        genres.fill(usersArrayList, groupsDatabase);
//
//
//
//        new Compatibility().getCompatibility(usersArrayList);
    }


}
