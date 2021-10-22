package com.example.ubfuneralhouse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class user_google {

    @Expose
    @SerializedName("id_user_google") private String id_user_google;
    @Expose
    @SerializedName("nama_user_google") private String nama_user_google;
    @Expose
    @SerializedName("email_user_google") private String email_user_google;
    @Expose
    @SerializedName("success") private Boolean success;
    @Expose
    @SerializedName("message") private String message;

    public String getId_user_google() {
        return id_user_google;
    }

    public void setId_user_google(String id_user_google) {
        this.id_user_google = id_user_google;
    }

    public String getNama_user_google() {
        return nama_user_google;
    }

    public void setNama_user_google(String nama_user_google) {
        this.nama_user_google = nama_user_google;
    }

    public String getEmail_user_google() {
        return email_user_google;
    }

    public void setEmail_user_google(String email_user_google) {
        this.email_user_google = email_user_google;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
