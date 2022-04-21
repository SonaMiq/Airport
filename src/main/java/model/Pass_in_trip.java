package model;

import java.util.Date;

public class Pass_in_trip {

    private int trip_no;
    private int id_psg;
    private Date trip_date;
    private String place;

    public Pass_in_trip(int trip_no, int id_psg, Date trip_date, String place) {
        this.trip_no = trip_no;
        this.id_psg = id_psg;
        this.trip_date = trip_date;
        this.place = place;
    }

    public int getTrip_no() {
        return trip_no;
    }

    public void setTrip_no(int trip_no) {
        this.trip_no = trip_no;
    }

    public int getId_psg() {
        return id_psg;
    }

    public void setId_psg(int id_psg) {
        this.id_psg = id_psg;
    }

    public Date getTrip_date() {
        return trip_date;
    }

    public void setTrip_date(Date trip_date) {
        this.trip_date = trip_date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Pass_in_trip{" +
                "trip_no=" + trip_no +
                ", id_psg=" + id_psg +
                ", trip_date=" + trip_date +
                ", place='" + place + '\'' +
                '}';
    }
}
