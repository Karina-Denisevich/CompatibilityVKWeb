package com.grsu.zodiac;

public class ZodiacsPairs {

    private String zodiacName="";
    private String compatibilityDescription="";
    private String  compatibilityDescriptionLove="";
    private int interestCompatibility=0;
    private int interestCompatibilityLove=0;

    public ZodiacsPairs(){};

    public ZodiacsPairs(String zodiacName, String compatibilityDescription, String compatibilityDescriptionLove,
                        int interestCompatibilityFriends, int interestCompatibilityLove) {

        this.zodiacName = zodiacName;
        this.compatibilityDescription = compatibilityDescription;
        this.compatibilityDescriptionLove = compatibilityDescriptionLove;
        this.interestCompatibility = interestCompatibilityFriends;
        this.interestCompatibilityLove = interestCompatibilityLove;
    }

    public String getZodiacName() {
        return zodiacName;
    }

    public void setZodiacName(String zodiacName) {
        this.zodiacName = zodiacName;
    }

    public String getCompatibilityDescription() {
        return compatibilityDescription;
    }

    public void setCompatibilityDescription(String compatibilityDescription) {
        this.compatibilityDescription = compatibilityDescription;
    }

    public String getCompatibilityDescriptionLove() {
        return compatibilityDescriptionLove;
    }

    public void setCompatibilityDescriptionLove(String compatibilityDescriptionLove) {
        this.compatibilityDescriptionLove = compatibilityDescriptionLove;
    }

    public int getInterestCompatibility() {
        return interestCompatibility;
    }

    public void setInterestCompatibility(String interestCompatibility) {
        this.interestCompatibility = Integer.valueOf(interestCompatibility);
    }

    public int getInterestCompatibilityLove() {
        return interestCompatibilityLove;
    }

    public void setInterestCompatibilityLove(String interestCompatibilityLove) {
        this.interestCompatibilityLove = Integer.valueOf(interestCompatibilityLove);
    }
}
