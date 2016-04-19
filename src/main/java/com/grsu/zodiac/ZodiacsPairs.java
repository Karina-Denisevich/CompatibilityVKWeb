package com.grsu.zodiac;

public class ZodiacsPairs {

    private String zodiacName;
    private String compatibilityDescription;
    private String  compatibilityDescriptionLove;
    private int interestCompatibilityFriends;
    private int interestCompatibilityLove;

    public ZodiacsPairs(String zodiacName, String compatibilityDescription, String compatibilityDescriptionLove,
                        int interestCompatibilityFriends, int interestCompatibilityLove) {

        this.zodiacName = zodiacName;
        this.compatibilityDescription = compatibilityDescription;
        this.compatibilityDescriptionLove = compatibilityDescriptionLove;
        this.interestCompatibilityFriends = interestCompatibilityFriends;
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

    public int getInterestCompatibilityFriends() {
        return interestCompatibilityFriends;
    }

    public void setInterestCompatibilityFriends(int interestCompatibilityFriends) {
        this.interestCompatibilityFriends = interestCompatibilityFriends;
    }

    public int getInterestCompatibilityLove() {
        return interestCompatibilityLove;
    }

    public void setInterestCompatibilityLove(int interestCompatibilityLove) {
        this.interestCompatibilityLove = interestCompatibilityLove;
    }
}
