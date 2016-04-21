package com.grsu.kursWork;

import com.grsu.audio.Compatibility;
import com.grsu.client.*;
import com.grsu.dataBase.DBWorker;
import com.grsu.dataBase.MusicGroups;
import com.grsu.user.User;
import com.grsu.zodiac.Zodiac;
import com.grsu.zodiac.ZodiacLoading;
import com.grsu.zodiac.ZodiacsPairs;

import java.sql.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
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

    public void executeName() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String txtProperty = request.getParameter("clientForm:vkName");

        setNames(txtProperty);
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

    public void executeAudio() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String txtProperty = request.getParameter("clientForm:vkAudio");

        setAudios(txtProperty);
    }


    private ArrayList<String> ids = new ArrayList<String>();
    private ArrayList<String> names = new ArrayList<String>();
    private ArrayList<String> bDates = new ArrayList<String>();
    private ArrayList<String> sexes = new ArrayList<String>();
    private ArrayList<ArrayList<String>> audios = new ArrayList<ArrayList<String>>();


    public void setIds(String ids) {
        this.ids = new Parsing().parse(ids);
    }
    public ArrayList<String> getIds() {
        return ids;
    }

    public void setNames(String names) {
        this.names = new Parsing().parse(names);
    }

    public void setbDates(String bDates) {
        this.bDates = new Parsing().parse(bDates);
    }
    public ArrayList<String> getbDates() {
        return bDates;
    }

    public void setSexes(String sexes) {
        this.sexes = new Parsing().parse(sexes);
    }
    public ArrayList<String> getSexes() {
        return sexes;
    }

    public void setAudios(String audiosOne) {
        ArrayList<String> a = new Parsing().parse(audiosOne);
        audios.add(a);
    }



    private String pe = "kk";
    public String getPe() {
        return pe;
    }
    public void setPe(String pe) {
        this.pe = pe;
    }





    private ArrayList<String> compatibilityDescription = new ArrayList<String>();
    private ArrayList<String> interestCompatibility= new ArrayList<String>();

    public void setCompatibilityDescription(ArrayList<String> compatibilityDescription) {
        this.compatibilityDescription = compatibilityDescription;
    }

    public ArrayList<String> getCompatibilityDescription() {
        return compatibilityDescription;
    }

    public void setInterestCompatibility(ArrayList<String> interestCompatibility) {
        this.interestCompatibility = interestCompatibility;
    }
    public ArrayList<String> getInterestCompatibility() {
        return interestCompatibility;
    }





    private ArrayList<String> compatibilityByAudios;

    public ArrayList<String> getCompatibilityByAudios() {
        return compatibilityByAudios;
    }

    public void setCompatibilityByAudios(ArrayList<String> compatibilityByAudios) {
        this.compatibilityByAudios = compatibilityByAudios;
    }

    public void mainClass() {

        ArrayList<User> usersArrayList = new ArrayList<User>();


        IDs fillID = new IDs();
        fillID.fill(usersArrayList, ids);

        Name name = new Name();
        name.fill(usersArrayList, names);

        BDays bDays = new BDays();
        bDays.fill(usersArrayList, bDates);

        Sex sex = new Sex();
        sex.fill(usersArrayList, sexes);


        pe= names.get(0)+ " " +names.get(1)+ " " + " " + bDates.get(0)+ " "+bDates.get(1);

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


        // audios

        Audio audio = new Audio();
        audio.fill(usersArrayList, audios);


        //database

        DBWorker dbWorker = new DBWorker();

        ArrayList<MusicGroups> groupsDatabase = new ArrayList<MusicGroups>();

        String query = "select * from groups";

        try {
            Statement statement = dbWorker.getConnection().createStatement();
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
//                for(String s : musicGroups.getGenres()){
//                    System.out.println(s);
//                }
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

//
//        Genres genres = new Genres();
//        genres.fill(usersArrayList, groupsDatabase);
//
//
//        setCompatibilityByAudios(new Compatibility().getCompatibility(usersArrayList));
//
//        pe=compatibilityByAudios.get(0);


    }
}
