package com.taufic.eventapps.Item;

/**
 * Created by taufic on 3/30/2017.
 */

public class EventItem {
    private int image;
    private String nama;
    private String tanggal;

    public EventItem() {
        this.image = 0;
        this.nama = "";
        this.tanggal = "";
    }
    public EventItem(int image, String nama, String tanggal) {
        this.image = image;
        this.nama = nama;
        this.tanggal = tanggal;
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

}
