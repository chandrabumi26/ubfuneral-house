package com.example.ubfuneralhouse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class letak {

    @Expose
    @SerializedName("id_letak") private String id_letak;
    @Expose
    @SerializedName("blok") private String blok;
    @Expose
    @SerializedName("baris") private String baris;

    public String getId_letak() {
        return id_letak;
    }

    public void setId_letak(String id_letak) {
        this.id_letak = id_letak;
    }

    public String getBlok() {
        return blok;
    }

    public void setBlok(String blok) {
        this.blok = blok;
    }

    public String getBaris() {
        return baris;
    }

    public void setBaris(String baris) {
        this.baris = baris;
    }
}
