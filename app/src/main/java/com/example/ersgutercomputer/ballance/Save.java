package com.example.ersgutercomputer.ballance;

/**
 * Created by Georg on 12.11.2016.
 */

public class Save {

    private String playerString;
    private String timeString;


    public Save(String playerStringString, String timeString){
        this.playerString = playerStringString;
        this.timeString = timeString;
    }

    public String getPlayerString(){
        return playerString;
    }
    public String getTimeString() {
        return timeString;
    }
}
