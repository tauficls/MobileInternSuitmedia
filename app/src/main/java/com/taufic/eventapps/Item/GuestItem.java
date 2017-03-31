package com.taufic.eventapps.Item;

/**
 * Created by taufic on 3/31/2017.
 */

public class GuestItem {

    private String id;
    private String name;
    private String dateBirth;

    public GuestItem() {
        id = "";
        name = "";
        dateBirth = "";
    }

    public GuestItem(String id, String name, String dateBirth) {
        this.id = id;
        this.name = name;
        this.dateBirth = dateBirth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

}
