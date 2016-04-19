package com.grsu.zodiac;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public enum Zodiac {
    Aries("21.3.1980-20.4.1980"),
    Taurus("21.4.1980-21.5.1980"),
    Gemini("22.5.1980-21.6.1980"),
    Cancer("22.6.1980-22.7.1980"),
    Leo("23.7.1980-21.8.1980"),
    Virgo("22.8.1980-23.9.1980"),
    Libra("24.9.1980-23.10.1980"),
    Scorpio("24.10.1980-22.11.1980"),
    Sagittarius("23.11.1980-22.12.1980"),
    Capricorn("23.12.1979-20.1.1980"),
    Aquarius("21.1.1980-19.2.1980"),
    Pisces("20.2.1980-20.3.1980"),
    Unknown("");


    private Date firstDate;
    private Date secondDate;

    private ZodiacsPairs zodiacsToCompare;

    Zodiac(String value) {

        DateFormat df = new SimpleDateFormat("d.M.yyyy");

        if(value != "") {

            try {

                this.firstDate = df.parse(value.substring(0, value.indexOf('-')));
                this.secondDate = df.parse(value.substring(value.indexOf('-') + 1));
            } catch (ParseException pe) {

                pe.printStackTrace();
            }
        }
    }

    private boolean isInRange(Date date) {

        return date.before(secondDate) && date.after(firstDate);
    }

    public static Zodiac getZodiac(String value) {

        if (!value.equals("")) {

            if (value.length() > 5) {

                value = value.substring(0, (value.lastIndexOf('.')));
            }

            if (Integer.valueOf(value.substring(0, value.indexOf('.'))) >= 23
                    && value.substring(value.indexOf('.') + 1).equals("12")) {

                value += ".1979";
            } else {

                value += ".1980";
            }
        } else {

            return Zodiac.values()[12];
        }

        DateFormat df = new SimpleDateFormat("d.M.yyyy");

        try {

            Date date = df.parse(value);

            for (Zodiac zod : values()) {

                if (zod.isInRange(date)) {

                    return zod;
                }
            }
        } catch (ParseException pe) {

            pe.printStackTrace();
        }

        return Zodiac.values()[12];
    }
}
