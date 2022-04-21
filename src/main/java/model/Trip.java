package model;

import java.sql.Time;

public class Trip {
    private int trip_no;
    private int ID_cmp;
    private String plane;
    private String town_from;
    private String town_to;
    private Time time_out;
    private Time time_in;

    public int getTrip_no() {
        return trip_no;
    }

    public void setTrip_no(int trip_no) {
        this.trip_no = trip_no;
    }

    public int getID_cmp() {
        return ID_cmp;
    }

    public void setID_cmp(int ID_cmp) {
        this.ID_cmp = ID_cmp;
    }

    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public String getTown_from() {
        return town_from;
    }

    public void setTown_from(String town_from) {
        this.town_from = town_from;
    }

    public String getTown_to() {
        return town_to;
    }

    public void setTown_to(String town_to) {
        this.town_to = town_to;
    }

    public Time getTime_out() {
        return time_out;
    }

    public void setTime_out(Time time_out) {
        this.time_out = time_out;
    }

    public Time getTime_in() {
        return time_in;
    }

    public void setTime_in(Time time_in) {
        this.time_in = time_in;
    }
}
