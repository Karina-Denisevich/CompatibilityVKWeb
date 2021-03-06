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
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;


@ManagedBean(name = "main")
@SessionScoped
public class Main {

    private final String DB_URL = "jdbc:mysql://localhost:3306/groups";
    private final String USER_NAME = "root";
    private final String PASSWORD = "root";


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
        ArrayList<String> list = new Parsing().parse(ids);

        for (String aList : list) {
            this.ids.add(aList);
        }
    }

    public ArrayList<String> getIds() {
        return ids;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(String names) {
        ArrayList<String> list = new Parsing().parse(names);

        for (String aList : list) {
            this.names.add(aList);
        }
    }

    public void setbDates(String bDates) {
        ArrayList<String> list = new Parsing().parse(bDates);

        for (String aList : list) {
            this.bDates.add(aList);
        }
    }

    public ArrayList<String> getbDates() {
        return bDates;
    }

    public void setSexes(String sexes) {
        ArrayList<String> list = new Parsing().parse(sexes);

        for (String aList : list) {
            this.sexes.add(aList);
        }
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


    private ArrayList<String> compatibilityByAudios = new ArrayList<String>();

    public ArrayList<String> getCompatibilityByAudios() {
        return compatibilityByAudios;
    }

    public void setCompatibilityByAudios(ArrayList<String> compatibilityByAudios) {
        this.compatibilityByAudios = compatibilityByAudios;
    }


    private ArrayList<String> resultCompatibility = new ArrayList<String>();

    public ArrayList<String> getResultCompatibility() {
        return resultCompatibility;
    }

    public void setResultCompatibility(ArrayList<String> resultCompatibility) {
        this.resultCompatibility = resultCompatibility;
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

        resultCompatibility = new ResultCompatibility().getResultComparibility(compatibilityByAudios, interestCompatibility);

    }


    public void clearAll() {

        audios = new ArrayList<ArrayList<String>>();
        ids = new ArrayList<String>();
        names = new ArrayList<String>();
        sexes = new ArrayList<String>();
        bDates = new ArrayList<String>();
        compatibilityDescription = new ArrayList<String>();
        compatibilityByAudios = new ArrayList<String>();
        interestCompatibility = new ArrayList<String>();
        resultCompatibility = new ArrayList<String>();
    }
}
