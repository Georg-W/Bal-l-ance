package com.example.ersgutercomputer.ballance;

/**
 * Created by Georg on 12.11.2016.
 */

public class Save {

    private long id;
    private int level;
    private String player;
    private String time;

    public long getId() {
        return id;
    }
    public int getLevel() {
        return level;
    }
    public String getPlayer(){
        return player;
    }
    public String getTime() {
        return time;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setPlayer(String player) {
        this.player = player;
    }
    public void setTime(String time) {
        this.time = time;
    }
    @Override
    public String toString() {
        return player+" "+time;
    }
}
