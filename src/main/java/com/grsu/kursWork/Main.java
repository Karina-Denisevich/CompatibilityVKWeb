package com.grsu.kursWork;

import com.grsu.audio.Compatibility;
import com.grsu.client.*;
import com.grsu.dataBase.DBWorker;
import com.grsu.dataBase.MusicGroups;
import com.grsu.user.User;
import com.grsu.zodiac.CompatibilityZodiac;
import com.grsu.zodiac.Zodiac;
import com.grsu.zodiac.ZodiacLoading;
import com.grsu.zodiac.ZodiacsPairs;

import java.sql.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;


@ManagedBean(name = "main")
@SessionScoped
public class Main {

    private final String DB_URL = "jdbc:mysql://localhost:3306/groups";
    private final String USER_NAME = "root";
    private final String PASSWORD = "root";


    private Integer amountPeople = 0;

    public Integer getAmountPeople() {
        return amountPeople;
    }

    public void setAmountPeople(Integer amountPeople) {
        this.amountPeople = amountPeople;
    }

    public void executeAmountPeople(){
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String txtProperty = request.getParameter("amountPeopleForm:amountPeople");


        setAmountPeople(Integer.valueOf(txtProperty));
        identificators = new String[Integer.valueOf(txtProperty)];
    }


    String[] identificators;

    public String[] getIdentificators() {
        return identificators;
    }

    public void setIdentificators(String[] identificators) {
        this.identificators = identificators;
    }


//    public void executeIdentificator (){
//        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        String[] txtProperty = request.getParameterValues("validForm:Vkiden");
//
//        System.out.println(request.getParameter("clientForm:Vkiden"));
//
//
//        setIdentificators(txtProperty);
//    }


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


    private ArrayList<String> compatibilityDescription = new ArrayList<String>();
    private ArrayList<String> interestCompatibility = new ArrayList<String>();

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


    private String pe = "kk";

    public String getPe() {
        return pe;
    }

    public void setPe(String pe) {
        this.pe = pe;
    }

    public void mainClass() {

        ArrayList<User> usersArrayList = new ArrayList<User>();

        new IDs().fill(usersArrayList, ids);

        new Name().fill(usersArrayList, names);

        new BDays().fill(usersArrayList, bDates);

        new Sex().fill(usersArrayList, sexes);


        HashMap<String, ArrayList<ZodiacsPairs>> zodiacsCompatibilities =
                new ZodiacLoading().getCompatibilities();


        Zodiacs zodiacs = new Zodiacs();
        ArrayList<Zodiac> userZodiacs;
        userZodiacs = zodiacs.getZodiacs(usersArrayList);

        zodiacs.fill(usersArrayList, userZodiacs);

        ArrayList<ZodiacsPairs> compatZodList =
                new CompatibilityZodiac().getCompatibility(usersArrayList, zodiacsCompatibilities);

        for (int i = 0; i < usersArrayList.size() - 1; i++) {
            compatibilityDescription.add(compatZodList.get(i).getCompatibilityDescription());
            interestCompatibility.add(String.valueOf(compatZodList.get(i).getInterestCompatibility()));
        }

        // audios

        new Audio().fill(usersArrayList, audios);

        //database

        ArrayList<MusicGroups> groupsDatabase = new GroupDataBase().fill(DB_URL, USER_NAME, PASSWORD);

        new Genres().fill(usersArrayList, groupsDatabase);

        setCompatibilityByAudios(new Compatibility().getCompatibility(usersArrayList));


        pe = getCompatibilityByAudios().get(0);
    }
}
