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
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.BooleanConverter;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
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

    public void executeId() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String txtProperty = request.getParameter("clientForm:vkId");

        setIds(txtProperty);
    }

    public void executeBdate() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String txtProperty = request.getParameter("clientForm:vkBdate");

        setbDates(txtProperty);
    }

    public void executeSex() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String txtProperty = request.getParameter("clientForm:vkSex");

        setSexes(txtProperty);
    }


    private ArrayList<String> ids = new ArrayList<String>();
    private ArrayList<String> bDates = new ArrayList<String>();
    private ArrayList<String> sexes = new ArrayList<String>();


    public void setIds(String ids) {
        this.ids = new Parsing().parse(ids);
    }

    public void setbDates(String bDates) {
        this.bDates = new Parsing().parse(bDates);
    }

    public void setSexes(String sexes) {
        this.sexes = new Parsing().parse(sexes);
    }


    private String pe = "kk";

    public String getPe() {
        return pe;
    }

    public void setPe(String pe) {
        this.pe = pe;
    }

    public ArrayList<String> getIds() {
        return ids;
    }

    public ArrayList<String> getbDates() {
        return bDates;
    }

    public ArrayList<String> getSexes() {
        return sexes;
    }

    private ArrayList<String> compatibilityDescription = new ArrayList<String>();
    private ArrayList<String> interestCompatibility= new ArrayList<String>();

    public void setCompatibilityDescription(ArrayList<String> compatibilityDescription) {
        this.compatibilityDescription = compatibilityDescription;
    }


    public void setInterestCompatibility(ArrayList<String> interestCompatibility) {
        this.interestCompatibility = interestCompatibility;
    }

    public ArrayList<String> getCompatibilityDescription() {
        return compatibilityDescription;
    }

    public ArrayList<String> getInterestCompatibility() {
        return interestCompatibility;
    }


    public void mainClass() {

        ArrayList<User> usersArrayList = new ArrayList<User>();


        IDs fillID = new IDs();
        fillID.fill(usersArrayList, ids);

        BDays bDays = new BDays();
        bDays.fill(usersArrayList, bDates);

        Sex sex = new Sex();
        sex.fill(usersArrayList, sexes);






        HashMap<String, ArrayList<ZodiacsPairs>> zodiacsCompatibilities =
                new ZodiacLoading().getCompatibilities();


        Zodiacs zodiacs = new Zodiacs();
        ArrayList<Zodiac> userZodiacs;
        userZodiacs = zodiacs.getZodiacs(usersArrayList);

        zodiacs.fill(usersArrayList, userZodiacs);

        if (!usersArrayList.get(0).getZodiac().name().equals("Unknown")) {

            ArrayList<ZodiacsPairs> zodiacPairs = zodiacsCompatibilities.get(usersArrayList.get(0).getZodiac().name());

            for (int i = 1; i < usersArrayList.size(); i++) {

                int amountZod = 0;
                for (ZodiacsPairs pair : zodiacPairs) {

                    amountZod++;
                    if (pair.getZodiacName().equals(usersArrayList.get(i).getZodiac().name())) {

                        if (!sex.isTheSameSex(usersArrayList.get(0).getSex(),
                                usersArrayList.get(i).getSex())) {

                            compatibilityDescription.add(pair.getCompatibilityDescriptionLove());
                            interestCompatibility.add(String.valueOf(pair.getInterestCompatibilityLove()));
                        } else {

                            compatibilityDescription.add(pair.getCompatibilityDescription());
                            interestCompatibility.add(String.valueOf(pair.getInterestCompatibilityFriends()));
                        }
                    }
                }
                if(amountZod == 12){
                    compatibilityDescription.add("-");
                    interestCompatibility.add("0");
                }
            }
        }

        pe = compatibilityDescription.get(1);

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
