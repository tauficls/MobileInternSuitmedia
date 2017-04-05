package com.taufic.eventapps.Item;

/**
 * Created by taufic on 3/30/2017.
 */

public class EventItem {
    private int image;
    private String nama;
    private String tanggal;
    private String description;
    private int latitude;
    private int longitude;

    public EventItem() {
        this.image = 0;
        this.nama = "";
        this.tanggal = "";
        this.description = "";
        this.latitude = 0;
        this.longitude = 0;
    }
    public EventItem(int image, String nama, String tanggal, String description, int latitude,
                     int longitude) {
        this.image = image;
        this.nama = nama;
        this.tanggal = tanggal;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
}
